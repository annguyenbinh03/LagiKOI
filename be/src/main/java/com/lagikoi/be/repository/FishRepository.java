package com.lagikoi.be.repository;

import com.lagikoi.be.dto.response.FishDetailReponse;
import com.lagikoi.be.dto.response.FishGetAllResponse;
import com.lagikoi.be.entity.Fish;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FishRepository extends JpaRepository<Fish, Integer> {
    @Query("SELECT new com.lagikoi.be.dto.response.FishGetAllResponse( f.id, f.product.name, f.product.description, f.product.price, f.product.stock, f.yob, f.gender, " +
            "f.size, f.farmName, f.viewCount, kc.name, pi.imageUrl )" +
            "FROM Fish f " +
            "JOIN FishCategory kc ON f.category = kc " +
            "JOIN ProductImage pi ON f.product = pi.product" +
            " WHERE f.isDeleted = false AND pi.displayOrder = 1")
    List<FishGetAllResponse> getAllFish();

    @Query("SELECT new com.lagikoi.be.dto.response.FishDetailReponse( f.id, f.product.name, f.product.description, f.product.price, f.product.stock, f.yob, f.gender, " +
            "f.size, f.farmName, f.viewCount, kc.name )" +
            "FROM Fish f " +
            "JOIN FishCategory kc ON f.category = kc " +
            " WHERE f.isDeleted = false AND f.id = :fishId")
    FishDetailReponse getFishInfo(@Param("fishId") Integer fishId);

    @Query("SELECT new com.lagikoi.be.dto.response.FishGetAllResponse( f.id, f.product.name, f.product.description, f.product.price, f.product.stock, f.yob, f.gender, " +
            "f.size, f.farmName, f.viewCount, kc.name, pi.imageUrl )" +
            "FROM Fish f " +
            "JOIN FishCategory kc ON f.category = kc " +
            "JOIN ProductImage pi ON f.product = pi.product" +
            " WHERE f.isDeleted = false AND pi.displayOrder = 1")
    Page<FishGetAllResponse> getFish(PageRequest pageRequest);

    @Query("SELECT COUNT(f) FROM Fish f, Product p WHERE f.isDeleted = false AND f.product = p AND p.stock > 0")
    long countAvailableFish();
}
