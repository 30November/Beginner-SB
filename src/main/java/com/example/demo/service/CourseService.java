package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.model.Course;
import com.example.demo.repo.CourseRepo;
import java.util.List;

@Service
public class CourseService {
    private final CourseRepo courseRepo;

    public CourseService(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    public Course addCourse(Course course){
        return courseRepo.save(course);
    }

    public List<Course> allCourse()
    {
        return courseRepo.findAll();
    }

    public void delCourse(int id)
    {
        courseRepo.deleteById(id);
    }

    public Course oneCourse(String cid)
    {
        int id = Integer.parseInt(cid);
        return courseRepo.findById(id).orElse(null);
    }
    

}
