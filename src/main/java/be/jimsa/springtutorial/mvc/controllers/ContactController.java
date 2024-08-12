package be.jimsa.springtutorial.mvc.controllers;

import be.jimsa.springtutorial.mvc.models.requests.UserRequest;
import be.jimsa.springtutorial.mvc.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@Slf4j
public class ContactController {

    private final UserService userService;

    public ContactController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping("/contact")
    public String contact(Model model) {

        UserRequest userRequest = new UserRequest();
        model.addAttribute("user", userRequest);

        List<String> listProfession = userService.getProfessions();
        model.addAttribute("listProfession", listProfession);

        return "contact.html";
    }

    // @RequestMapping(value = "/saveMessage", method = RequestMethod.POST)
    @PostMapping("/saveMessage")
    public ModelAndView manageForm(
            @RequestParam String name,
            @RequestParam(name = "email") String emailAddress,
            @ModelAttribute("user") UserRequest user
    ) {
        log.info("Name is {}", name);
        log.info("Email address is {}", emailAddress);

        userService.manageUserInfo(user);

        return new ModelAndView("redirect:/contact");
    }
}
