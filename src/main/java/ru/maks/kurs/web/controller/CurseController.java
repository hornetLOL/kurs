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
@RequestMapping("/curses")
public class CurseController {

    private final CurseService curseService;

    @GetMapping("/all")
    public String getCurseList(Model model, @RequestParam(name = "priceLower", required = false) Long priceLower,
                                 @RequestParam(name = "priceGreater", required = false) Long priceGreater,
                                 @RequestParam(name = "targetGroup", required = false) String targetGroup,
                                 @RequestParam(name = "subject", required = false) String subject) {

        List<CurseDto> curses;
        if(priceLower != null){
            curses = curseService.findAllByPriceLower(priceLower);
        }else if(priceGreater !=null){
            curses = curseService.findAllByPriceGreater(priceGreater);
        }else if(targetGroup !=null){
            curses = curseService.findAllByTargetGroup(targetGroup);
        }else if(subject !=null){
            curses = curseService.findAllBySubject(subject);
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