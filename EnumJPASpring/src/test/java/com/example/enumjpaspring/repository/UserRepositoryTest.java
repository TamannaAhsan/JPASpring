package com.example.enumjpaspring.repository;

import com.example.enumjpaspring.entity.Gender;
import com.example.enumjpaspring.entity.Status;
import com.example.enumjpaspring.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;


    @Test
    public void saveUser(){
        User userF = User.builder()
                .username("Tamanna")
                .email("tam@gmail.com")
                .status(Status.online)
                .gender(Gender.Female)
                .build();
        User userM = User.builder()
                .username("Tamal")
                .email("tamal@gmail.com")
                .status(Status.offline)
                .gender(Gender.Male)
                .build();
        userRepository.save(userF);
        userRepository.save(userM);
    }

    @Test
    public void printAllUser(){
        List<User> users = userRepository.findAll();
        System.out.println("Users: "+users);
    }

    @Test
    public void printAllGenderByFemale(){
        List<User> users = userRepository.findByGender(Gender.Female);
        System.out.println("Users: "+users);
    }

   /* @Test
    public void printAllGender(){
        List<User> users = userRepository.findAllByGender();
        System.out.println("Users: "+users);
    }*/

}