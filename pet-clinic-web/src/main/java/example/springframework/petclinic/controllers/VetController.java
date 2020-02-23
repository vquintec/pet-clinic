package example.springframework.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import example.springframework.petclinic.services.VetService;

@RequestMapping("/vets")
@Controller
public class VetController {
    
    private final VetService vetService;
    
    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String getVetList(Model model) {
        model.addAttribute("vets", vetService.findAll());
        return "vets/index";
    }
    
}
