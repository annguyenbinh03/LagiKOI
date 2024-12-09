package com.lagikoi.be.repository;

import com.lagikoi.be.entity.KoiFishCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FishCategoryRepository extends JpaRepository<KoiFishCategory, Integer> {
    Integer findByName(String name);

    KoiFishCategory getKoiFishCategoriesByName(String name);
}
