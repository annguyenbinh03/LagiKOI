package com.lagikoi.be.service;

import com.lagikoi.be.dto.response.FishResponse;
import com.lagikoi.be.entity.KoiFish;
import com.lagikoi.be.repository.FishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FishService {
    private final FishRepository fishRepository;

    public List<FishResponse> getAllFish(){
        List<Object[]> result = fishRepository.getAllFish();
        List<FishResponse> fishResponseList = new ArrayList<>();

        for (Object[] row : result) {
            FishResponse fishResponse = new FishResponse();

            fishResponse.setId((Integer) row[0]);
            fishResponse.setName((String) row[1]);
            fishResponse.setDescription((String) row[2]);
            fishResponse.setPrice((BigDecimal) row[3]);
            fishResponse.setAge((String) row[4]);
            fishResponse.setGender((String) row[5]);
            fishResponse.setSize((String) row[6]);
            fishResponse.setFarmName((String) row[7]);
            fishResponse.setViewCount((Integer) row[8]);
            fishResponse.setCategory((String) row[9]);

            String imageUrlsString = (String) row[10];
            List<String> imageUrls = Arrays.asList(imageUrlsString.split(","));
            fishResponse.setImageUrls(imageUrls);

            fishResponseList.add(fishResponse);
        }

        return fishResponseList;
    }
}
