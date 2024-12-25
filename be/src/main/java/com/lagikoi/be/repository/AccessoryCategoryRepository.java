package com.lagikoi.be.repository;

import com.lagikoi.be.entity.AccessoryCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccessoryCategoryRepository extends JpaRepository<AccessoryCategory, Integer> {
    Optional<AccessoryCategory> findAccessoryCategoryByName(String name);
}
