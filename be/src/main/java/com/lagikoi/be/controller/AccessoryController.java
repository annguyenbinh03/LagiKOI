package com.lagikoi.be.controller;

import com.lagikoi.be.dto.request.AccessoryCreationRequest;
import com.lagikoi.be.dto.response.*;
import com.lagikoi.be.service.AccessoryService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/accessories")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AccessoryController {
    AccessoryService accessoryService;

    @GetMapping("/get-all")
    public ApiResponse<List<AccessoryGetAllResponse>> getAllFish() {
        return ApiResponse.<List<AccessoryGetAllResponse>>builder()
                .result(accessoryService.getAllAccessory())
                .build();
    }

    @GetMapping("/get")
    public ApiResponse<List<AccessoryGetAllResponse>> getAccessory(@RequestParam(defaultValue = "0") Integer page,
                                                                   @RequestParam(defaultValue = "8") Integer size,
                                                                   @RequestParam(defaultValue = "id") String sortBy,
                                                                   @RequestParam(defaultValue = "desc") String order) {
        return ApiResponse.<List<AccessoryGetAllResponse>>builder()
                .result(accessoryService.getAccessories(page, size, sortBy, order))
                .build();
    }

    @GetMapping("/detail/{accessoryId}")
    public ApiResponse<AccessoryDetailResponse> getAccessoryInfo(@PathVariable @Valid Integer accessoryId) {
        return ApiResponse.<AccessoryDetailResponse>builder()
                .result(accessoryService.getAccessoryInfo(accessoryId))
                .build();
    }

    //Return id of created accessory
    @PostMapping("/create")
    public ApiResponse<Integer> createFish(@RequestBody @Valid AccessoryCreationRequest request) {
        return ApiResponse.<Integer>builder()
                .result(accessoryService.create(request))
                .build();
    }

    @DeleteMapping("/delete/{accessoryId}")
    public ApiResponse<Void> createFish(@PathVariable @Valid Integer accessoryId) {
        accessoryService.delete(accessoryId);
        return ApiResponse.<Void>builder()
                .message("Accessory deleted")
                .build();
    }
}
