package com.lagikoi.be.service;

import com.lagikoi.be.dto.request.FishCreationRequest;
import com.lagikoi.be.dto.request.FishImagesCreationRequest;
import com.lagikoi.be.dto.response.FishDetailReponse;
import com.lagikoi.be.dto.response.FishGetAllResponse;
import com.lagikoi.be.entity.KoiFish;
import com.lagikoi.be.entity.KoiFishCategory;
import com.lagikoi.be.entity.KoiFishImageUrl;
import com.lagikoi.be.entity.Product;
import com.lagikoi.be.exception.AppException;
import com.lagikoi.be.exception.ErrorCode;
import com.lagikoi.be.mapper.KoiFishImageUrlMapper;
import com.lagikoi.be.mapper.KoiFishMapper;
import com.lagikoi.be.mapper.ProductMapper;
import com.lagikoi.be.repository.FishCategoryRepository;
import com.lagikoi.be.repository.FishImageUrlRepository;
import com.lagikoi.be.repository.FishRepository;
import com.lagikoi.be.repository.ProductRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FishService {
    FishRepository fishRepository;
    ProductRepository productRepository;
    FishCategoryRepository fishCategoryRepository;
    FishImageUrlRepository fishImageUrlRepository;

    KoiFishMapper fishMapper;
    ProductMapper productMapper;
    KoiFishImageUrlMapper koiFishImageUrlMapper;

    public List<FishGetAllResponse> getAllFish() {
        List<FishGetAllResponse> fishGetAllResponseList = fishRepository.getAllFish();

        if (fishGetAllResponseList.isEmpty())
            throw new AppException(ErrorCode.FISH_LIST_NOT_FOUND);

        getPrimaryImageForFish(fishGetAllResponseList);

        return fishGetAllResponseList;
    }

    public FishDetailReponse getFishInfo(Integer fishId) {
        FishDetailReponse response = fishRepository.getFishInfo(fishId);

        if (response == null)
            throw new AppException(ErrorCode.FISH_NOT_FOUND);

        response.setImages(fishImageUrlRepository.getAllFishImageUrls(fishId));

        return response;
    }

    @Transactional
    public Integer createFish(FishCreationRequest request) {

        //create product
        Product product = productMapper.prepareProductForSave(request);
        productRepository.save(product);

        //get category
        KoiFishCategory category = fishCategoryRepository.getKoiFishCategoriesByName(request.getCategory())
                .orElseThrow(() -> new AppException(ErrorCode.FISH_CATEGORY_NOT_FOUND));

        //createFish
        KoiFish koiFish = fishMapper.prepareKoiFishForSave(request, category, product);
        fishRepository.save(koiFish);

        //set images
        saveImagesForFish(request.getImageUrls(), koiFish);

        return koiFish.getId();
    }

    private void getPrimaryImageForFish(List<FishGetAllResponse> fishGetAllResponseList) {
        for (FishGetAllResponse fishGetAllResponse : fishGetAllResponseList) {
            fishGetAllResponse.setImageUrls(
                    Collections.singletonList(fishImageUrlRepository.getFishPrimaryImageUrls(fishGetAllResponse.getId()))) ;
        }
    }

    private void saveImagesForFish(List<FishImagesCreationRequest> requestFishImages, KoiFish koiFish) {
        for (FishImagesCreationRequest fishImagesCreationRequest : requestFishImages){
            KoiFishImageUrl fishImage = koiFishImageUrlMapper.prepareKoiFishImageUrlForSave(fishImagesCreationRequest, koiFish);
            fishImageUrlRepository.save(fishImage);
        }
    }

}
