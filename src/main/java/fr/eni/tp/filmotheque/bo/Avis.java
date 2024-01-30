package fr.eni.tp.filmotheque.bo;

public class Avis {

    private int id;
    private int note;
    private String commentaire;
    private Film film;
    private Membre auteur;

    public Avis() {
    }

    public Avis(int id, int note, String commentaire, Film film, Membre auteur) {
        this.id = id;
        this.note = note;
        this.commentaire = commentaire;
        this.film = film;
        this.auteur = auteur;
    }

    public Avis(int id, int note, String commentaire, Membre auteur) {
        this.id = id;
        this.note = note;
        this.commentaire = commentaire;
        this.auteur = auteur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
