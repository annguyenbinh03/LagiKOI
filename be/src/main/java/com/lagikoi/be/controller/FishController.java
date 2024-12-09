package com.lagikoi.be.controller;

import com.lagikoi.be.dto.request.FishCreationRequest;
import com.lagikoi.be.dto.response.ApiResponse;
import com.lagikoi.be.dto.response.FishResponse;
import com.lagikoi.be.service.FishService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fish")
public class FishController {
    private final FishService fishService;

    @GetMapping("/get-all")
    public ApiResponse<List<FishResponse>> getAllFish() {
        ApiResponse<List<FishResponse>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(fishService.getAllFish());
        apiResponse.setCode(1000);
        return apiResponse;
    }

    @GetMapping("/{fishId}")
    public ApiResponse<FishResponse> getAllFish(@PathVariable Integer fishId) {
        ApiResponse<FishResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(fishService.getFishInfo(fishId));
        apiResponse.setCode(1000);
        return apiResponse;
    }

    @PostMapping("/create")
    public ApiResponse<Integer> createFish(@RequestBody FishCreationRequest request) {
        ApiResponse<Integer> apiResponse = new ApiResponse<>();
        apiResponse.setResult(fishService.createFish(request));
        apiResponse.setCode(201);
        return apiResponse;
    }
}
