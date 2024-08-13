package be.jimsa.springtutorial.mvc.controllers;

import be.jimsa.springtutorial.mvc.models.requests.UserRequest;
import be.jimsa.springtutorial.mvc.services.ContactService;
import be.jimsa.springtutorial.mvc.services.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
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
    private final ContactService contactService;

    public ContactController(UserService userService, ContactService contactService) {
        this.userService = userService;
        this.contactService = contactService;
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
            @Valid @ModelAttribute("user") UserRequest user,
            Errors errors
    ) {

        if (errors.hasErrors()) {
            log.info("Errors: {}", errors.getAllErrors());
            return new ModelAndView("contact.html");
        }

        log.info("Name is {}", name);
        log.info("Email address is {}", emailAddress);

        userService.manageUserInfo(user);
        log.info("Counter is {}", contactService.increaseCounter());

        return new ModelAndView("redirect:/contact");
    }
}
