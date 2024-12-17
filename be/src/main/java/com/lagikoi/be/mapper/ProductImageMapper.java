package com.lagikoi.be.mapper;

import com.lagikoi.be.dto.request.ProductImageCreationRequest;
import com.lagikoi.be.entity.Fish;
import com.lagikoi.be.entity.ProductImage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductImageMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "request.imageUrl", target = "imageUrl")
    @Mapping(source = "request.displayOrder", target = "displayOrder")
    @Mapping(target = "isDeleted", constant = "false")
    @Mapping(source = "request.createdAt", target = "createdAt", defaultExpression = "java(java.time.Instant.now())")
    ProductImage prepareProductImageForSave(ProductImageCreationRequest request, Fish fish);

}
