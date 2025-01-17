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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

        if (fishGetAllResponseList.isEmpty())
            throw new AppException(ErrorCode.FISH_LIST_NOT_FOUND);

        return fishGetAllResponseList;
    }

    public List<FishGetAllResponse> getFish(Integer page, Integer size, String sortBy, String order, String name, String gender, String farmName, String categoryName) {

        name = "all".equals(name) ? null : name;
        gender = "all".equals(gender) ? null : gender;
        farmName = "all".equals(farmName) ? null : farmName;
        categoryName = "all".equals(categoryName) ? null : categoryName;
        Sort.Direction sortDirection = "asc".equalsIgnoreCase(order) ? Sort.Direction.ASC : Sort.Direction.DESC;

        Page<FishGetAllResponse> fishPage = fishRepository.getFish( PageRequest.of(page, size, Sort.by(sortDirection, sortBy)), name, gender, farmName, categoryName);

        List<FishGetAllResponse> fishGetAllResponseList = fishPage.getContent().stream().toList();

        if (fishGetAllResponseList.isEmpty())
            throw new AppException(ErrorCode.FISH_LIST_NOT_FOUND);

        return fishGetAllResponseList;
    }

    public FishDetailReponse getFishInfo(Integer fishId) {
        FishDetailReponse response = fishRepository.getFishInfo(fishId);

        if (response == null)
            throw new AppException(ErrorCode.FISH_NOT_FOUND);

        response.setImages(productImageRepository.getProductImageByFishId(fishId));
        return response;
    }

    public long getTotalAvailableFish() {
        return fishRepository.countAvailableFish();
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

    private void saveImagesForFish(List<ProductImageCreationRequest> requestFishImages, Product product) {
        for (ProductImageCreationRequest fishImagesCreationRequest : requestFishImages) {
            ProductImage fishImage = productImageMapper.prepareProductImageForSave(fishImagesCreationRequest, product);
            productImageRepository.save(fishImage);
        }
    }

}
