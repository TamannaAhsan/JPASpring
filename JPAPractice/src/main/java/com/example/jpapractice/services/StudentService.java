package com.example.jpapractice.services;

import com.example.jpapractice.entity.Status;
import com.example.jpapractice.entity.Student;
import com.example.jpapractice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public void saveStudent(){
        Student student = Student.builder()
                .studentName("TamannaAhsan")
                .studentEmail("tamanna@gmail.com")
                .status(Status.Present)
                .build();
        studentRepository.save(student);
    }

}
