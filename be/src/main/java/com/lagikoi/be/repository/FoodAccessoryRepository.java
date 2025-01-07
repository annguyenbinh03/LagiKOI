package com.lagikoi.be.repository;

import com.lagikoi.be.dto.response.accessory.FoodAccessoryHighlightResponse;
import com.lagikoi.be.entity.FoodAccessory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodAccessoryRepository extends JpaRepository<FoodAccessory, Integer> {
    @Query("SELECT new com.lagikoi.be.dto.response.accessory.FoodAccessoryHighlightResponse(fa.bagSize, fa.pelletSize) FROM FoodAccessory fa WHERE fa.id = :id")
    FoodAccessoryHighlightResponse getHighlightById(@Param("id") Integer id);
}
