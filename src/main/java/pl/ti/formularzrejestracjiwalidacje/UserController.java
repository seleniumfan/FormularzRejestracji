package pl.ti.formularzrejestracjiwalidacje;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    String showForm(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }

    @PostMapping("/register")
    String register(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "index";
        } else {
            userService.saveUser(user);
            return "redirect:success";
        }
    }

    @GetMapping("/success")
    String showSuccess() {
        return "success";
    }

    @GetMapping("/regulations")
    String showRegulations() {
        return "regulations";
    }
}
