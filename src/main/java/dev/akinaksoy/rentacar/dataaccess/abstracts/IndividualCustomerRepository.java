package dev.akinaksoy.rentacar.dataaccess.abstracts;

import dev.akinaksoy.rentacar.entities.concretes.IndividualCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndividualCustomerRepository extends JpaRepository<IndividualCustomer,Integer> {
/*    boolean existsByNationalyId(String nationalityId);*/
}
