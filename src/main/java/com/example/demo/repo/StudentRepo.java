package com.example.demo.repo;
import com.example.demo.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface StudentRepo extends JpaRepository<Student,Integer>{
    
    @Query("Select s from Student s where s.name like %?1%")
    List<Student> findS(String subS);
}
