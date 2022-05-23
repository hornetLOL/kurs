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
    private final CurseService curseService;

    @GetMapping("/all")
    public String getStudentList(Model model, @RequestParam(name = "dateAfter", required = false) String dateAfter,
            @RequestParam(name = "dateBefore", required = false) String dateBefore,
                                 @RequestParam(name = "curse", required = false) String curseName,
                                 @RequestParam(name = "classNumber", required = false) Long classNum) {

        List<StudentDto> students;
        if(dateAfter != null){
            students = studentService.findAllAfterDate(dateAfter);
        }else if(dateBefore !=null){
            students = studentService.findAllBeforeDate(dateBefore);
        }else if(curseName != null){
            students = studentService.findAllByCurseName(curseName);
        }else if(classNum != null){
            students = studentService.findAllByClassNumber(classNum);
        }else
            students = studentService.findAll();
        model.addAttribute("students", students);
        return "student/student-list";
    }

    @GetMapping("/byId")
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
