package com.lagikoi.be.mapper;

import com.lagikoi.be.dto.request.FishCreationRequest;
import com.lagikoi.be.entity.Fish;
import com.lagikoi.be.entity.FishCategory;
import com.lagikoi.be.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FishMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "category", target = "category")
    @Mapping(source = "product", target = "product")
    @Mapping(source = "request.age", target = "age")
    @Mapping(source = "request.gender", target = "gender")
    @Mapping(source = "request.size", target = "size")
    @Mapping(source = "request.farmName", target = "farmName")
    @Mapping(target = "isDeleted", constant = "false")
    @Mapping(target = "viewCount", constant = "0")
    Fish prepareKoiFishForSave(FishCreationRequest request, FishCategory category, Product product);
}
