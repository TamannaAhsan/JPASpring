package com.example.jpapractice.repository;

import com.example.jpapractice.entity.Course;
import com.example.jpapractice.entity.Status;
import com.example.jpapractice.entity.Student;
import com.example.jpapractice.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher.builder()
                .teacherName("Aditi")
                .build();
        Course course = Course.builder()
                .title("Python")
                .credit(3)
                .teacher(teacher)
                .build();
        courseRepository.save(course);
    }

    @Test
    public void saveCourseWithStudentAndTeacher(){

        Teacher teacher = Teacher.builder()
                .teacherName("Brishty")
                .build();
        Student student = Student.builder()
                .studentName("Amir")
                .studentEmail("amir@gmail.com")
                .status(Status.Present)
                .build();

        Course course = Course.builder()
                .title("AI")
                .credit(3)
                .teacher(teacher)
                .build();
        course.addStudent(student);
        courseRepository.save(course);


    }

}