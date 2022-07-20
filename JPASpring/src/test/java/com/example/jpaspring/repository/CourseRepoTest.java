package com.example.jpaspring.repository;

import com.example.jpaspring.entity.Course;
import com.example.jpaspring.entity.Student;
import com.example.jpaspring.entity.Teacher;
import org.apache.catalina.LifecycleState;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepoTest {

    @Autowired
    private CourseRepo courseRepo;

    @Test
    public void printCourses(){
        List<Course> courseList = courseRepo.findAll();
        System.out.println("All courses: "+courseList);
    }
    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Aditi")
                .lastName("Hossain")
                .build();
        Course course = Course.builder()
                .title("Python")
                .credit(3)
                .teacher(teacher)
                .build();
        courseRepo.save(course);
    }

    @Test
    public void findAllPagination(){
        Pageable firstWithThreeRecords = PageRequest.of(0,3);
        Pageable firstWithTwoRecords = PageRequest.of(1,2);

        List<Course> courses = courseRepo.findAll(firstWithThreeRecords).getContent();
        Long totalElements = courseRepo.findAll(firstWithThreeRecords).getTotalElements();
        Integer totalPages = courseRepo.findAll(firstWithThreeRecords).getTotalPages();
        System.out.println("Elements: "+totalElements);
        System.out.println("Pages: "+totalPages);
        System.out.println("Courses: "+courses);
    }

    @Test
    public void saveCourseWithStudentAndTeacher(){

        Teacher teacher = Teacher.builder()
                .firstName("Brishty")
                .lastName("Islam")
                .build();
        Student student = Student.builder()
                .firstName("Atik")
                .lastName("Khan")
                .emailId("atik@gmail.com")
                .build();

        Course course = Course.builder()
                .title("AI")
                .credit(3)
                .teacher(teacher)
                .build();
        course.addStudent(student);
        courseRepo.save(course);


    }


}