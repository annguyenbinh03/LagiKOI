package com.lagikoi.be.service;

import com.lagikoi.be.dto.request.FishCategoryCreationRequest;
import com.lagikoi.be.dto.response.FishCategoryResponse;
import com.lagikoi.be.entity.FishCategory;
import com.lagikoi.be.exception.AppException;
import com.lagikoi.be.exception.ErrorCode;
import com.lagikoi.be.repository.FishCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FishCategoryService {
    private final FishCategoryRepository fishCategoryRepository;

    public List<FishCategoryResponse> getAllFishCategory(){
        List<FishCategory> fishCategories = fishCategoryRepository.findAll();
        if(fishCategories.isEmpty())
            throw new AppException(ErrorCode.FISH_CATEGORY_NOT_FOUND);
        List<FishCategoryResponse> fishCategoryResponses = new ArrayList<>();
        for (FishCategory fishCategory : fishCategories) {
            FishCategoryResponse fishCategoryResponse = new FishCategoryResponse();
            fishCategoryResponse.setId(fishCategory.getId());
            fishCategoryResponse.setName(fishCategory.getName());
            fishCategoryResponse.setDescription(fishCategory.getDescription());
            fishCategoryResponses.add(fishCategoryResponse);
        }
        return fishCategoryResponses;
    }

    @PreAuthorize("hasAuthority('CREATE_FISH_CATEGORY')")
    public Integer createFishCategory(FishCategoryCreationRequest request) {
        FishCategory fishCategory = new FishCategory();
        fishCategory.setName(request.getName());
        fishCategory.setDescription(request.getDescription());
        fishCategory.setIsDeleted(false);
        fishCategoryRepository.save(fishCategory);
        return fishCategory.getId();
    }
}
