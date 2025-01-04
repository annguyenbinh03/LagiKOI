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
@Table(name = "aerator_accessory")
@PrimaryKeyJoinColumn(name = "id")
public class AeratorAccessory extends Accessory {
    @Size(max = 20)
    @NotNull
    @Column(name = "model", nullable = false, length = 20)
    private String model;
    @NotNull
    @Column(name = "power", nullable = false)
    private Integer power; //as watt
    @Size(max = 20)
    @NotNull
    @Column(name = "nozzle_count", nullable = false)
    private Integer nozzleCount;
    @NotNull
    @Column(name = "air_flow", nullable = false, length = 20)
    private String airflow;//as lit/minute
    @Size(max = 20)
    @NotNull
    @Column(name = "working_time", length = 20)
    private String workingTime;
    @Size(max = 20)
    @NotNull
    @Column(name = "size", nullable = false, length = 20)
    private String size;
}
