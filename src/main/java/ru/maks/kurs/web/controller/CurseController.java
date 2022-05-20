package ru.maks.kurs.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.maks.kurs.service.CurseService;
import ru.maks.kurs.web.dto.CurseDto;

import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
@RequestMapping("/curse")
public class CurseController {

    private final CurseService curseService;

    @GetMapping("/all")
    public String getCurseList(Model model) {
        model.addAttribute("curses", curseService.findAll());
        return "curse-list";
    }

    @GetMapping
    public String getCurse(Model model, @RequestParam(name = "id", required = false) Long id) {
        CurseDto curse;
        if (id != null) {
            curse = curseService.findById(id);
        } else {
            curse = new CurseDto();
        }
        model.addAttribute("curse", curse);
        return "curse-form";
    }

    @PostMapping
    public String handlePost(CurseDto curse) {
        curseService.save(curse);
        return "redirect:/curse/all";
    }

    @GetMapping("/delete")
    public String deleteById(@RequestParam(name = "id") Long id) {
        curseService.deleteById(id);
        return "redirect:/curse/all";
    }

    @GetMapping
    public String getCurseListByCost(){
        //todo Получение списка курсов выше или ниже заданной цены
        return "";
    }

    @GetMapping
    public String getCurseListByTargetGroup(){
        //todo Получение списка курсов по заданной целевой аудитории
        return "";
    }

    @GetMapping
    public String getCurseByName(){
        //todo Вывод курса по названию
        return"";
    }

    @GetMapping
    public String getCurseListBySubject(){
        //todo Вывод списка курсов по заданному предмету
        return"";
    }

}