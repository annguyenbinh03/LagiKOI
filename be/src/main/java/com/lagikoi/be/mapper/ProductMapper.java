package com.lagikoi.be.mapper;

import com.lagikoi.be.dto.request.AccessoryCreationRequest;
import com.lagikoi.be.dto.request.FishCreationRequest;
import com.lagikoi.be.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "stock", target = "stock")
    @Mapping(target = "createdAt", defaultExpression = "java(java.time.Instant.now())")
    @Mapping(target = "productImages", ignore = true)
    @Mapping(target = "fish", ignore = true)
    @Mapping(target = "koiAccessory", ignore = true)
    @Mapping(target = "service", ignore = true)
    Product prepareProductForSave(FishCreationRequest request);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "stock", target = "stock")
    @Mapping(target = "createdAt", expression = "java(java.time.Instant.now())")
    @Mapping(target = "productImages", ignore = true)
    @Mapping(target = "fish", ignore = true)
    @Mapping(target = "koiAccessory", ignore = true)
    @Mapping(target = "service", ignore = true)
    Product prepareProductForSave(AccessoryCreationRequest request);
}
