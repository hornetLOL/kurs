package ru.maks.kurs.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.maks.kurs.entity.Staff;
import ru.maks.kurs.entity.enums.StaffStatus;
import ru.maks.kurs.service.StaffService;
import ru.maks.kurs.service.StudentService;
import ru.maks.kurs.web.dto.StaffDto;
import ru.maks.kurs.web.dto.StudentDto;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/staff")
public class StaffController {

    private final StaffService staffService;

    @GetMapping("/all")
    public String getStaffList(Model model, @RequestParam(name = "selection", required = false) String selectionType,
                               @RequestParam(name = "parametr", required = false) String parametr) {

        List<StaffDto> staffs;
        if(selectionType != null && parametr != null) {
            switch (selectionType) {
                case "post":
                    staffs = staffService.findAllByPost(parametr);
                    break;
                case "status":
                    if(parametr.equals(StaffStatus.active.getTitle()))
                        staffs = staffService.findAllByStatus(StaffStatus.active);
                    else if(parametr.equals(StaffStatus.not_active.getTitle()))
                        staffs = staffService.findAllByStatus(StaffStatus.not_active);
                    else
                        staffs = staffService.findAll();
                    break;
                case "curse":
                    staffs = staffService.findAllByCurseName(parametr);
                    break;
                default:
                    staffs = staffService.findAll();
                    break;
            }
        }else
            staffs = staffService.findAll();
        model.addAttribute("staffs", staffs);
        return "staff/staff-list";
    }

    @GetMapping("/change")
    public String getStaff(Model model, @RequestParam(name = "id", required = false) Long id,
                           @RequestParam(name = "numPass", required = false) Long numPass) {
        StaffDto staff;
        if (id != null) {
            staff = staffService.findById(id);
        }else if(numPass != null){
            staff = staffService.findByNumpas(numPass);
        } else {
            staff = new StaffDto();
        }
        model.addAttribute("staff", staff);
        return "staff/staff-form";
    }

    @PostMapping
    public String handlePost(StaffDto staff) {
        staffService.save(staff);
        return "redirect:/staff/all";
    }

//    @GetMapping("/delete")
//    public String deleteById(@RequestParam(name = "id") Long id) {
//        staffService.deleteById(id);
//        return "redirect:/staff/aell";
//    }


}
