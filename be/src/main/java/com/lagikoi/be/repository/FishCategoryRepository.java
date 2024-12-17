package com.lagikoi.be.repository;

import com.lagikoi.be.entity.FishCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FishCategoryRepository extends JpaRepository<FishCategory, Integer> {

   Optional<FishCategory> getKoiFishCategoriesByName(String name);
}
