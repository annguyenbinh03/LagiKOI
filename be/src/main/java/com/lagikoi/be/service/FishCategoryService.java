package com.lagikoi.be.service;

import com.lagikoi.be.dto.request.FishCategoryCreationRequest;
import com.lagikoi.be.dto.response.FishCategoryResponse;
import com.lagikoi.be.entity.KoiFishCategory;
import com.lagikoi.be.repository.FishCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FishCategoryService {
    private final FishCategoryRepository fishCategoryRepository;

    public List<FishCategoryResponse> getAllFishCategory(){
        List<KoiFishCategory> fishCategorys = fishCategoryRepository.findAll();
        if(fishCategorys == null || fishCategorys.isEmpty()) {
            throw new RuntimeException("Not find any fish category");
        }
        List<FishCategoryResponse> fishCategoryResponses = new ArrayList<>();
        for (KoiFishCategory fishCategory : fishCategorys) {
            FishCategoryResponse fishCategoryResponse = new FishCategoryResponse();
            fishCategoryResponse.setId(fishCategory.getId());
            fishCategoryResponse.setName(fishCategory.getName());
            fishCategoryResponse.setDescription(fishCategory.getDescription());
            fishCategoryResponses.add(fishCategoryResponse);
        }
        return fishCategoryResponses;
    }

    public Integer createFishCategory(FishCategoryCreationRequest request) {
        KoiFishCategory fishCategory = new KoiFishCategory();
        fishCategory.setName(request.getName());
        fishCategory.setDescription(request.getDescription());
        fishCategoryRepository.save(fishCategory);
        return fishCategory.getId();
    }
}
