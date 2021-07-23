package be.vdab.frituur_frieda.controllers;

import be.vdab.frituur_frieda.domain.Adres;
import be.vdab.frituur_frieda.domain.Gemeente;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.DayOfWeek;
import java.time.LocalDate;

@Controller
@RequestMapping("/")
class IndexController {
    @GetMapping
    public ModelAndView index() {
        String status = LocalDate.now().getDayOfWeek() == DayOfWeek.MONDAY ? "gesloten" : "open";
        ModelAndView view = new ModelAndView("index", "openGesloten", status);

        view.addObject("adres", new Adres("Ellermanstraat","1305", new Gemeente("Antwerpen",2060)));
        return view;
    }
}