package fr.eni.tp.filmotheque.controller;

import fr.eni.tp.filmotheque.bll.service.FilmService;
import fr.eni.tp.filmotheque.bll.service.FilmServiceBouchon;
import fr.eni.tp.filmotheque.bo.Avis;
import fr.eni.tp.filmotheque.bo.Film;
import fr.eni.tp.filmotheque.bo.Membre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@SessionAttributes({"membreConnecte"})
@Controller
public class AvisController {

    @Autowired
    FilmService filmServiceBouchon;

    @GetMapping("/addavis/{id}")
    public String creerUnAvis(@PathVariable(name = "id") int id, Model model) {

        if(model.getAttribute("membreConnecte") != null) {

            Film film = filmServiceBouchon.getById(id);
            model.addAttribute("film", film);
            Avis avis = new Avis();
            model.addAttribute("avis", avis);

            return "addavis";
        }
        return "redirect:/";
    }

    @PostMapping("/addavis/{id}")
    public String creerUnAvisPost(@PathVariable(name = "id") int id,
                                  @Valid @ModelAttribute("formAvis") Avis avis,
                                  BindingResult result,
                                  Model model,
                                  RedirectAttributes redirectAttributes
                                  ) {

        model.addAttribute("avis", avis);
        System.out.println(avis);

        System.out.println(result.hasErrors());

        if (result.hasErrors()) {
            System.out.println("controle erreur");
            model.addAttribute("errors", result.getAllErrors());
            Film film = filmServiceBouchon.getById(id);
            model.addAttribute("film", film);
            model.addAttribute("avis", avis);
            return "addavis";
        }

        if (!avis.getCommentaire().isEmpty()) {
            Film film = filmServiceBouchon.getById(id);
            Membre auteur = filmServiceBouchon.getMembreById(1L);
            avis.setFilm(film);
            avis.setAuteur(auteur);
           // filmServiceBouchon.addAvis(avis);
            film.getAvis().add(avis);
            filmServiceBouchon.addFilm(film);
            model.addAttribute("film", film);
            // Ajouter un message flash pour afficher après la redirection
            redirectAttributes.addFlashAttribute("flash_message", "Commentaire ajouté avec succès!");
            return "redirect:/";
        }
        return "addavis";
    }
}
