package dev.akinaksoy.rentacar.dataaccess.abstracts;

import dev.akinaksoy.rentacar.entities.concretes.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model,Integer> {
}
