package com.renovSolution.renov.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name="Materiaux")
@Table(name="materiaux")
public class Materiaux implements Serializable {

    @Id
    @SequenceGenerator(
            name="materiaux_sequence",
            sequenceName = "materiaux_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "materiaux_sequence"
    )

    @Column(
            name="materiaux_id",
            nullable = false,
            updatable = false
    )
    protected Long id ;
    @Column(
            name="description",
            nullable = true,
            columnDefinition = "TEXT")
    private String description;
    @Column(
            name="prix_unitaire",
            nullable = true
            )
    private double prixUnitaire;


/*
    @OneToMany(
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            mappedBy = "materiaux"


    )
    @JsonManagedReference
    private List<OdsMateriaux> odsMateriauxList = new ArrayList<>();

    */


    public Materiaux() {
    }

    public Materiaux( String description, double prixUnitaire) {

        this.description = description;
        this.prixUnitaire = prixUnitaire;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }
}
