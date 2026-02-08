package com.example.demo.service;
import com.example.demo.model.Student;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.demo.repo.StudentRepo;

@Service
public class StudentService {

    private final StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public Student addStudent(Student student)
    {
        return studentRepo.save(student);
    }

    public List<Student> allStudent()
    {
        return studentRepo.findAll();
    }

    public void delStudent(int id)
    {
        studentRepo.deleteById(id);
    }

    public Student oneStudent(Integer sid)
    {
        return studentRepo.findById(sid).orElse(null);
    }

    public List<Student> fewStudent(String subS)
    {
        return studentRepo.findS(subS);
    }

}
