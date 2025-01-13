package com.lagikoi.be.mapper;

import com.lagikoi.be.dto.request.FarmFishCreationRequest;
import com.lagikoi.be.entity.FarmFish;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FarmFishMapper {
    @Mapping(target = "id", ignore = true)
    FarmFish prepareFarmFishForSave(FarmFishCreationRequest request);
}
