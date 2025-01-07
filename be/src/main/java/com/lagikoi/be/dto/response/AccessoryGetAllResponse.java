package com.lagikoi.be.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccessoryGetAllResponse {
    Integer id;
    String name;
    BigDecimal price;
    String brand;
    String category;
    String origin;
    String primaryImageUrl;
    //Food
    String bagSize;
    String pelletSize;
    //Water pump and Aerator
    Integer power;
    //Aerator
    Integer nozzleCount;
    String airflow;
    //Water pump
    Double headPressure;
    String flowRate;

    public AccessoryGetAllResponse(Integer id, String name, BigDecimal price, String brand, String category, String origin, String primaryImageUrl){
        this.id = id;
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.category = category;
        this.origin = origin;
        this.primaryImageUrl = primaryImageUrl;
    }
}
