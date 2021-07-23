package be.vdab.frituur_frieda.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller @RequestMapping("cookies")
public class CookieController {
    @GetMapping
    public ModelAndView cookies(@CookieValue Optional<String> bezocht, HttpServletResponse response){
        var modView = new ModelAndView("cookies", "bezocht", "1");
        var cookie = new Cookie("bezocht","1");
        cookie.setMaxAge(3153600);
        cookie.setPath("/");
        bezocht.ifPresent(val -> cookie.setValue(String.valueOf(Integer.parseInt(val)+1)));
        bezocht.ifPresent(val -> modView.addObject("bezocht", String.valueOf(Integer.parseInt(val)+1)));
        response.addCookie(cookie);
        return modView;
    }

}
