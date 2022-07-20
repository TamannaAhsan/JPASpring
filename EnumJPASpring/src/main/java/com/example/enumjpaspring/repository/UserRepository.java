package com.example.enumjpaspring.repository;

import com.example.enumjpaspring.entity.Gender;
import com.example.enumjpaspring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findAll ();
    List<User> findByGender (Gender gender);

    //List<User> findAllByGender ();
}
