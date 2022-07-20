package com.example.jpaspring.repository;

import com.example.jpaspring.entity.Student;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository

public interface StudentRepo extends JpaRepository<Student, Integer> {

   List<Student> findByFirstName (String firstName);
   List<Student> findByLastName (String lastName);
   List<Student> findByFirstNameContaining (String name);
   List<Student> findByGuardianName (String name);
   Student findByFirstNameAndLastName(String firstName, String lastname);

   //JPQL
   @Query("select s from Student s where s.emailId =?1")
   Student getStudentByEmailId(String email);

   @Query("select s.firstName from Student s where s.emailId =?1")
   String getStudentByFirstNameEmailId(String email);

   //Native
   @Query(
           value = "select * from student s where s.email_address=?1",
           nativeQuery = true
   )
   Student getStudentByEmailIdNative(String email);

   @Query(
           value = "select * from student s where s.email_address=:emailId",
           nativeQuery = true
   )
   Student getStudentByEmailIdNativeParam(@Param("emailId") String email);

   @Modifying
   @Transactional
   @Query(
           value = "update student set first_name=?1 where email_address=?2",
           nativeQuery = true
   )
   int updateStudentNameAndEmailId(String firstName, String emailId);


}
