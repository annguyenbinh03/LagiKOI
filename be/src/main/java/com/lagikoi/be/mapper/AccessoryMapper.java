package com.lagikoi.be.mapper;

import com.lagikoi.be.dto.request.AccessoryCreationRequest;
import com.lagikoi.be.dto.response.AccessoryGetAllResponse;
import com.lagikoi.be.dto.response.accessory.AeratorHighlightResponse;
import com.lagikoi.be.dto.response.accessory.FoodAccessoryHighlightResponse;
import com.lagikoi.be.dto.response.accessory.WaterPumpHighlightResponse;
import com.lagikoi.be.entity.AccessoryCategory;
import com.lagikoi.be.entity.Accessory;
import com.lagikoi.be.entity.Product;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AccessoryMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "category", target = "category")
    @Mapping(source = "product", target = "product")
    @Mapping(source = "request.brand", target = "brand")
    @Mapping(target = "isDeleted", constant = "false")
    @Mapping(target = "viewCount", constant = "0")
    Accessory prepareAccessoryForSave(AccessoryCreationRequest request, AccessoryCategory category, Product product);

    @Mapping(source = "accessory.id",target = "id")
    @Mapping(source = "accessory.name",target = "name")
    @Mapping(source = "accessory.price",target = "price")
    @Mapping(source = "accessory.brand",target = "brand")
    @Mapping(source = "accessory.category",target = "category")
    @Mapping(source = "accessory.origin",target = "origin")
    @Mapping(source = "accessory.primaryImageUrl",target = "primaryImageUrl")
    @Mapping(source = "foodHighlight.bagSize",target = "bagSize")
    @Mapping(source = "foodHighlight.pelletSize",target = "pelletSize")
    @Mapping(target = "power", ignore = true)
    @Mapping(target = "nozzleCount", ignore = true)
    @Mapping(target = "airflow", ignore = true)
    @Mapping(target = "headPressure", ignore = true)
    @Mapping(target = "flowRate", ignore = true)
    AccessoryGetAllResponse toAccessoryResponse(AccessoryGetAllResponse accessory, FoodAccessoryHighlightResponse foodHighlight);

    @Mapping(source = "accessory.id",target = "id")
    @Mapping(source = "accessory.name",target = "name")
    @Mapping(source = "accessory.price",target = "price")
    @Mapping(source = "accessory.brand",target = "brand")
    @Mapping(source = "accessory.category",target = "category")
    @Mapping(source = "accessory.origin",target = "origin")
    @Mapping(source = "accessory.primaryImageUrl",target = "primaryImageUrl")
    @Mapping(source = "aeratorHighlight.power",target = "power")
    @Mapping(source = "aeratorHighlight.nozzleCount",target = "nozzleCount")
    @Mapping(source = "aeratorHighlight.airflow",target = "airflow")
    @Mapping(target = "bagSize", ignore = true)
    @Mapping(target = "pelletSize", ignore = true)
    @Mapping(target = "headPressure", ignore = true)
    @Mapping(target = "flowRate", ignore = true)
    AccessoryGetAllResponse toAccessoryResponse(AccessoryGetAllResponse accessory, AeratorHighlightResponse aeratorHighlight);

    @Mapping(source = "accessory.id",target = "id")
    @Mapping(source = "accessory.name",target = "name")
    @Mapping(source = "accessory.price",target = "price")
    @Mapping(source = "accessory.brand",target = "brand")
    @Mapping(source = "accessory.category",target = "category")
    @Mapping(source = "accessory.origin",target = "origin")
    @Mapping(source = "accessory.primaryImageUrl",target = "primaryImageUrl")
    @Mapping(source = "waterPumpHighlight.power",target = "power")
    @Mapping(source = "waterPumpHighlight.headPressure",target = "headPressure")
    @Mapping(source = "waterPumpHighlight.flowRate",target = "flowRate")
    @Mapping(target = "bagSize", ignore = true)
    @Mapping(target = "pelletSize", ignore = true)
    @Mapping(target = "nozzleCount", ignore = true)
    @Mapping(target = "airflow", ignore = true)
    AccessoryGetAllResponse toAccessoryResponse(AccessoryGetAllResponse accessory, WaterPumpHighlightResponse waterPumpHighlight);
}
