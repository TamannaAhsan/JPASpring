package com.example.jpapractice.repository;

import com.example.jpapractice.entity.Course;
import com.example.jpapractice.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCoursematerial(){
        Course course = Course.builder()
                .title("CSE")
                .credit(3)
                .build();
        CourseMaterial courseMaterial = CourseMaterial.builder()
                .outline("www.google.com")
                .course(course)
                .build();
        courseMaterialRepository.save(courseMaterial);

    }

}