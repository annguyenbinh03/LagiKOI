package com.lagikoi.be.service;

import com.lagikoi.be.dto.request.FishCreationRequest;
import com.lagikoi.be.dto.response.FishResponse;
import com.lagikoi.be.entity.KoiFish;
import com.lagikoi.be.entity.KoiFishCategory;
import com.lagikoi.be.entity.Product;
import com.lagikoi.be.repository.FishCategoryRepository;
import com.lagikoi.be.repository.FishRepository;
import com.lagikoi.be.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FishService {
    private final FishRepository fishRepository;
    private final ProductRepository productRepository;
    private final FishCategoryRepository fishCategoryRepository;

    public List<FishResponse> getAllFish() {
        List<Object[]> result = fishRepository.getAllFish();
        List<FishResponse> fishResponseList = new ArrayList<>();

        if (result.isEmpty()) {
            throw new RuntimeException("The list is empty");
        }

        for (Object[] row : result) {
            fishResponseList.add(setInfoForFish(row));
        }

        return fishResponseList;
    }

    public FishResponse getFishInfo(Integer fishId) {
        Object[] result = fishRepository.getFishInfo(fishId);
        if (result == null || result.length == 0) {
            throw new RuntimeException("Not Found Fish");
        }

        return setInfoForFish((Object[]) result[0]);
    }

    private FishResponse setInfoForFish(Object[] rowData) {
        FishResponse fishResponse = new FishResponse();

        Integer fishId = 0;
        if((Integer) rowData[0] == null) {
            throw new RuntimeException("Fish Id is null");
        }else{
            fishId = (Integer) rowData[0];
        }

        fishResponse.setId(fishId);
        fishResponse.setName((String) rowData[1]);
        fishResponse.setDescription((String) rowData[2]);
        fishResponse.setPrice((BigDecimal) rowData[3]);
        fishResponse.setStock((Integer) rowData[4]);
        fishResponse.setAge((String) rowData[5]);
        fishResponse.setGender((String) rowData[6]);
        fishResponse.setSize((String) rowData[7]);
        fishResponse.setFarmName((String) rowData[8]);
        fishResponse.setViewCount((Integer) rowData[9]);
        fishResponse.setCategory((String) rowData[10]);

        String imageUrlsString = (String) rowData[11];
        if (imageUrlsString != null && !imageUrlsString.isEmpty()) {
            List<String> imageUrls = Arrays.asList(imageUrlsString.split(","));
            fishResponse.setImageUrls(imageUrls);
        } else {
            fishResponse.setImageUrls(Collections.emptyList());
        }

        //set code for fish
        if (fishId < 1000) {
            fishResponse.setCode(String.format("#%03d", fishId));
        } else {
            fishResponse.setCode("#" + fishId);
        }

        return fishResponse;
    }

    public Integer createFish(FishCreationRequest request) {

        //create product
        Product product = new Product();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());
        product.setCreatedAt(Instant.now());
        productRepository.save(product);

        //get category
        KoiFishCategory category = fishCategoryRepository.getKoiFishCategoriesByName(request.getCategory());
        if(category == null) {
            throw new RuntimeException("Fish Category not found");
        }

        //createFish
        KoiFish koiFish = new KoiFish();
        koiFish.setCategory(category);
        koiFish.setProduct(product);
        koiFish.setAge(request.getAge());
        koiFish.setGender(request.getGender());
        koiFish.setSize(request.getSize());
        koiFish.setFarmName(request.getFarmName());
        koiFish.setImageUrls( String.join("," ,request.getImageUrls()) );
        koiFish.setViewCount(0);
        fishRepository.save(koiFish);

        return koiFish.getId();
    }
}
