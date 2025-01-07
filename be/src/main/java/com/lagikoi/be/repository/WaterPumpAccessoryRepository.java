package com.lagikoi.be.repository;

import com.lagikoi.be.dto.response.accessory.WaterPumpHighlightResponse;
import com.lagikoi.be.entity.WaterPumpAccessory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface WaterPumpAccessoryRepository extends JpaRepository<WaterPumpAccessory, Integer> {
    @Query("SELECT new com.lagikoi.be.dto.response.accessory.WaterPumpHighlightResponse(wp.power, wp.headPressure, wp.flowRate) FROM WaterPumpAccessory wp WHERE wp.id = :id")
    WaterPumpHighlightResponse getHighlightById(@Param("id") Integer id);
}
