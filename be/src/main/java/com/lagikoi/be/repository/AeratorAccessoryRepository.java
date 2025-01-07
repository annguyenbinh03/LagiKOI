package com.lagikoi.be.repository;

import com.lagikoi.be.dto.response.accessory.AeratorHighlightResponse;
import com.lagikoi.be.entity.AeratorAccessory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AeratorAccessoryRepository extends JpaRepository<AeratorAccessory, Integer> {
    @Query("SELECT new com.lagikoi.be.dto.response.accessory.AeratorHighlightResponse(aa.power, aa.nozzleCount, aa.airflow) FROM AeratorAccessory aa WHERE aa.id = :id")
    AeratorHighlightResponse getHighlightById(@Param("id") Integer id);
}
