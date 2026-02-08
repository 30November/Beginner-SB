package com.example.demo.repo;
import com.example.demo.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface StudentRepo extends JpaRepository<Student,Integer>{
    
    @Query(value = "Select * from student where name LIKE %?1% ",
        nativeQuery = true
    )
    List<Student> findS(String subS);
}
