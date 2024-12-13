package com.lagikoi.be.repository;

import com.lagikoi.be.entity.KoiFishCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FishCategoryRepository extends JpaRepository<KoiFishCategory, Integer> {

   Optional<KoiFishCategory> getKoiFishCategoriesByName(String name);
}
