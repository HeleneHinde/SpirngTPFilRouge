package fr.eni.tp.filmotheque.controller;

import fr.eni.tp.filmotheque.bo.Membre;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("data", "Welcome home man");
        return "welcome";
    }

    @PostMapping("/login")
    public String loginForm(@ModelAttribute("formUser") Membre membre, Model model){
        model.addAttribute("user", membre);
        System.out.println(membre);
        return "login-form";
    }
    @GetMapping("/login")
    public String loginFormGet(Model model){
        Membre user = new Membre("coucou","coucou",true,null);
        model.addAttribute("user", user);
        return "login-form";
    }
}