package dev.akinaksoy.rentacar.dataaccess.abstracts;

import dev.akinaksoy.rentacar.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
/*    Optional<User> findByUsername(String name);
    boolean existsByEmail(String email);
    boolean existsByPhone(String phone);*/
}
