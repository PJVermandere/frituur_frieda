package be.vdab.frituur_frieda.controllers;

import be.vdab.frituur_frieda.domain.Sauzen;
import be.vdab.frituur_frieda.services.KoersWisselService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.Arrays;

@Controller
@RequestMapping("/sauzen")
public class SauzenController {
    private final KoersWisselService wisselService;
    Sauzen[] sauzen = {
            new Sauzen(1,"cocktail", new String[]{"ketchup", "mayo"}, BigDecimal.valueOf(2.5)),
            new Sauzen(2,"mayonaise", new String[]{"mosterd", "eitjes", "azijn", "olie"}, BigDecimal.valueOf(2.5)),
            new Sauzen(3,"mosterd", new String[]{"moster", "mosterdzaad"}, BigDecimal.valueOf(2.5)),
            new Sauzen(4,"tartare", new String[]{"look", "kapertjes", "peterselie", "mayo"}, BigDecimal.valueOf(2.5)),
            new Sauzen(5,"vinaigrette", new String[]{"olie", "azijn", "zout", "peper"}, BigDecimal.valueOf(2.5))
    };

    public SauzenController(KoersWisselService wisselService) {
        this.wisselService = wisselService;
    }

    @GetMapping
    public ModelAndView sauzen(){
        ModelAndView sauzenMVC = new ModelAndView("sauzen", "sauzen", sauzen);

        return sauzenMVC;
    }
    @GetMapping("{id}")
    public ModelAndView saus(@PathVariable long id){
        var sauzenMAV = new ModelAndView("saus");
        Arrays.stream(sauzen).filter(saus -> saus.getNummer() == id).findFirst().ifPresent(e-> {
            sauzenMAV.addObject("saus", e);
            sauzenMAV.addObject("dollar", wisselService.naarDollar(e.getPrijs()));
        });
        return sauzenMAV;
    }
}
