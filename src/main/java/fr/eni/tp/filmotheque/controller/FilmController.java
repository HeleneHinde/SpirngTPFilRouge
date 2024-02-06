package fr.eni.tp.filmotheque.controller;

import fr.eni.tp.filmotheque.bll.mock.FilmServiceBouchon;
import fr.eni.tp.filmotheque.bo.Film;
import fr.eni.tp.filmotheque.bo.Genre;
import fr.eni.tp.filmotheque.bo.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@SessionAttributes({"membreConnecte", "genres"})
@Controller
public class FilmController {

    @Autowired
    FilmServiceBouchon filmServiceBouchon;




    @GetMapping("/detailfilm/{id}")
    public String afficherUnFilm(@PathVariable(name = "id") int id, Model model) {

        if(model.getAttribute("membreConnecte") != null){
            Film film= filmServiceBouchon.consulterFilmParId(id);
            model.addAttribute("film", film);
            return "showfilm";
        }
        return "redirect:/";
    }

    @GetMapping("/addfilm")
    public String creerUnFilm(Model model) {

        Film film = new Film();
        model.addAttribute("film", film);
        List<Genre> genres = this.filmServiceBouchon.consulterGenres();
        model.addAttribute("genresList", genres);
        List<Participant> acteurs = this.filmServiceBouchon.consulterParticipants();
        model.addAttribute("acteurs", acteurs);

        return "addfilm";
    }

    @PostMapping("/addfilm")
    public String creerUnFilmPost(@ModelAttribute("film") Film film,BindingResult bindingResult) {
        System.out.println(film + "post");
        this.filmServiceBouchon.ajouterFilm(film);

        System.out.println(film);
        if (!film.getTitre().isEmpty()){
            return "redirect:/";
        }
        return "addfilm";
    }


    @GetMapping("/listfilm")
    public String afficherFilms(Model model) {
        List<Film> filmList= new ArrayList<>();
        filmList= filmServiceBouchon.consulterFilms();
        model.addAttribute("data", filmList);

        return "listfilm";
    }
}
