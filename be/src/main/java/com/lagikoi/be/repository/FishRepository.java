package com.lagikoi.be.repository;

import com.lagikoi.be.dto.response.FishDetailReponse;
import com.lagikoi.be.dto.response.FishGetAllResponse;
import com.lagikoi.be.entity.KoiFish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FishRepository extends JpaRepository<KoiFish, Integer> {
    @Query("SELECT new com.lagikoi.be.dto.response.FishGetAllResponse(" +
            "k.id, p.name, p.description, p.price, p.stock, k.age, k.gender, " +
            "k.size, k.farmName, k.viewCount, kc.name) " +
            "FROM Product p " +
            "JOIN KoiFish k ON p.id = k.product.id " +
            "JOIN KoiFishCategory kc ON k.category.id = kc.id " +
            "WHERE k.isDeleted = false")
    List<FishGetAllResponse> getAllFish();

    @Query("SELECT new com.lagikoi.be.dto.response.FishDetailReponse(" +
            "k.id, p.name, p.description, p.price, p.stock, k.age, k.gender, " +
            "k.size, k.farmName, k.viewCount, kc.name) " +
            "FROM Product p " +
            "JOIN KoiFish k ON p.id = k.product.id " +
            "JOIN KoiFishCategory kc ON k.category.id = kc.id " +
            "WHERE k.id = :fishId AND k.isDeleted = false")
    FishDetailReponse getFishInfo(@Param("fishId") Integer fishId);
}
