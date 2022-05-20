package ru.maks.kurs.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.maks.kurs.entity.Staff;
import ru.maks.kurs.service.StaffService;
import ru.maks.kurs.service.StudentService;
import ru.maks.kurs.web.dto.StaffDto;
import ru.maks.kurs.web.dto.StudentDto;

import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
@RequestMapping("/staff")
public class StaffController {

    private StaffService staffService;

    @GetMapping("/all")
    public String getStaffList(Model model) {
        model.addAttribute("staff", staffService.findAll());
        return "staff-list";
    }

    @GetMapping
    public String getStaff(Model model, @RequestParam(name = "id", required = false) Long id) {
        StudentDto staff;
        if (id != null) {
            staff = staffService.findById(id);
        } else {
            staff = new StaffDto();
        }
        model.addAttribute("staff", staff);
        return "staff-form";
    }

    @PostMapping
    public String handlePost(StaffDto staff) {
        staffService.save(staff);
        return "redirect:/staff/all";
    }

    @GetMapping("/delete")
    public String deleteById(@RequestParam(name = "id") Long id) {
        staffService.deleteById(id);
        return "redirect:/student/all";
    }

    @GetMapping
    public String getStaffListByPost(){
        //todo Получение списка сотрудников по заданной должности
        return "";
    }

    @GetMapping
    public String getStaffListByStatus(){
        //todo Получение списка сотрудников по заданному статусу
        return "";
    }

    @GetMapping
    public String getStaffByNumPas(){
        //todo Получение сотрудника по паспортным данным
        return"";
    }

}
