package com.lagikoi.be.repository;

import com.lagikoi.be.dto.response.FarmFishGetAllResponse;
import com.lagikoi.be.entity.FarmFish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FarmFishRepository extends JpaRepository<FarmFish, Integer> {
    @Query("SELECT new com.lagikoi.be.dto.response.FarmFishGetAllResponse(ff.id, ff.name, ff.description) " +
            "FROM FarmFish ff " +
            "ORDER BY ff.name")
    List<FarmFishGetAllResponse> getAll();

    @Query("SELECT new com.lagikoi.be.dto.response.FarmFishGetAllResponse(ff.id, ff.name, ff.description) " +
            "FROM FarmFish ff " +
            "WHERE ff.id = :id")
    FarmFishGetAllResponse getInfo(@Param("id") Integer id);
}
