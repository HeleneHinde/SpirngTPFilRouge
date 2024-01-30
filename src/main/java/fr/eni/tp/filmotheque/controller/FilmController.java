package fr.eni.tp.filmotheque.controller;

import fr.eni.tp.filmotheque.bll.mock.FilmServiceBouchon;
import fr.eni.tp.filmotheque.bo.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Component
public class FilmController {

    @Autowired
    FilmServiceBouchon filmServiceBouchon;
    Film film;
    List<Film> filmList= new ArrayList<>();

    public void afficherUnFilm(int id) {

       this.film= filmServiceBouchon.consulterFilmParId(id);
        System.out.println(film);

    }

    public void afficherFilms() {
        this.filmList=filmServiceBouchon.consulterFilms();
        for (Film film : filmList){
            System.out.println(film);
        }
    }
}
