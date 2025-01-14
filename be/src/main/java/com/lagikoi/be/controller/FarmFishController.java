package com.lagikoi.be.controller;

import com.lagikoi.be.dto.request.FarmFishCreationRequest;
import com.lagikoi.be.dto.request.FarmFishUpdateRequest;
import com.lagikoi.be.dto.response.ApiResponse;
import com.lagikoi.be.dto.response.FarmFishGetAllResponse;
import com.lagikoi.be.service.FarmFishService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/farm-fish")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FarmFishController {
    FarmFishService farmFishService;

    @GetMapping("/get-all")
    public ApiResponse<List<FarmFishGetAllResponse>> getAllFarmFish(){
        return ApiResponse.<List<FarmFishGetAllResponse>>builder()
                .result(farmFishService.getAllFarmFish())
                .build();
    }

    @GetMapping("/detail/{id}")
    public ApiResponse<FarmFishGetAllResponse> getFarmFishInfo(@PathVariable Integer id){
        return ApiResponse.<FarmFishGetAllResponse>builder()
                .result(farmFishService.getFarmFishInfo(id))
                .build();
    }

    @PostMapping("/create")
    public ApiResponse<Integer> createFarmFish(@RequestBody @Valid FarmFishCreationRequest request){
        return ApiResponse.<Integer>builder()
                .result(farmFishService.createFarmFish(request))
                .build();
    }

    @PutMapping("/update")
    public ApiResponse<FarmFishGetAllResponse> updateFarmFish(@RequestBody @Valid FarmFishUpdateRequest request){
        return ApiResponse.<FarmFishGetAllResponse>builder()
                .result(farmFishService.updateFarmFish(request))
                .build();
    }
}
