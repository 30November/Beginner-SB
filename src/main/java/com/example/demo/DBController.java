package com.example.demo;

import com.example.demo.model.*;

import com.example.demo.service.*;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

        List<Student> stu = studentService.allStudent();
        List<Course> crs = courseService.allCourse();
        model.addAttribute("stu", stu);
        model.addAttribute("crs", crs);

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

    @DeleteMapping("/s:{id}")
    String removedataS(@PathVariable int id) {
        studentService.delStudent(id);
        return "redirect:/list";
    }

    @GetMapping("/search")
    String search(
            @RequestParam(defaultValue = "") String q,
            Model model) {
        
                if (q.isEmpty())
            model.addAttribute("stu", studentService.allStudent());
        else
            model.addAttribute("stu", studentService.fewStudent(q));
        return "search";
    }

    @PostMapping("/searchS")
    String searchStudent(@RequestParam String searchS) {
        return "redirect:/list/search?q=" + searchS;
    }

}
