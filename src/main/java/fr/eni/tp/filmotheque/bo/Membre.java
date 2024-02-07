package fr.eni.tp.filmotheque.bo;

import net.bytebuddy.implementation.bind.annotation.Default;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Membre extends Personne{

    private String pseudo;
    private String motDePasse;
    @Column(columnDefinition = "boolean default false")
    private boolean admin;

    @OneToMany(targetEntity = Avis.class, mappedBy = "auteur")
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

    public Membre(Long id, String nom, String prenom, String pseudo, String motDePasse ) {
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
