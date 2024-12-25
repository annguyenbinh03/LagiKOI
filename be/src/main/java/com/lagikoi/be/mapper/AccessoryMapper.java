package com.lagikoi.be.mapper;

import com.lagikoi.be.dto.request.AccessoryCreationRequest;
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
}
