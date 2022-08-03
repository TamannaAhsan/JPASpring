package com.example.jpapractice.repository;

import com.example.jpapractice.entity.Guardian;
import com.example.jpapractice.entity.Status;
import com.example.jpapractice.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

  /*  @Test
    public void saveStudent(){
        Student student = Student.builder()
                .studentName("TamannaAhsan")
                .studentEmail("tamanna@gmail.com")
                .status(Status.Present)
                .build();
        studentRepository.save(student);
    }*/

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()

                .guardianEmail("ahsanAli@gmail.com")
                .guardianName("Ahsan Ali")
                .build();

        Student student = Student.builder()
                .studentEmail("tamal@gmail.com")
                .studentName("Tamal")
                .status(Status.Present)
                .guardian(guardian)
                .build();
        studentRepository.save(student);

    }
    @Test
    public void saveStudentsWithDetails(){
        Guardian guardian = Guardian.builder()

                .guardianEmail("hasanAli@gmail.com")
                .guardianName("hasan Ali")
                .build();

        Student st1 = Student.builder()
                .studentName("Zahin")
                .status(Status.Present)
                .guardian(guardian)
                .build();
        Student st2 = Student.builder()
                .studentName("Nila")
                .status(Status.Present)
                .guardian(guardian)
                .captain(st1)
                .build();

        studentRepository.save(st2);
    }


}




