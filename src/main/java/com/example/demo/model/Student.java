package com.example.demo.model;
import jakarta.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String dept;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;


    public Student() {
        //This is for Hibernate ... use reflection    
    }

    public Student(String name, String dept, Course course) {
        //This is for developer
        this.name = name;
        this.dept = dept;
        this.course = course;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }


}
