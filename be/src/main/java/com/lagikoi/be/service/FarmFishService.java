package com.lagikoi.be.service;

import com.lagikoi.be.dto.request.FarmFishCreationRequest;
import com.lagikoi.be.dto.response.AccessoryGetAllResponse;
import com.lagikoi.be.dto.response.FarmFishGetAllResponse;
import com.lagikoi.be.entity.FarmFish;
import com.lagikoi.be.exception.AppException;
import com.lagikoi.be.exception.ErrorCode;
import com.lagikoi.be.mapper.FarmFishMapper;
import com.lagikoi.be.repository.FarmFishRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class FarmFishService {
    FarmFishRepository farmFishRepository;

    FarmFishMapper farmFishMapper;

    public List<FarmFishGetAllResponse> getAllFarmFish() {
        List<FarmFishGetAllResponse> farmFishGetAllResponseList = farmFishRepository.getAll();
        if (farmFishGetAllResponseList.isEmpty())
            throw new AppException(ErrorCode.FARM_FISH_LIST_NOT_FOUND);
        return farmFishGetAllResponseList;
    }

    public FarmFishGetAllResponse getFarmFishInfo(Integer id) {
        FarmFishGetAllResponse farmFishResponse = farmFishRepository.getInfo(id);
        if (farmFishResponse == null)
            throw new AppException(ErrorCode.FARM_FISH_NOT_FOUND);
        return farmFishResponse;
    }

    @Transactional
    public Integer createFarmFish(FarmFishCreationRequest request) {
        FarmFish newFarmFish = farmFishMapper.prepareFarmFishForSave(request);
        farmFishRepository.save(newFarmFish);
        return newFarmFish.getId();
    }
}
