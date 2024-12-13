package com.lagikoi.be.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "koi_pond_services")
public class KoiPondService {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @NotNull
    @Lob
    @Column(name = "image_urls", nullable = false)
    private String imageUrls;

    @Size(max = 50)
    @NotNull
    @Column(name = "duration_estimate", nullable = false, length = 50)
    private String durationEstimate;

    @NotNull
    @Column(name = "view_count", nullable = false)
    private Integer viewCount;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

}