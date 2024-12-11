package com.lagikoi.be.controller;

import com.lagikoi.be.dto.request.FishCreationRequest;
import com.lagikoi.be.dto.response.ApiResponse;
import com.lagikoi.be.dto.response.FishDetailReponse;
import com.lagikoi.be.dto.response.FishGetAllResponse;
import com.lagikoi.be.service.FishService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fish")
public class FishController {
    private final FishService fishService;

    @GetMapping("/get-all")
    public ApiResponse<List<FishGetAllResponse>> getAllFish() {
        return ApiResponse.<List<FishGetAllResponse>>builder()
                .code(200)
                .result(fishService.getAllFish())
                .build();
    }

    @GetMapping("/{fishId}")
    public ApiResponse<FishDetailReponse> getAllFish(@PathVariable @Valid Integer fishId) {
        return ApiResponse.<FishDetailReponse>builder()
                .code(200)
                .result(fishService.getFishInfo(fishId))
                .build();
    }

    //Return id of created fish
    @PostMapping("/create")
    public ApiResponse<Integer> createFish(@RequestBody @Valid FishCreationRequest request) {
        return ApiResponse.<Integer>builder()
                .code(200)
                .result(fishService.createFish(request))
                .build();
    }
}
