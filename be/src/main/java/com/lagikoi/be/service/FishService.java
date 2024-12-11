package com.lagikoi.be.service;

import com.lagikoi.be.dto.request.FishCreationRequest;
import com.lagikoi.be.dto.request.FishImagesCreationRequest;
import com.lagikoi.be.dto.response.FishDetailReponse;
import com.lagikoi.be.dto.response.FishGetAllResponse;
import com.lagikoi.be.entity.KoiFish;
import com.lagikoi.be.entity.KoiFishCategory;
import com.lagikoi.be.entity.KoiFishImageUrl;
import com.lagikoi.be.entity.Product;
import com.lagikoi.be.repository.FishCategoryRepository;
import com.lagikoi.be.repository.FishImageUrlRepository;
import com.lagikoi.be.repository.FishRepository;
import com.lagikoi.be.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.Instant;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FishService {
    private final FishRepository fishRepository;
    private final ProductRepository productRepository;
    private final FishCategoryRepository fishCategoryRepository;
    private final FishImageUrlRepository fishImageUrlRepository;

    public List<FishGetAllResponse> getAllFish() {
        List<FishGetAllResponse> fishGetAllResponseList = fishRepository.getAllFish();

        if (fishGetAllResponseList.isEmpty())
            throw new RuntimeException("The list is empty");

        getPrimaryImageForFish(fishGetAllResponseList);

        return fishGetAllResponseList;
    }

    public FishDetailReponse getFishInfo(Integer fishId) {
        FishDetailReponse response = fishRepository.getFishInfo(fishId);

        if (response == null) {
            throw new RuntimeException("Fish with ID " + fishId + " not found");
        }

        response.setImages(fishImageUrlRepository.getAllFishImageUrls(fishId));

        return response;
    }

    @Transactional
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
        koiFish.setIsDeleted(false);
        koiFish.setViewCount(0);
        fishRepository.save(koiFish);

        //set images
        for (FishImagesCreationRequest fishImagesCreationRequest : request.getImageUrls()){
            KoiFishImageUrl fishImage = new KoiFishImageUrl();
            fishImage.setImageUrl(fishImagesCreationRequest.getImageUrl());
            fishImage.setDisplayOrder(fishImagesCreationRequest.getDisplayOrder());
            fishImageUrlRepository.save(fishImage);
        }

        return koiFish.getId();
    }

    private void getPrimaryImageForFish(List<FishGetAllResponse> fishGetAllResponseList) {
        for (FishGetAllResponse fishGetAllResponse : fishGetAllResponseList) {
            fishGetAllResponse.setImageUrls(
                    Collections.singletonList(fishImageUrlRepository.getFishPrimaryImageUrls(fishGetAllResponse.getId()))) ;
        }
    }

}
