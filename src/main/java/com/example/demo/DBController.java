package com.example.demo;

import com.example.demo.model.*;

import com.example.demo.service.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/list")
public class DBController {

    private final StudentService studentService;
    private final CourseService courseService;

    public DBController(StudentService studentService, CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }

    @GetMapping
    String render(Model model) {

       try {
         List<Student> stu = studentService.allStudent();
         List<Course> crs = courseService.allCourse();
         model.addAttribute("stu", stu);
         model.addAttribute("crs", crs);
       } catch (Exception e) {
        System.out.println(e);
       }
        
        return "all";
    }

    @PostMapping("/addS")
    String fetchdataS(@RequestParam Map<String, String> s) {
        String name = s.get("name");
        String dept = s.get("dept");
        // int cid = Integer.parseInt(c.get("cid"));
        studentService.addStudent(new Student(name, dept, null));
        // studentService.addStudent(new Student(name,dept,#tofetch));
        return "redirect:/list";

    }

    @PostMapping("/addC")
    String fetchdataC(@RequestParam Map<String, String> c) {
        String subject = c.get("sub");
        String title = c.get("title");
        String professor = c.get("prof");

        courseService.addCourse(new Course(subject, title, professor));

        return "redirect:/list";

    }

}
