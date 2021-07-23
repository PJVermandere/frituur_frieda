package be.vdab.frituur_frieda.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("headerInfo")

public class RequestheaderInfoController {
    @GetMapping
    public ModelAndView headerInfo(@RequestHeader() Map<String, String> rHeader) {
        return new ModelAndView("headerInfo", "rHeader", rHeader);
    }
}