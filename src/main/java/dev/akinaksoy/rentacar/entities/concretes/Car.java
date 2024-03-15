package dev.akinaksoy.rentacar.entities.concretes;

import dev.akinaksoy.rentacar.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="cars")
public class Car extends BaseEntity {
    @Column(name="modelYear")
    private String modelYear;

    @Column(name="plate")
    private String plate;

    @Column(name="state")
    private int state;

    @Column(name="dailyPrice")
    private double dailyPrice;

    @ManyToOne
    @JoinColumn(name = "modelId")
    private Model model;

}
