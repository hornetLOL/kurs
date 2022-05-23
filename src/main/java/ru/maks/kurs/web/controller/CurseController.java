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
import ru.maks.kurs.web.dto.CurseDto;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/curse")
public class CurseController {

    private final CurseService curseService;

    @GetMapping("/all")
    public String getCurseList(Model model, @RequestParam(name = "selection", required = false) String selectionType,
                               @RequestParam(name = "parametr", required = false) String parametr) {

        List<CurseDto> curses;
        if(selectionType != null && parametr != null) {
            switch (selectionType) {
                case "priceLower":
                    curses = curseService.findAllByPriceLower(Long.parseLong(parametr));
                    break;
                case "priceGreater":
                    curses = curseService.findAllByPriceGreater(Long.parseLong(parametr));
                    break;
                case "targetGroup":
                    curses = curseService.findAllByTargetGroup(parametr);
                    break;
                case "subject":
                    curses = curseService.findAllBySubject(parametr);
                    break;
                default:
                    curses = curseService.findAll();
                    break;
            }
        }else
            curses = curseService.findAll();
        model.addAttribute("curses", curses);
        return "curse/curse-list";
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

//    @GetMapping("/delete")
//    public String deleteById(@RequestParam(name = "id") Long id) {
//        curseService.deleteById(id);
//        return "redirect:/curse/all";
//    }

}