package fr.eni.tp.filmotheque.controller;

import fr.eni.tp.filmotheque.bo.Membre;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("data", "Welcome home man");
        return "welcome";
    }

    @GetMapping("/login")
    public String loginFormGet(Model model){
        Membre user = new Membre("coucou","coucou",true,null);
        model.addAttribute("user", user);
        return "login-form";
    }

    @PostMapping("/login")
    public String loginForm(@ModelAttribute("formUser") Membre membre, Model model, RedirectAttributes redirectAttributes){
        model.addAttribute("user", membre);

        if (!membre.getMotDePasse().isEmpty()){
            redirectAttributes.addFlashAttribute("flash_message", "Vous vous êtes connecté avec succès!");
            return "redirect:/";
        }
        return "login-form";
    }

}