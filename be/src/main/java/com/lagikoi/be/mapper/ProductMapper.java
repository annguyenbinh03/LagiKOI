package com.lagikoi.be.mapper;

import com.lagikoi.be.dto.request.FishCreationRequest;
import com.lagikoi.be.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "stock", target = "stock")
    @Mapping(target = "createdAt", defaultExpression = "java(java.time.Instant.now())")
    Product prepareProductForSave(FishCreationRequest request);
}
