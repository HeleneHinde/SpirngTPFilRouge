package fr.eni.tp.filmotheque.bo;

import java.util.List;

public class Genre {

    private int id;
    private String titre;
    private List<Film> films;

    public Genre() {
    }

    public Genre(int id, String titre, List<Film> films) {
        this.id = id;
        this.titre = titre;
        this.films = films;
    }

    public Genre(int id, String genre) {
        this.id = id;
        this.titre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", films=" + films +
                '}';
    }
}
