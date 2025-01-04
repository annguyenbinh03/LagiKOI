package com.lagikoi.be.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "accessory")
@Inheritance(strategy = InheritanceType.JOINED)
public class Accessory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private AccessoryCategory category;

    @Size(max = 50)
    @NotNull
    @Column(name = "brand", nullable = false, length = 50)
    private String brand;

    @Size(max = 30)
    @NotNull
    @Column(name = "origin", length = 30)
    private String origin;

    @NotNull
    @Column(name = "view_count", nullable = false)
    private Integer viewCount;

    @Column(name = "is_deleted")
    private Boolean isDeleted;
}