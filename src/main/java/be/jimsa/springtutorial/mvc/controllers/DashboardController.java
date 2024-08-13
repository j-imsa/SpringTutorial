package be.jimsa.springtutorial.mvc.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {

    @RequestMapping(value = {"/dashboard"})
    public String displayDashboardPage(Model model, Authentication auth) {
         model.addAttribute("username", auth.getName());
         model.addAttribute("roles", auth.getAuthorities().toString());
        return "dashboard.html";
    }
}
