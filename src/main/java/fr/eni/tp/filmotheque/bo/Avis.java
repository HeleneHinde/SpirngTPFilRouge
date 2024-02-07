package fr.eni.tp.filmotheque.bo;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Avis {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(value = 0, message = "La note doit être au moins 0")
    @Max(value = 5, message = "La note doit être au plus 5")
    private int note;

    @NotBlank(message = "Le commentaire ne doit pas être vide")
    @Size(max = 250, message = "La longueur du commentaire ne doit pas dépasser 250 caractères")
    private String commentaire;

    @ManyToOne(targetEntity = Film.class)
    private Film film;

    @ManyToOne(targetEntity = Membre.class)
    private Membre auteur;


    public Avis() {
    }

    public Avis(Long id, int note, String commentaire, Film film, Membre auteur) {
        this.id = id;
        this.note = note;
        this.commentaire = commentaire;
        this.film = film;
        this.auteur = auteur;
    }

    public Avis(Long id, int note, String commentaire, Membre auteur) {
        this.id = id;
        this.note = note;
        this.commentaire = commentaire;
        this.auteur = auteur;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Membre getAuteur() {
        return auteur;
    }

    public void setAuteur(Membre auteur) {
        this.auteur = auteur;
    }

    @Override
    public String toString() {
        return "Avis{" +
                "id=" + id +
                ", note=" + note +
                ", commentaire='" + commentaire + '\'' +
                ", film=" + film +
                ", auteur=" + auteur +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}
