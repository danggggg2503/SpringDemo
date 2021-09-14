package com.SpringDemo.demo.repository;

import com.SpringDemo.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long>{
    @Query(value = "select * from Student s where s.email = ?1", nativeQuery = true)
    public Student getStudentByEmailNative(String email);

    @Query(value = "select * from Student s where s.email = :email", nativeQuery = true)
    public Student getStudentByEmailNativeNameParam(@Param("email")String email);

    //jpql
    @Query(value = "select s from Student  s where s.email = ?1")
    public  Student getStudentByEmail(String email);

    @Query(value = "select s from Student  s where s.firstName = ?1 and s.lastName = ?2")
    public  Student getStudentByFLName(String firstName, String lastName);

}
