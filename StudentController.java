package com.example.studentmanagement.controller;

import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/students";
    }

    @GetMapping("/students")
    public String list(Model model) {
        model.addAttribute("students", service.getAll());
        return "students";
    }

    @GetMapping("/students/new")
    public String newStudent(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("pageTitle", "Add Student");
        return "student-form";
    }

    @PostMapping("/students/save")
    public String save(@Valid @ModelAttribute("student") Student student,
                       BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("pageTitle", student.getId() == null ? "Add Student" : "Edit Student");
            return "student-form";
        }
        if (student.getId() == null) {
            service.create(student);
        } else {
            service.update(student);
        }
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("student", service.getById(id));
        model.addAttribute("pageTitle", "Edit Student");
        return "student-form";
    }

    @GetMapping("/students/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/students";
    }
}
