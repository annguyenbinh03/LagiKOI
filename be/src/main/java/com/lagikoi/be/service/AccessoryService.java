package com.lagikoi.be.service;

import com.lagikoi.be.dto.response.AccessoryDetailResponse;
import com.lagikoi.be.dto.response.AccessoryGetAllResponse;
import com.lagikoi.be.exception.AppException;
import com.lagikoi.be.exception.ErrorCode;
import com.lagikoi.be.repository.AccessoryRepository;
import com.lagikoi.be.repository.ProductImageRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AccessoryService {
    AccessoryRepository accessoryRepository;
    ProductImageRepository productImageRepository;

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
}
