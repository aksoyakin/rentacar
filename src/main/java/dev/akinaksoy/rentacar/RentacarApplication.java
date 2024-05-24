package dev.akinaksoy.rentacar;

import dev.akinaksoy.rentacar.dataaccess.abstracts.UserRepository;
import dev.akinaksoy.rentacar.entities.concretes.User;
import dev.akinaksoy.rentacar.entities.concretes.enums.UserRole;
import org.antlr.v4.runtime.misc.LogManager;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class RentacarApplication {
    /*@Autowired
    private UserRepository userRepository;*/

    public static void main(String[] args) {
        SpringApplication.run(RentacarApplication.class, args);
    }

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }

/*    public  void run(String...args){

        User adminAccount=userRepository.findByRole(UserRole.ADMIN);
        if (null==adminAccount){
            User user=new User();
            user.setEmail("admin@admin.com");
*//*            user.setFirstName("admin");
            user.setLastName("admin");*//*
            user.setUserRole(UserRole.ADMIN);
            user.setPassword(new BCryptPasswordEncoder().encode("admin"));
            userRepository.save(user);
        }
    }*/


}
