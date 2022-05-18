package ru.maks.kurs.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.maks.kurs.service.StudentService;
import ru.maks.kurs.web.dto.StudentDto;

import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/all")
    public String getStudentList(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "student-list";
    }

    @GetMapping
    public String getStudent(Model model, @RequestParam(name = "id", required = false) Long id) {
        StudentDto student;
        if (id != null) {
            student = studentService.findById(id);
        } else {
            student = new StudentDto();
        }
        model.addAttribute("student", student);
        return "student-form";
    }

    @PostMapping
    public String handlePost(StudentDto student) {
        studentService.save(student);
        return "redirect:/student/all";
    }

    @GetMapping("/delete")
    public String deleteById(@RequestParam(name = "id") Long id) {
        studentService.deleteById(id);
        return "redirect:/student/all";
    }
}
