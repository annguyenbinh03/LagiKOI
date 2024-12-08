package com.lagikoi.be.controller;

import com.lagikoi.be.dto.response.FishResponse;
import com.lagikoi.be.service.FishService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fish")
public class FishController {
    private final FishService fishService;

    @GetMapping
    public List<FishResponse> getAllFish() {
        return fishService.getAllFish();
    }
}
