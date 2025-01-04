package com.lagikoi.be.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "food_accessory")
@PrimaryKeyJoinColumn(name = "id")
public class FoodAccessory extends Accessory {
    @Size(max = 20)
    @NotNull
    @Column(name = "bag_size", nullable = false, length = 20)
    private String bagSize; //as lbs
    @Size(max = 20)
    @NotNull
    @Column(name = "pellet_size", nullable = false, length = 20)
    private String pelletSize; // small/medium/large
}
