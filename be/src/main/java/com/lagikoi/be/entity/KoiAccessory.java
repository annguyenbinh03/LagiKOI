package com.lagikoi.be.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "koi_accessories")
public class KoiAccessory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private com.lagikoi.be.entity.Product product;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private com.lagikoi.be.entity.KoiAccessoriesCategory category;

    @Lob
    @Column(name = "image_urls", nullable = false)
    private String imageUrls;

    @Column(name = "brand", nullable = false, length = 50)
    private String brand;

    @Column(name = "view_count", nullable = false)
    private Integer viewCount;

}