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

    @GetMapping("/get")
    public ApiResponse<List<FishGetAllResponse>> getFish( @RequestParam(defaultValue = "0") Integer page,
                                                          @RequestParam(defaultValue = "8") Integer size,
                                                          @RequestParam(defaultValue = "id") String sortBy,
                                                          @RequestParam(defaultValue = "desc") String order) {
        return ApiResponse.<List<FishGetAllResponse>>builder()
                .result(fishService.getFish(page, size, sortBy, order))
                .build();
    }

    @GetMapping("/detail/{fishId}")
    public ApiResponse<FishDetailReponse> getFishInfo(@PathVariable @Valid Integer fishId) {
        return ApiResponse.<FishDetailReponse>builder()
                .result(fishService.getFishInfo(fishId))
                .build();
    }

    @GetMapping("/available/total")
    public ApiResponse<Long> getTotalAvailableFish() {
        return ApiResponse.<Long>builder()
                .result(fishService.getTotalAvailableFish())
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
