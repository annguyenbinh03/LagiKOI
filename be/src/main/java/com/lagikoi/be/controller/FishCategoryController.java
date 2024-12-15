package com.lagikoi.be.controller;

import com.lagikoi.be.dto.request.FishCategoryCreationRequest;
import com.lagikoi.be.dto.response.ApiResponse;
import com.lagikoi.be.dto.response.FishCategoryResponse;
import com.lagikoi.be.service.FishCategoryService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fish-category")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FishCategoryController {
    FishCategoryService fishCategoryService;

    @GetMapping("/get-all")
    public ApiResponse<List<FishCategoryResponse>> getAllFishCategories() {
        return ApiResponse.<List<FishCategoryResponse>>builder()
                .result(fishCategoryService.getAllFishCategory())
                .build();
    }

    @PostMapping("/create")
    public ApiResponse<Integer> createFishCategory(@Valid @RequestBody FishCategoryCreationRequest request){
        return ApiResponse.<Integer>builder()
                .result(fishCategoryService.createFishCategory(request))
                .build();
    }
}
