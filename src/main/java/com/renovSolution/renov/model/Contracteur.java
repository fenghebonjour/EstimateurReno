package com.renovSolution.renov.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity(name="Contracteur")
@Table(name="contracteur")
@Inheritance(strategy= InheritanceType.JOINED)
public class Contracteur extends Utilisateur implements Serializable {

    @Column(
            name="note",
            nullable = false

    )
    private int note;
    @Column(
            name="annee_experience",
            nullable = false

    )
    private int anneeExperience;
    @Column(
            name="activite",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String activite;
    @Column(
            name="telephone",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String telephone;
    @Column(
            name="courriel",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String courriel;


    @OneToMany(
            mappedBy = "contracteur",
            orphanRemoval = true,
            cascade = {CascadeType.ALL},
            fetch = FetchType.LAZY
    )
    @JsonManagedReference(value="offreService-contracteur")
    private List<OffreService> offreServices =new ArrayList<>();




    public Contracteur() {
    }

    public Contracteur(String username, String password, LocalDate dateInscription, String type, int note,
                       int anneeExperience, String activite, String telephone, String courriel) {
        super(username, password, dateInscription, type);
        this.note = note;
        this.anneeExperience = anneeExperience;
        this.activite = activite;
        this.telephone = telephone;
        this.courriel = courriel;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public int getAnneeExperience() {
        return anneeExperience;
    }

    public void setAnneeExperience(int anneeExperience) {
        this.anneeExperience = anneeExperience;
    }

    public String getActivite() {
        return activite;
    }

    public void setActivite(String activite) {
        this.activite = activite;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }


    public void addOffreService(OffreService offreService){
        if(!offreServices.contains(offreService))
        {
            offreServices.add(offreService);
            offreService.setContracteur(this);
        }
    }



}

