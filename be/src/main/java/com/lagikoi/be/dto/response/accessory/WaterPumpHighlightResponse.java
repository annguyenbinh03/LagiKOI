package com.lagikoi.be.dto.response.accessory;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WaterPumpHighlightResponse {
    Integer power;
    Double headPressure;
    String flowRate;
}
