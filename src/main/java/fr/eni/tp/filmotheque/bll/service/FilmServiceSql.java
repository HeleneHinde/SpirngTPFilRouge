package fr.eni.tp.filmotheque.bll.service;

import fr.eni.tp.filmotheque.bo.*;
import fr.eni.tp.filmotheque.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("sql")
public class FilmServiceSql implements FilmService {

    @Autowired
    IFilmRepository filmRepository;
    @Autowired
    IAvisRepository avisRepository;

    @Autowired
    IMembreRepository membreRepository;

    @Autowired
    IGenreRepository genreRepository;

    @Autowired
    IParticipantRepository participantRepository;

    @Override
    public List<Film> getAll() {
        return (List<Film>) filmRepository.findAll();
    }

    @Override
    public Film getById(long id) {
        return filmRepository.findById(id).get();
    }

    @Override
    public List<Genre> getGenres() {

        return (List<Genre>) genreRepository.findAll();
    }

    @Override
    public List<Participant> getParticipant() {

        return (List<Participant>) participantRepository.findAll();
    }

    @Override
    public Genre getByGenreAndId(long id) {
        return null;
    }

    @Override
    public Participant getByParticipantAndId(long id) {
        return null;
    }

    @Override
    public void addFilm(Film film) {
        filmRepository.save(film);

    }

    @Override
    public void addAvis(Avis avis) {
        avisRepository.save(avis);
    }

    @Override
    public Membre getMembreById(Long id) {
        return membreRepository.findById(id).get();
    }
}
