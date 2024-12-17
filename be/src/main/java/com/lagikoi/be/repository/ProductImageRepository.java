package com.lagikoi.be.repository;

import com.lagikoi.be.dto.response.ProductImageResponse;
import com.lagikoi.be.entity.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage, String> {
    @Query("SELECT new com.lagikoi.be.dto.response.ProductImageResponse(pi.id, pi.imageUrl, pi.displayOrder) " +
            "FROM ProductImage pi, Fish f " +
            "WHERE f.id = :fishId AND pi.product = f.product AND pi.isDeleted = false")
    List<ProductImageResponse> getProductImageByFishId(@Param("fishId") Integer fishId);
}
