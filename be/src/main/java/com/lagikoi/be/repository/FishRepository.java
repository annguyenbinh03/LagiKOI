package com.lagikoi.be.repository;

import com.lagikoi.be.entity.KoiFish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FishRepository extends JpaRepository<KoiFish, Integer> {
    @Query("SELECT k.id, p.name, p.description, p.price, " +
            " k.age, k.gender, k.size, k.farmName, k.viewCount, kc.name, k.imageUrls " +
            "FROM Product p " +
            "JOIN KoiFish k ON p.id = k.product.id " +
            "JOIN KoiFishCategory kc ON k.category.id = kc.id")
    List<Object[]> getAllFish();
}
