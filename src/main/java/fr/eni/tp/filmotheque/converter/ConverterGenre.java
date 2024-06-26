package fr.eni.tp.filmotheque.converter;

import fr.eni.tp.filmotheque.bll.service.FilmService;
import fr.eni.tp.filmotheque.bo.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ConverterGenre implements Converter<String, Genre> {

    @Autowired
    FilmService filmServiceBouchon;

    @Override
    public Genre convert(String source) {
        int id = Integer.parseInt(source);
        System.out.println("converter genre");
        return this.filmServiceBouchon.getGenreById(id);
    }
}

