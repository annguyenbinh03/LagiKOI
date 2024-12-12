package com.lagikoi.be.mapper;

import com.lagikoi.be.dto.request.FishImagesCreationRequest;
import com.lagikoi.be.entity.KoiFish;
import com.lagikoi.be.entity.KoiFishImageUrl;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface KoiFishImageUrlMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "fish", target = "fish")
    @Mapping(source = "request.imageUrl", target = "imageUrl")
    @Mapping(source = "request.displayOrder", target = "displayOrder")
    @Mapping(target = "isDeleted", constant = "false")
    @Mapping(source = "request.createdAt", target = "createdAt", defaultExpression = "java(java.time.Instant.now())")
    KoiFishImageUrl prepareKoiFishImageUrlForSave(FishImagesCreationRequest request, KoiFish fish);

}
