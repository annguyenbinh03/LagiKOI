package com.lagikoi.be.service;

import com.lagikoi.be.dto.response.accessory.AeratorHighlightResponse;
import com.lagikoi.be.entity.AeratorAccessory;
import com.lagikoi.be.repository.AeratorAccessoryRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AeratorAccessoryService {
    AeratorAccessoryRepository aeratorRepository;

    public AeratorHighlightResponse getHighlight(int id) {
        return aeratorRepository.getHighlightById(id);
    }
}
