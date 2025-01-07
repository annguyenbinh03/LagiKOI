package com.lagikoi.be.dto.response.accessory;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FoodAccessoryHighlightResponse {
    String bagSize;
    String pelletSize;
}
