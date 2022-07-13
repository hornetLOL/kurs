package ru.maks.kurs.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.maks.kurs.service.PriceChangeService;
import ru.maks.kurs.web.dto.PriceChangeDto;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/pricechange")
public class PriceChangeController {
    
    private final PriceChangeService priceChangeService;

    @GetMapping
    public String getPriceChangeList(Model model) {
        List<PriceChangeDto> priceChanges = priceChangeService.findAll();
        model.addAttribute("changes", priceChanges);
        return "priceChange/priceChange-list";
    }

//    @GetMapping("/change")
//    public String getPriceChange(Model model, @RequestParam(name = "id", required = false) Long id) {
//        PriceChangeDto priceChange;
//        if (id != null) {
//            priceChange = priceChangeService.findById(id);
//        } else {
//            priceChange = new PriceChangeDto();
//        }
//        model.addAttribute("priceChange", priceChange);
//        return "priceChange/priceChange-form";
//    }

//    @PostMapping
//    public String handlePost(PriceChangeDto priceChange) {
//        priceChangeService.save(priceChange);
//        return "redirect:/priceChange/all";
//    }

//    @GetMapping("/delete")
//    public String deleteById(@RequestParam(name = "id") Long id) {
//        priceChangeService.deleteById(id);
//        return "redirect:/priceChange/all";
//    }
}
