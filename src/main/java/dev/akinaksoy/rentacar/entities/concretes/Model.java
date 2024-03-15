package dev.akinaksoy.rentacar.entities.concretes;

import dev.akinaksoy.rentacar.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="models")
public class Model extends BaseEntity {
    @Column(name="name")
    private String name;

    @ManyToOne
    @JoinColumn(name="brandId")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name="fuelId")
    private Fuel fuel;

    @ManyToOne
    @JoinColumn(name="tranmissionId")
    private Transmission transmission;

    @OneToMany(mappedBy = "model")
    private List<Car> cars;

}
