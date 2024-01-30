package fr.eni.tp.filmotheque.controller;

import fr.eni.tp.filmotheque.bll.mock.FilmServiceBouchon;
import fr.eni.tp.filmotheque.bo.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FilmController {

    @Autowired
    FilmServiceBouchon filmServiceBouchon;
    Film film;
    List<Film> filmList= new ArrayList<>();


    public void afficherUnFilm(int id) {

       this.film= filmServiceBouchon.consulterFilmParId(id);
        System.out.println(film);

    }
    @GetMapping("/listfilm")
    public String afficherFilms(Model model) {

        this.filmList= filmServiceBouchon.consulterFilms();
        model.addAttribute("data", this.filmList);

        return "listfilm";
    }
}
