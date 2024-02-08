package fr.eni.tp.filmotheque.bo;

import javax.persistence.*;
import java.util.List;

@Entity
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    @OneToMany(targetEntity = Film.class, mappedBy = "genre")
    private List<Film> films;

    public Genre() {
    }

    public Genre(Long id, String titre, List<Film> films) {
        this.id = id;
        this.titre = titre;
        this.films = films;
    }

    public Genre(Long id, String genre) {
        this.id = id;
        this.titre = genre;
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
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
