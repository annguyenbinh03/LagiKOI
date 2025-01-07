package com.lagikoi.be.repository;

import com.lagikoi.be.dto.response.AccessoryDetailResponse;
import com.lagikoi.be.dto.response.AccessoryGetAllResponse;
import com.lagikoi.be.entity.Accessory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccessoryRepository extends JpaRepository<Accessory, Integer> {
    @Query("SELECT new com.lagikoi.be.dto.response.AccessoryGetAllResponse( a.id, a.product.name,  a.product.price, " +
            " a.brand, ac.name, a.origin, pi.imageUrl )" +
            "FROM Accessory a " +
            "JOIN AccessoryCategory ac ON a.category = ac " +
            "JOIN ProductImage pi ON a.product = pi.product" +
            " WHERE a.isDeleted = false AND pi.displayOrder = 1")
    List<AccessoryGetAllResponse> getAllAccessory();

    @Query("SELECT new com.lagikoi.be.dto.response.AccessoryDetailResponse( a.id, a.product.name, a.product.description, a.product.price, a.product.stock," +
            " a.brand, a.viewCount, ac.name )" +
            "FROM Accessory a " +
            "JOIN AccessoryCategory ac ON a.category = ac " +
            " WHERE a.isDeleted = false AND a.id = :accessoryId")
    AccessoryDetailResponse getAccessoryInfo(@Param("accessoryId") Integer accessoryId);

    @Query("SELECT new com.lagikoi.be.dto.response.AccessoryGetAllResponse( a.id, a.product.name,  a.product.price, " +
            " a.brand, ac.name, a.origin, pi.imageUrl )" +
            "FROM Accessory a " +
            "JOIN AccessoryCategory ac ON a.category = ac " +
            "JOIN ProductImage pi ON a.product = pi.product" +
            " WHERE a.isDeleted = false AND pi.displayOrder = 1")
    Page<AccessoryGetAllResponse> getAccessories(PageRequest pageRequest);

    @Query("SELECT COUNT(a) FROM Accessory a, Product p WHERE a.product = p AND p.stock > 0 AND a.isDeleted = false")
    long countAvailableAccessory();
}
