package fr.eni.tp.filmotheque.controller.rest;

import fr.eni.tp.filmotheque.bll.service.FilmService;
import fr.eni.tp.filmotheque.bo.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Profile("rest")
@RestController
@CrossOrigin
public class FilmRestController {

    @Autowired
    FilmService filmService;

    @GetMapping("film-rest")
    Film getMovieById(){
        return filmService.getById(1L);
    }

    @GetMapping("/detailfilm/{id}")
    public Film afficherUnFilm(@PathVariable(name = "id") int id) {
        return filmService.getById(id);
    }

    @PostMapping("/addfilm")
    public ResponseEntity<Film> creerUnFilmPost(@Valid @RequestBody Film film) {

        Film createdFilm = filmService.addFilm(film);
        return new ResponseEntity<>(createdFilm, HttpStatus.CREATED);
    }


    @GetMapping("/listfilm")
    public List<Film> afficherFilms() {
        return filmService.getAll();
    }

}
