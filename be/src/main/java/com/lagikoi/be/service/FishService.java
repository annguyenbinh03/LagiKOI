package com.lagikoi.be.service;

import com.lagikoi.be.dto.request.FishCreationRequest;
import com.lagikoi.be.dto.request.ProductImageCreationRequest;
import com.lagikoi.be.dto.response.FishDetailReponse;
import com.lagikoi.be.dto.response.FishGetAllResponse;
import com.lagikoi.be.entity.Fish;
import com.lagikoi.be.entity.FishCategory;
import com.lagikoi.be.entity.Product;
import com.lagikoi.be.entity.ProductImage;
import com.lagikoi.be.exception.AppException;
import com.lagikoi.be.exception.ErrorCode;
import com.lagikoi.be.mapper.FishMapper;
import com.lagikoi.be.mapper.ProductImageMapper;
import com.lagikoi.be.mapper.ProductMapper;
import com.lagikoi.be.repository.FishCategoryRepository;
import com.lagikoi.be.repository.ProductImageRepository;
import com.lagikoi.be.repository.FishRepository;
import com.lagikoi.be.repository.ProductRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FishService {
    FishRepository fishRepository;
    ProductRepository productRepository;
    FishCategoryRepository fishCategoryRepository;
    ProductImageRepository productImageRepository;

    FishMapper fishMapper;
    ProductMapper productMapper;
    ProductImageMapper productImageMapper;

    public List<FishGetAllResponse> getAllFish() {
        List<FishGetAllResponse> fishGetAllResponseList = fishRepository.getAllFish();

        for (FishGetAllResponse fishGetAllResponse : fishGetAllResponseList) {
            fishGetAllResponse.setCode(generateCodeForFish(fishGetAllResponse.getId()));
        }

        if (fishGetAllResponseList.isEmpty())
            throw new AppException(ErrorCode.FISH_LIST_NOT_FOUND);

        return fishGetAllResponseList;
    }

    public FishDetailReponse getFishInfo(Integer fishId) {
        FishDetailReponse response = fishRepository.getFishInfo(fishId);

        if (response == null)
            throw new AppException(ErrorCode.FISH_NOT_FOUND);

        response.setCode(generateCodeForFish(fishId));

        response.setImages(productImageRepository.getProductImageByFishId(fishId));

        return response;
    }

    @Transactional
    public Integer createFish(FishCreationRequest request) {

        //create product
        Product product = productMapper.prepareProductForSave(request);
        productRepository.save(product);

        //get category
        FishCategory category = fishCategoryRepository.getKoiFishCategoriesByName(request.getCategory())
                .orElseThrow(() -> new AppException(ErrorCode.FISH_CATEGORY_NOT_FOUND));

        //createFish
        Fish fish = fishMapper.prepareKoiFishForSave(request, category, product);
        fishRepository.save(fish);

        //set images
        saveImagesForFish(request.getImageUrls(), product);

        return fish.getId();
    }

    public static String generateCodeForFish(int id) {
        return id < 1000 ? String.format("#%03d", id) : "#" + id;
    }

    private void saveImagesForFish(List<ProductImageCreationRequest> requestFishImages, Product product) {
        for (ProductImageCreationRequest fishImagesCreationRequest : requestFishImages) {
            ProductImage fishImage = productImageMapper.prepareProductImageForSave(fishImagesCreationRequest, product);
            productImageRepository.save(fishImage);
        }
    }

}
