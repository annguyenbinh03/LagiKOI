package com.lagikoi.be.exception;

import com.lagikoi.be.dto.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalHandlerException {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ApiResponse> handleException(Exception exception) {
        return ResponseEntity.badRequest().body(
                ApiResponse.builder()
                        .code(ErrorCode.UNCATEGORIZED_EXCEPTION.getCode())
                        .message(ErrorCode.UNCATEGORIZED_EXCEPTION.getMessage() + ":" + exception.getMessage())
                        .build()
        );
    }

    @ExceptionHandler(value = AppException.class)
    ResponseEntity<ApiResponse> handleAppException(AppException exception) {
        ErrorCode errorCode = exception.getErrorCode();
        return ResponseEntity.badRequest().body(
                ApiResponse.builder()
                        .code(errorCode.getCode())
                        .message(errorCode.getMessage())
                        .build()
        );
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<ApiResponse> handleValidation(MethodArgumentNotValidException exception) {

        ErrorCode errorCode = ErrorCode.INVALID_KEY_EXCEPTION;
        String errorCodekey = exception.getFieldError().getDefaultMessage();
        try {
            errorCode = ErrorCode.valueOf(errorCodekey);
        }catch (IllegalArgumentException e) {
            log.error(exception.getMessage());
        }

        return ResponseEntity.badRequest().body(
                ApiResponse.builder()
                        .code(errorCode.getCode())
                        .message(errorCode.getMessage())
                        .build()
        );
    }



}
