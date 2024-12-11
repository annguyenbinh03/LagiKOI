package com.lagikoi.be.repository;

import com.lagikoi.be.dto.response.FishImageUrlResponse;
import com.lagikoi.be.entity.KoiFishImageUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FishImageUrlRepository extends JpaRepository<KoiFishImageUrl, Integer> {
    @Query("SELECT kfi.imageUrl FROM KoiFishImageUrl kfi WHERE kfi.fish.id = :fishId AND kfi.displayOrder = 1 AND kfi.isDeleted = false")
    String getFishPrimaryImageUrls(@Param("fishId") Integer fishId);

    @Query("SELECT new com.lagikoi.be.dto.response.FishImageUrlResponse(kfi.id, kfi.imageUrl, kfi.displayOrder) FROM KoiFishImageUrl kfi WHERE kfi.fish.id = :fishId AND kfi.isDeleted = false")
    List<FishImageUrlResponse> getAllFishImageUrls(@Param("fishId") Integer fishId);
}
