package dev.akinaksoy.rentacar.entities.concretes;

import dev.akinaksoy.rentacar.core.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "brands")
public class Brand extends BaseEntity {

    @Column(name = "name")
    private String name;

}
