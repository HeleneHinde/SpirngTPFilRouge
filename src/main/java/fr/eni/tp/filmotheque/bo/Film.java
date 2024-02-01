package fr.eni.tp.filmotheque.bo;


import java.util.ArrayList;
import java.util.List;

public class Film {

    private int id;
    private String titre;
    private int annee;
    private int duree;
    private String synopsis;
    private Genre genres;
    private List<Avis> avisList = new ArrayList<>();
    private Participant realisateur;
    private List<Participant> acteurs = new ArrayList<>();

    public Film() {

    }

    public Film(int id, String titre, int annee, int duree, String synopsis, Genre genres, List<Avis> avisList, Participant realisateur, List<Participant> acteurs) {
        this.id = id;
        this.titre = titre;
        this.annee = annee;
        this.duree = duree;
        this.synopsis = synopsis;
        this.genres = genres;
        this.avisList = avisList;
        this.realisateur = realisateur;
        this.acteurs = acteurs;
    }

    public Film(int id, String titre, int annee, int duree, String synopsis) {
        this.id = id;
        this.titre = titre;
        this.annee = annee;
        this.duree = duree;
        this.synopsis = synopsis;
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

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Genre getGenres() {
        return genres;
    }

    public void setGenre(Genre genres) {
        this.genres = genres;
    }

    public List<Avis> getAvis() {
        return avisList;
    }

    public void setAvisList(List<Avis> avisList) {
        this.avisList = avisList;
    }

    public void addAvis(Avis avis){
        this.avisList.add(avis);
    }

    public Participant getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(Participant realisateur) {
        this.realisateur = realisateur;
    }

    public List<Participant> getActeurs() {
        return acteurs;
    }

    public void setActeurs(List<Participant> acteurs) {
        this.acteurs = acteurs;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id + '\n'+
                "titre='" + titre + '\n' +
/*                "annee=" + annee + '\n'+
                "duree=" + duree + '\n'+*/
                "synopsis='" + synopsis + '\n' +
                "realisateur=" + realisateur + '\n'+
                "acteurs=" + acteurs + '\n'+
                "genres=" + genres + '\n'+
                "avisList=" + avisList + '\n'+
                '}';
    }
}
