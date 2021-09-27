package com.renovSolution.renov.model;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity(name="AdresseUtilisateur")
@Table(name ="adresse_utilisateur")

public class AdresseUtilisateur {

    @EmbeddedId
    private AdresseUtilisateurId id;

    @ManyToOne
    @MapsId ("utilisateurId")
    @JoinColumn(
            name ="utilisateur_id",
            foreignKey = @ForeignKey(
                    name="adresseUtilisateur_utilisateur_fk"
            )
    )
    @JsonBackReference
    private Utilisateur utilisateur ;

    @ManyToOne
    @MapsId ("adresseId")
    @JoinColumn(
            name ="adresse_id",
            foreignKey = @ForeignKey(
                    name="adresseUtilisateur_adresse_fk"
            )
    )
    private Adresse adresse ;


    @Column(
            name="type_adresse",
            nullable = false,
            columnDefinition = "TEXT"

    )
    private String typeAdresse;

    public AdresseUtilisateur() {
    }

    public AdresseUtilisateur(AdresseUtilisateurId id, Utilisateur utilisateur, Adresse adresse,String typeAdresse) {
        this.id = id;
        this.utilisateur = utilisateur;
        this.adresse = adresse;
        this.typeAdresse = typeAdresse;
    }

    public String getTypeAdresse() {
        return typeAdresse;
    }

    public void setTypeAdresse(String typeAdresse) {
        this.typeAdresse = typeAdresse;
    }



    public AdresseUtilisateurId getId() {
        return id;
    }

    public void setId(AdresseUtilisateurId id) {
        this.id = id;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "AdresseUtilisateur{" +
                "id=" + id +
                ", utilisateur=" + utilisateur +
                ", adresse=" + adresse +
                ", typeAdresse='" + typeAdresse + '\'' +
                '}';
    }
}
