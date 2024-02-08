package fr.eni.tp.filmotheque.bll.service;

import fr.eni.tp.filmotheque.bo.*;

import java.util.List;

public interface FilmService {
    public  List<Film> getAll();

    public  Film getById(long id);

    public  List<Genre> getGenres();

    public  List<Participant> getParticipant();

    public  Genre getGenreById(long id);

    public  Participant getParticipantById(long id);

    public  void addFilm(Film film);

    public void addAvis(Avis avis);

    public Membre getMembreById(Long id);
}
