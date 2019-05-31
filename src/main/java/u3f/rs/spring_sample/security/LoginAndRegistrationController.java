package u3f.rs.spring_sample.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import u3f.rs.spring_sample.security.entity.Authority;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller()
public class LoginAndRegistrationController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepo;

    @GetMapping("/register")
    public String registerForm(Model model){
        model.addAttribute("registrationForm", new RegistrationForm());
        return "registration";
    }

    @PostMapping("/register")
    public String processRegistration(@Valid RegistrationForm form, Errors errors){
        if (errors.hasErrors())
            return "registration";

        userRepo.save(form.toUser(passwordEncoder));
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginForm(HttpServletRequest req){
        return "login";
    }
}
