package be.jimsa.springtutorial.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value = {"", "/", "home"})
    public String displayHomePage(Model model) {
         model.addAttribute("pageName", "Home");
         model.addAttribute("name", "John");
        return "home.html";
    }
}
