package fr.eni.tp.filmotheque.bo;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private int annee;
    private int duree;
    private String synopsis;
    @ManyToOne(targetEntity = Genre.class)
    private Genre genre;
    @OneToMany(targetEntity = Avis.class, mappedBy = "film", cascade = CascadeType.ALL)
    private List<Avis> avisList = new ArrayList<>();
    @ManyToOne(targetEntity = Participant.class, cascade = CascadeType.PERSIST)
    private Participant realisateur;
    @ManyToMany(targetEntity = Participant.class, cascade = CascadeType.PERSIST)
    private List<Participant> acteurs = new ArrayList<>();

    public Film() {
    }

    public Film(Long id, String titre, int annee, int duree, String synopsis, Genre genres, List<Avis> avisList, Participant realisateur, List<Participant> acteurs) {
        this.id = id;
        this.titre = titre;
        this.annee = annee;
        this.duree = duree;
        this.synopsis = synopsis;
        this.genre = genres;
        this.avisList = avisList;
        this.realisateur = realisateur;
        this.acteurs = acteurs;
    }

    public Film(Long id, String titre, int annee, int duree, String synopsis) {
        this.id = id;
        this.titre = titre;
        this.annee = annee;
        this.duree = duree;
        this.synopsis = synopsis;
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

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genres) {
        this.genre = genres;
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
                "genres=" + genre + '\n'+
                "avisList=" + avisList + '\n'+
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
