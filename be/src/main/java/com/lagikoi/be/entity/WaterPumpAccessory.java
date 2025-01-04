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
@Table(name = "water_pump_accessory")
@PrimaryKeyJoinColumn(name = "id")
public class WaterPumpAccessory extends Accessory {
    @Size(max = 20)
    @NotNull
    @Column(name = "model", nullable = false, length = 20)
    private String model;
    @NotNull
    @Column(name = "power", nullable = false)
    private Integer power; //as watt
    @Size(max = 20)
    @NotNull
    @Column(name = "head_pressure", nullable = false, length = 20)
    private String headPressure; //as m
    @Size(max = 20)
    @NotNull
    @Column(name = "flow_rate", nullable = false, length = 20)
    private String flowRate; //as L/h
    @Size(max = 20)
    @NotNull
    @Column(name = "voltage", nullable = false, length = 20)
    private String voltage;
    @Size(max = 10)
    @NotNull
    @Column(name = "frequency", nullable = false, length = 10)
    private Double frequency; // as hz
}
