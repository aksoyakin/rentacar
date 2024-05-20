package dev.akinaksoy.rentacar.dataaccess.abstracts;

import dev.akinaksoy.rentacar.entities.concretes.CorporateCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorporateCustomerRepository extends JpaRepository<CorporateCustomer,Integer> {
/*    boolean existsByVatNumber(String vatNumber);
    boolean existByCompanyName(String companyName);*/
}
