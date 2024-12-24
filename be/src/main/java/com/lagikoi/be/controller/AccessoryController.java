package com.lagikoi.be.controller;

import com.lagikoi.be.dto.response.*;
import com.lagikoi.be.service.AccessoryService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/accessory")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AccessoryController {
    AccessoryService accessoryService;

    @GetMapping("/get-all")
    public ApiResponse<List<AccessoryGetAllResponse>> getAllFish() {
        return ApiResponse.<List<AccessoryGetAllResponse>>builder()
                .result(accessoryService.getAllAccessory())
                .build();
    }

    @GetMapping("/detail/{accessoryId}")
    public ApiResponse<AccessoryDetailResponse> getAccessoryInfo(@PathVariable @Valid Integer accessoryId) {
        return ApiResponse.<AccessoryDetailResponse>builder()
                .result(accessoryService.getAccessoryInfo(accessoryId))
                .build();
    }
}
