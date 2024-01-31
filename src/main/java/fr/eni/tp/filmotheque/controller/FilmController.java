package fr.eni.tp.filmotheque.controller;

import fr.eni.tp.filmotheque.bll.mock.FilmServiceBouchon;
import fr.eni.tp.filmotheque.bo.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FilmController {

    @Autowired
    FilmServiceBouchon filmServiceBouchon;
    Film film;
    List<Film> filmList= new ArrayList<>();


    @GetMapping("/detailfilm/{id}")
    public String afficherUnFilm(@PathVariable(name = "id") int id, Model model) {

       this.film= filmServiceBouchon.consulterFilmParId(id);
        model.addAttribute("film", this.film);
        return "showfilm";
    }
    @GetMapping("/listfilm")
    public String afficherFilms(Model model) {

        this.filmList= filmServiceBouchon.consulterFilms();
        model.addAttribute("data", this.filmList);

        return "listfilm";
    }
}
