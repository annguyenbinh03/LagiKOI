package com.lagikoi.be.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum AccessoryType{
    FOOD("Thức ăn"),
    AERATOR("Máy sủi oxy"),
    WATER_PUMP("Máy bơm nước"),
    ;

    String type;

    AccessoryType(String type) {
        this.type = type;
    }
}
