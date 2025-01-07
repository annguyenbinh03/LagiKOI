package com.lagikoi.be.service;

import com.lagikoi.be.dto.response.accessory.FoodAccessoryHighlightResponse;
import com.lagikoi.be.repository.FoodAccessoryRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FoodAccessoryService {
    FoodAccessoryRepository foodAccessoryRepository;

    public FoodAccessoryHighlightResponse getHighlight(Integer id){
        return foodAccessoryRepository.getHighlightById(id);
    }
}
