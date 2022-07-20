package com.example.jpaspring.repository;

import com.example.jpaspring.entity.Guardian;
import com.example.jpaspring.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest

class StudentRepoTest {

    @Autowired
    private StudentRepo studentRepo;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("tam@gmail.com")
                .firstName("Tamanna")
                .lastName("Ahsan")

                //.guardianMobile("0987")
                //.guardianEmail("ahsanAli@gmail.com")
                //.guardianName("Ahsan Ali")

                .build();
        studentRepo.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .mobile("0987")
                .email("ahsanAli@gmail.com")
                .name("Ahsan Ali")
                .build();

        Student student = Student.builder()
                .emailId("tamal@gmail.com")
                .firstName("Tamal")
                .lastName("Ahsan")
                .guardian(guardian)
                .build();
        studentRepo.save(student);

    }

    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepo.findAll();
        System.out.println("All students: "+studentList);
    }
    @Test
    public void printStudentByFirstName(){
        List<Student> studentsFirstName = studentRepo.findByFirstName("Tamal");
        System.out.println("FirstName of students: "+studentsFirstName);
    }

    @Test
    public void printStudentByLastName(){
        List<Student> studentsLastName = studentRepo.findByLastName("Ahsan");
        System.out.println("LastName of students: "+studentsLastName);
    }
    @Test
    public void printFirstNameContaining(){
        List<Student> studentsFirstNameContaining = studentRepo.findByFirstNameContaining("Tama");
        System.out.println("FirstNameContaining of students: "+studentsFirstNameContaining);
    }
    @Test
    public void printGuardianName(){
        List<Student> studentsGuardianName = studentRepo.findByGuardianName("Ahsan Ali");
        System.out.println("Guardian Name: "+studentsGuardianName);
    }
    @Test
    public void printFirstNameAndLastName(){
        Student studentFirstLastNames = studentRepo.findByFirstNameAndLastName("Tamanna", "Ahsan");
        System.out.println("Students first and last name: "+studentFirstLastNames);
    }

    @Test
    public void printStudentEmailId(){
        Student studentEmailId = studentRepo.getStudentByEmailId("tamal@gmail.com");
        System.out.println("Email of students: "+studentEmailId);
    }

    @Test
    public void printFirstNameStudentEmailId(){
        String studentFirstNameEmailId = studentRepo.getStudentByFirstNameEmailId("tamal@gmail.com");
        System.out.println("Email of students: "+studentFirstNameEmailId);
    }

    @Test
    public void printStudentEmailIdNative(){
        Student studentEmailId = studentRepo.getStudentByEmailIdNative("tamal@gmail.com");
        System.out.println("Email of students: "+studentEmailId);
    }

    @Test
    public void printStudentByEmailIdNativeParam(){
        Student studentEmailId = studentRepo.getStudentByEmailIdNativeParam("tamal@gmail.com");
        System.out.println("Email of students: "+studentEmailId);
    }

    @Test
    public void updateStudentNameByEmailId(){
        studentRepo.updateStudentNameAndEmailId("Brishty","tam@gmail.com");
    }







}