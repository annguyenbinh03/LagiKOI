package com.lagikoi.be.service;

import com.lagikoi.be.dto.request.AuthenticationRequest;
import com.lagikoi.be.dto.request.IntrospectRequest;
import com.lagikoi.be.dto.response.AuthenticationResponse;
import com.lagikoi.be.dto.response.IntrospectResponse;
import com.lagikoi.be.entity.User;
import com.lagikoi.be.exception.AppException;
import com.lagikoi.be.exception.ErrorCode;
import com.lagikoi.be.repository.UserRepository;
import com.lagikoi.be.repository.UserRoleRepository;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.StringJoiner;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationService {
    UserRepository userRepository;
    UserRoleRepository userRoleRepository;

    @NonFinal
    @Value("${jwt.signerKey}")
    private String SIGNER_KEY;

    public IntrospectResponse introspect(IntrospectRequest request) throws JOSEException, ParseException {
        String token = request.getToken();

        JWSVerifier verifier = new MACVerifier(SIGNER_KEY.getBytes());

        SignedJWT signedJWT = SignedJWT.parse(token);

        boolean verified = signedJWT.verify(verifier);

        Date expiryTime = signedJWT.getJWTClaimsSet().getExpirationTime();

        return IntrospectResponse.builder()
                .valid( verified && expiryTime.after(new Date()))
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        boolean authenticated = passwordEncoder.matches(request.getPassword(), user.getPassword());

        if (!authenticated)
            throw new AppException(ErrorCode.UNAUTHENTICATED);

        List<String> roleNames = userRoleRepository.findRoleNamesByUserId(user.getId());

        String token = generateToken(user, roleNames);

        return AuthenticationResponse.builder()
                .token(token)
                .authenticated(true)
                .build();
    }

    private String generateToken(User user,List<String> roleNames) {
        JWSHeader jwsHeader = new JWSHeader(JWSAlgorithm.HS512);
        JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                .subject(user.getUsername())
                .issuer("lagikoi")
                .issueTime(new Date())
                .expirationTime(new Date(
                        Instant.now().plus(5, ChronoUnit.HOURS).toEpochMilli()
                ))
                .claim("scope", buildScope(roleNames))
                .build();
        Payload payload = new Payload(claimsSet.toJSONObject());

        JWSObject jwsObject = new JWSObject(jwsHeader, payload);

        try {
            jwsObject.sign(new MACSigner(SIGNER_KEY.getBytes()));
            return jwsObject.serialize();
        } catch (JOSEException e) {
            log.error("Cannot create token:", e);
            throw new AppException(ErrorCode.TOKEN_CREATION);
        }
    }

    private String buildScope(List<String> roleNames) {
        StringJoiner stringJoiner = new StringJoiner(" "); //convention for scope in oath2
        if(!CollectionUtils.isEmpty(roleNames)){
            roleNames.forEach(stringJoiner::add);
        }
        return stringJoiner.toString();
    }
}
