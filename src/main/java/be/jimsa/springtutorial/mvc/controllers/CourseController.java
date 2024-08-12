package be.jimsa.springtutorial.mvc.controllers;

import be.jimsa.springtutorial.mvc.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class CourseController {

    private final UserService userService;

    public CourseController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/course")
    public String courseListDisplay(Model model) {

        model.addAttribute("data", userService.getAllData());

        return "course.html";
    }

    @RequestMapping("/course/{display}")
    public String courseListDisplay(@PathVariable String display, Model model) {

        if (display.equalsIgnoreCase("math")) {
            model.addAttribute("data", userService.getMathData());
        } else if (display.equalsIgnoreCase("english")) {
            model.addAttribute("data", userService.getEnglishData());
        }else {
            model.addAttribute("data", userService.getAllData());
        }

        return "course.html";
    }



}
