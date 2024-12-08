package com.lagikoi.be.entity;

import jakarta.persistence.*;
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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private com.lagikoi.be.entity.Product product;

    @Lob
    @Column(name = "image_urls", nullable = false)
    private String imageUrls;

    @Column(name = "duration_estimate", nullable = false, length = 50)
    private String durationEstimate;

    @Column(name = "view_count", nullable = false)
    private Integer viewCount;

}