package com.example.jpaspring.repository;

import com.example.jpaspring.entity.Course;
import com.example.jpaspring.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TeacherRepoTest {

    @Autowired
    private TeacherRepo teacherRepo;


    @Test
    public void saveTeacher(){
        Course courseA = Course.builder()
                .title("Bangla")
                .credit(3)
                .build();
        Course courseB = Course.builder()
                .title("Java")
                .credit(3)
                .build();
        Teacher teacher = Teacher.builder()
                .firstName("Mila")
                .lastName("Akhter")
                //.courses(List.of(courseA,courseB))
                .build();
        teacherRepo.save(teacher);

    }

}