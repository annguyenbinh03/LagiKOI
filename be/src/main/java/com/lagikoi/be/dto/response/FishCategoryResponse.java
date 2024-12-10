package com.lagikoi.be.dto.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FishCategoryResponse {
    int id;
    String name;
    String description;
}
