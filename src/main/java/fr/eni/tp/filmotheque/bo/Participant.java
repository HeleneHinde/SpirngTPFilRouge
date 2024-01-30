package fr.eni.tp.filmotheque.bo;

import java.util.List;

public class Participant extends Personne{

    private List<Film> filmsActeur;
    private List<Film> filmReal;

    public Participant() {
        super();
    }

    public Participant(List<Film> filmsActeur, List<Film> filmReal) {
        super();
        this.filmsActeur = filmsActeur;
        this.filmReal = filmReal;
    }

    public Participant(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom=prenom;

    }

    public List<Film> getFilmsActeur() {
        return filmsActeur;
    }

    public void setFilmsActeur(List<Film> filmsActeur) {
        this.filmsActeur = filmsActeur;
    }

    public List<Film> getFilmReal() {
        return filmReal;
    }

    public void setFilmReal(List<Film> filmReal) {
        this.filmReal = filmReal;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "filmsActeur=" + filmsActeur +
                ", filmReal=" + filmReal +
                ", id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }
}
