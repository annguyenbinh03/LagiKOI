package com.lagikoi.be.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "koi_fish")
public class KoiFish {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private com.lagikoi.be.entity.Product product;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private com.lagikoi.be.entity.KoiFishCategory category;

    @NotNull
    @Column(name = "age", nullable = false, length = 15)
    private String age;

    @NotNull
    @Column(name = "gender", nullable = false, length = 10)
    private String gender;

    @NotNull
    @Column(name = "size", nullable = false, length = 50)
    private String size;

    @NotNull
    @Column(name = "farm_name", nullable = false)
    private String farmName;

    @NotNull
    @Column(name = "view_count", nullable = false)
    private Integer viewCount;

    @ColumnDefault("0")
    @Column(name = "is_deleted")
    private Boolean isDeleted;

}