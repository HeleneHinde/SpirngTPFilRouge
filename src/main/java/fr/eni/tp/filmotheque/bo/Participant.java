package fr.eni.tp.filmotheque.bo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Objects;

@Entity
public class Participant extends Personne{

    @JsonIgnore
    @ManyToMany(targetEntity = Film.class, mappedBy = "acteurs")
    private List<Film> filmsActeur;

    @JsonIgnore
    @OneToMany(targetEntity = Film.class, mappedBy = "realisateur")
    private List<Film> filmReal;

    public Participant() {
        super();
    }

    public Participant(Long id, String nom, String prenom) {
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
                ", id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }

    public String getFullName(){
        return nom + " "+ prenom;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Participant participant = (Participant) obj;
        return Objects.equals(id, participant.id);
    }
}
