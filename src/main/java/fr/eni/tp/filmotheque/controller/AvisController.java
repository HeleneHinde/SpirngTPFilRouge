package fr.eni.tp.filmotheque.controller;

import fr.eni.tp.filmotheque.bll.mock.FilmServiceBouchon;
import fr.eni.tp.filmotheque.bo.Avis;
import fr.eni.tp.filmotheque.bo.Film;
import fr.eni.tp.filmotheque.bo.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@SessionAttributes({"membreConnecte"})
@Controller
public class AvisController {

    @Autowired
    FilmServiceBouchon filmServiceBouchon;

    @GetMapping("/addavis/{id}")
    public String creerUnAvis(@PathVariable(name = "id") int id, Model model) {

        if(model.getAttribute("membreConnecte") != null) {

            Film film = filmServiceBouchon.consulterFilmParId(id);
            model.addAttribute("film", film);
            Avis avis = new Avis();
            model.addAttribute("avis", avis);

            return "addavis";
        }
        return "redirect:/";
    }

    @PostMapping("/addavis/{id}")
    public String creerUnAvisPost(@PathVariable(name = "id") int id, @ModelAttribute("formAvis") Avis avis, Model model, RedirectAttributes redirectAttributes) {

        model.addAttribute("avis", avis);
        System.out.println(avis);

        if (!avis.getCommentaire().isEmpty()){
            Film film = filmServiceBouchon.consulterFilmParId(id);
            film.addAvis(avis);
            model.addAttribute("film", film);
            // Ajouter un message flash pour afficher après la redirection
            redirectAttributes.addFlashAttribute("flash_message", "Commentaire ajouté avec succès!");
            return "redirect:/";
        }
        return "addavis";
    }
}
