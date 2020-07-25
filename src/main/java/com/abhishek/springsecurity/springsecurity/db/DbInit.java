package com.abhishek.springsecurity.springsecurity.db;

import com.abhishek.springsecurity.springsecurity.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DbInit implements CommandLineRunner {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder ;

    public DbInit(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository ;

        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args){

        //Delete All
        this.userRepository.deleteAll();

        // Create User in DB
        User abhi = new User("abhi",passwordEncoder.encode("abhi123"),"USER","");
        User admin = new User("admin",passwordEncoder.encode("admin123"),"ADMIN","");
        User manager = new User("manager",passwordEncoder.encode("manager123"),"MANAGER","");

        List<User> users = Arrays.asList(abhi,admin,manager);

        // Save to DB
        this.userRepository.saveAll(users);

    }
}
