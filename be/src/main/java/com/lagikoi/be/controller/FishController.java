package com.lagikoi.be.controller;

import com.lagikoi.be.dto.request.FishCreationRequest;
import com.lagikoi.be.dto.response.ApiResponse;
import com.lagikoi.be.dto.response.FishDetailReponse;
import com.lagikoi.be.dto.response.FishGetAllResponse;
import com.lagikoi.be.service.FishService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fish")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FishController {
    FishService fishService;

    @GetMapping("/get-all")
    public ApiResponse<List<FishGetAllResponse>> getAllFish() {
        return ApiResponse.<List<FishGetAllResponse>>builder()
                .result(fishService.getAllFish())
                .build();
    }

    @GetMapping("/detail/{fishId}")
    public ApiResponse<FishDetailReponse> getFishInfo(@PathVariable @Valid Integer fishId) {
        return ApiResponse.<FishDetailReponse>builder()
                .result(fishService.getFishInfo(fishId))
                .build();
    }

    //Return id of created fish
    @PostMapping("/create")
    public ApiResponse<Integer> createFish(@RequestBody @Valid FishCreationRequest request) {
        return ApiResponse.<Integer>builder()
                .result(fishService.createFish(request))
                .build();
    }
}
