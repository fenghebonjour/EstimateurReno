package com.renovSolution.renov.model;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity(name="Individus")
@Table(name="individus")

public class Individus extends Contracteur implements Serializable {

    @Column(
            name="nom",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String nom;
    @Column(
            name="prenom",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String Prenom;
    @Column(
            name="certificat",
            nullable = true,
            columnDefinition = "TEXT"
    )
    private String certificat;

    public Individus() {
    }

    public Individus(String username,
                     String password,
                     LocalDate dateInscription,
                     String type,
                     int note,
                     int anneeExperience,
                     String activite,
                     String telephone,
                     String courriel,
                     String nom,
                     String prenom,
                     String certificat) {
        super(username, password, dateInscription, type, note, anneeExperience, activite, telephone, courriel);
        this.nom = nom;
        Prenom = prenom;
        this.certificat = certificat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public String getCertificat() {
        return certificat;
    }

    public void setCertificat(String certificat) {
        this.certificat = certificat;
    }
}
