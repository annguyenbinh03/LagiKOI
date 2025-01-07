package com.lagikoi.be.service;

import com.lagikoi.be.dto.response.accessory.WaterPumpHighlightResponse;
import com.lagikoi.be.repository.WaterPumpAccessoryRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class WaterPumpAccessoryService {
    WaterPumpAccessoryRepository waterPumpAccessoryRepository;

    public WaterPumpHighlightResponse getHighLight(Integer id){
        return waterPumpAccessoryRepository.getHighlightById(id);
    }
}
