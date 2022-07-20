package com.example.jpaspring.repository;

import com.example.jpaspring.entity.Course;
import com.example.jpaspring.entity.CourseMaterials;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialsRepoTest {

    @Autowired
    private CourseMaterialsRepo repository;

    @Test
    public void saveCoursematerials(){
        Course course = Course.builder()
                .title("Bangla")
                .credit(3)
                .build();
        CourseMaterials courseMaterial = CourseMaterials.builder()
                .url("www.google.com")
                .course(course)
                .build();
        repository.save(courseMaterial);

    }

    @Test
    public void printAllCourseMaterials(){
        List<CourseMaterials> courseMaterialsList = repository.findAll();
        System.out.println("All course materials: "+courseMaterialsList);
    }

}