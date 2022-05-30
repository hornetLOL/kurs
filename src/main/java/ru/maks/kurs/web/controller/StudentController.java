package ru.maks.kurs.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.maks.kurs.entity.relationTables.PurchasedCurse;
import ru.maks.kurs.service.CurseService;
import ru.maks.kurs.service.StudentService;
import ru.maks.kurs.web.dto.CurseDto;
import ru.maks.kurs.web.dto.StudentDto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/all")
    public String getStudentList(Model model, @RequestParam(name = "selection", required = false) String selectionType,
                                 @RequestParam(name = "parametr", required = false) String parametr) {

        List<StudentDto> students;
        if(selectionType != null && parametr != null) {
            switch (selectionType) {
                case "dateAfter":
                    students = studentService.findAllAfterDate(parametr);
                    break;
                case "dateBefore":
                    students = studentService.findAllBeforeDate(parametr);
                    break;
                case "curse":
                    students = studentService.findAllByCurseName(parametr);
                    break;
                case "classNumber":
                    students = studentService.findAllByClassNumber(Long.parseLong(parametr));
                    break;
                default:
                    students = studentService.findAll();
                    break;
            }
        }else
            students = studentService.findAll();
        model.addAttribute("students", students);
        return "student/student-list";
    }

    @GetMapping("/change")
    public String getStudent(Model model, @RequestParam(name = "id", required = false) Long id) {
        StudentDto student;
        if (id != null) {
            student = studentService.findById(id);
        } else {
            student = new StudentDto();
        }
        model.addAttribute("student", student);
        return "student/student-form";
    }

//    @GetMapping
//    public String studentFinder(Model model){
//        List<CurseDto> curses = curseService.findAll();
//        model.addAttribute("curses", curses);
//        return "student-finder";
//    }

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
