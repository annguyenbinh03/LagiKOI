package com.lagikoi.be.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "koi_fish")
public class KoiFish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private com.lagikoi.be.entity.Product product;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private com.lagikoi.be.entity.KoiFishCategory category;

    @Lob
    @Column(name = "image_urls", nullable = false)
    private String imageUrls;

    @Column(name = "age", nullable = false, length = 15)
    private String age;

    @Column(name = "gender", nullable = false, length = 10)
    private String gender;

    @Column(name = "size", nullable = false, length = 50)
    private String size;

    @Column(name = "farm_name", nullable = false)
    private String farmName;

    @Column(name = "view_count", nullable = false)
    private Integer viewCount;

}