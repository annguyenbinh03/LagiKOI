package com.lagikoi.be.controller;

import com.lagikoi.be.dto.request.FishCreationRequest;
import com.lagikoi.be.dto.response.ApiResponse;
import com.lagikoi.be.dto.response.FishCategoryResponse;
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
        return ApiResponse.<List<FishResponse>>builder()
                .code(200)
                .result(fishService.getAllFish())
                .build();
    }

    @GetMapping("/{fishId}")
    public ApiResponse<FishResponse> getAllFish(@PathVariable Integer fishId) {
        return ApiResponse.<FishResponse>builder()
                .code(200)
                .result(fishService.getFishInfo(fishId))
                .build();
    }

    //Return id of created fish
    @PostMapping("/create")
    public ApiResponse<Integer> createFish(@RequestBody FishCreationRequest request) {
        return ApiResponse.<Integer>builder()
                .code(200)
                .result(fishService.createFish(request))
                .build();
    }
}
