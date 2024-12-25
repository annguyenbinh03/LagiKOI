package com.lagikoi.be.service;

import com.lagikoi.be.dto.request.AccessoryCreationRequest;
import com.lagikoi.be.dto.request.FishCreationRequest;
import com.lagikoi.be.dto.request.ProductImageCreationRequest;
import com.lagikoi.be.dto.response.AccessoryDetailResponse;
import com.lagikoi.be.dto.response.AccessoryGetAllResponse;
import com.lagikoi.be.entity.*;
import com.lagikoi.be.exception.AppException;
import com.lagikoi.be.exception.ErrorCode;
import com.lagikoi.be.mapper.AccessoryMapper;
import com.lagikoi.be.mapper.ProductImageMapper;
import com.lagikoi.be.mapper.ProductMapper;
import com.lagikoi.be.repository.AccessoryCategoryRepository;
import com.lagikoi.be.repository.AccessoryRepository;
import com.lagikoi.be.repository.ProductImageRepository;
import com.lagikoi.be.repository.ProductRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AccessoryService {
    AccessoryRepository accessoryRepository;
    ProductImageRepository productImageRepository;

    AccessoryMapper accessoryMapper;
    ProductMapper productMapper;
    ProductRepository productRepository;
    private final AccessoryCategoryRepository accessoryCategoryRepository;
    private final ProductImageMapper productImageMapper;

    public List<AccessoryGetAllResponse> getAllAccessory() {
        List<AccessoryGetAllResponse> accessoryGetAllResponseList = accessoryRepository.getAllAccessory();

        if (accessoryGetAllResponseList.isEmpty())
            throw new AppException(ErrorCode.ACCESSORY_LIST_NOT_FOUND);

        return accessoryGetAllResponseList;
    }

    public AccessoryDetailResponse getAccessoryInfo(Integer accessoryId) {
        AccessoryDetailResponse response = accessoryRepository.getAccessoryInfo(accessoryId);

        if (response == null)
            throw new AppException(ErrorCode.ACCESSORY_NOT_FOUND);

        response.setImages(productImageRepository.getProductImageByAccessoryId(accessoryId));

        return response;
    }

    @PreAuthorize("hasAuthority('CREATE_ACCESSORY')")
    @Transactional
    public Integer create(AccessoryCreationRequest request) {

        //create product
        Product product = productMapper.prepareProductForSave(request);
        productRepository.save(product);

        //get category
        AccessoryCategory category = accessoryCategoryRepository.findAccessoryCategoryByName(request.getCategory())
                .orElseThrow(() -> new AppException(ErrorCode.ACCESSORY_CATEGORY_NOT_FOUND));

        //create Accessory
        Accessory accessory = accessoryMapper.prepareAccessoryForSave(request, category, product);
        accessoryRepository.save(accessory);

        //set images
        saveImagesForAccessory(request.getImages(), product);

        return accessory.getId();
    }

    @PreAuthorize("hasAuthority('DELETE_ACCESSORY')")
    public void delete(Integer accessoryId) {
        Accessory accessory = accessoryRepository.findById(accessoryId).orElseThrow(() -> new AppException(ErrorCode.ACCESSORY_NOT_FOUND));
        accessory.setIsDeleted(true);
        accessoryRepository.save(accessory);
    }

    private void saveImagesForAccessory(List<ProductImageCreationRequest> requestAccessoryImages, Product product) {
        for (ProductImageCreationRequest fishImagesCreationRequest : requestAccessoryImages) {
            ProductImage accessoryImage = productImageMapper.prepareProductImageForSave(fishImagesCreationRequest, product);
            productImageRepository.save(accessoryImage);
        }
    }
}
