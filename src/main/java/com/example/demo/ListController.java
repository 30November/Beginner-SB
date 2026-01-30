package com.example.demo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; 

class StudentL{
    String name, dept;

    public StudentL(String name, String dept) {
        this.name = name;
        this.dept = dept;
    }

}

@Controller
@RequestMapping("/student")
public class ListController {

    ArrayList<StudentL> student = new ArrayList<>(); 
    
    @GetMapping
    String allStudent(Model model)
    {
        model.addAttribute("stu", student);
        model.addAttribute("size", student.size()-1);
        return "entry";
    }

    @PostMapping("/add")
    String addStudent(@RequestParam Map<String,String> stu)
    {
        String name = stu.get("name");
        String dept = stu.get("dept");
        student.add(new StudentL(name, dept));

        return "redirect:/student";
   
    }

    @PostMapping("/del")
    String delStudent(@RequestParam String del)
    {
        int idx = Integer.parseInt(del);
        student.remove(idx);
        return "redirect:/student";
   
    }

}



