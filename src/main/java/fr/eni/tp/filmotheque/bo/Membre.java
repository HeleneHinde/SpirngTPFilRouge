package fr.eni.tp.filmotheque.bo;

import java.util.List;

public class Membre extends Personne{

    private String pseudo;
    private String motDePasse;
    private boolean admin;
    private List<Avis> avisList;

    public Membre() {
        super();
    }

    public Membre(String pseudo, String motDePasse, boolean admin, List<Avis> avisList) {
        super();
        this.pseudo = pseudo;
        this.motDePasse = motDePasse;
        this.admin = admin = false;
        this.avisList = avisList;
    }

    public Membre(int id, String nom, String prenom, String pseudo, String motDePasse ) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.pseudo = pseudo;
        this.motDePasse = motDePasse;
        this.admin = admin;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public List<Avis> getAvisList() {
        return avisList;
    }

    public void setAvisList(List<Avis> avisList) {
        this.avisList = avisList;
    }

    @Override
    public String toString() {
        return "Membre{" +
                "pseudo='" + pseudo + '\'' +
                ", admin=" + admin +
                ", avisList=" + avisList +
                ", id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }
}