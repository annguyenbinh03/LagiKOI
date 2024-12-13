package com.lagikoi.be.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private KoiFishCategory category;

    @Size(max = 15)
    @NotNull
    @Column(name = "age", nullable = false, length = 15)
    private String age;

    @Size(max = 10)
    @NotNull
    @Column(name = "gender", nullable = false, length = 10)
    private String gender;

    @Size(max = 50)
    @NotNull
    @Column(name = "size", nullable = false, length = 50)
    private String size;

    @Size(max = 255)
    @NotNull
    @Column(name = "farm_name", nullable = false)
    private String farmName;

    @NotNull
    @Column(name = "view_count", nullable = false)
    private Integer viewCount;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

}