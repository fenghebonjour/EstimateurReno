package com.renovSolution.renov.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


@Entity(name="Entreprise")
@Table(name="entreprise")

public class Entreprise extends Contracteur implements Serializable {


    @Column(
            name="nom",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String nom;

    @Column(
            name="contact",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String contact;

    public Entreprise() {
    }

    public Entreprise(
            String username,
            String password,
            LocalDate dateInscription,
            String type,
            int note,
            int anneeExperience,
            String activite,
            String telephone,
            String courriel,
            String nom,
            String contact
               ) {
        super(username, password, dateInscription, type, note, anneeExperience, activite, telephone, courriel);
        this.nom = nom;
        this.contact = contact;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
