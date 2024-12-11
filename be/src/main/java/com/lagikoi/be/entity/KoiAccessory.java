package com.lagikoi.be.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "koi_accessories")
public class KoiAccessory {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private com.lagikoi.be.entity.Product product;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private com.lagikoi.be.entity.KoiAccessoriesCategory category;

    @NotNull
    @Lob
    @Column(name = "image_urls", nullable = false)
    private String imageUrls;

    @Size(max = 50)
    @NotNull
    @Column(name = "brand", nullable = false, length = 50)
    private String brand;

    @NotNull
    @Column(name = "view_count", nullable = false)
    private Integer viewCount;

}