package dev.akinaksoy.rentacar.entities.concretes;

import dev.akinaksoy.rentacar.core.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="transmissions")
public class Transmission extends BaseEntity {
    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "transmission")
    private List<Model> models;
}
