package com.lagikoi.be.controller;

import com.lagikoi.be.dto.response.ApiResponse;
import com.lagikoi.be.dto.response.FarmFishGetAllResponse;
import com.lagikoi.be.service.FarmFishService;
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
}
