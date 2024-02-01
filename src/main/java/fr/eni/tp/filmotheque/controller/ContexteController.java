package fr.eni.tp.filmotheque.controller;

import fr.eni.tp.filmotheque.bll.context.ContexteServiceBouchon;
import fr.eni.tp.filmotheque.bo.Membre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@SessionAttributes("membreConnecte")
@Controller
public class ContexteController {

    @Autowired
    ContexteServiceBouchon contexteServiceBouchon;

    @GetMapping("/contexte")
    public String seConnecterAuContexte() {

        return "contexte";
    }

    @PostMapping("/contexte")
    public String seConnecterAuContextePost(Model model, RedirectAttributes redirectAttributes) {

       String mail = "jtrillard@campus-eni.fr";

        Membre membre =  this.contexteServiceBouchon.charger(mail);

        if (membre != null) {
            // Ajoutez le membreConnecte à la session
            model.addAttribute("membreConnecte", membre);
            redirectAttributes.addFlashAttribute("flash_message", "Vous vous êtes connecté avec succès!");
            return "redirect:/";
        } else {
            // Gestion de l'échec de connexion
            return "contexte";
        }
    }

    @GetMapping("/contexteoff")
    public String seDeConnecterAuContextePost(SessionStatus sessionStatus) {

        sessionStatus.setComplete();
        return "redirect:/";
    }
}
