package com.renovSolution.renov.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity(name="OdsMainOeuvre")
@Table(name="odsMainOeuvre")
public class OdsMainOeuvre {


    @JsonIgnore
    @EmbeddedId
    private OdsMainOeuvreId id;

    @ManyToOne
    @MapsId("offreServiceId")
    @JoinColumn(
            name ="offre_service_id",
            foreignKey = @ForeignKey(
                    name="ods_main_oeuvre_service_fk"
            )
    )
    @JsonBackReference

    private OffreService offreService;

    @ManyToOne
    @MapsId ("mainOeuvreId")
    @JoinColumn(
            name ="main_oeuvre_id",
            foreignKey = @ForeignKey(
                    name="ods_main_oeuvre_main_oeuvre_fk"
            )
    )
    // @JsonBackReference

    private MainOeuvre mainOeuvre ;


    @Column(
            name="quantite",
            nullable = true
    )
    private int quantite;
    @Column(
            name="prix_unitaire",
            nullable = true
    )
    private double prixUnitaire ;

    public OdsMainOeuvre() {
    }

    public OdsMainOeuvre(OdsMainOeuvreId id, OffreService offreService, MainOeuvre mainOeuvre, int quantite, double prixUnitaire) {
        this.id = id;
        this.offreService = offreService;
        this.mainOeuvre = mainOeuvre;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
    }

    public OdsMainOeuvreId getId() {
        return id;
    }

    public void setId(OdsMainOeuvreId id) {
        this.id = id;
    }

    public OffreService getOffreService() {
        return offreService;
    }

    public void setOffreService(OffreService offreService) {
        this.offreService = offreService;
    }

    public MainOeuvre getMainOeuvre() {
        return mainOeuvre;
    }

    public void setMainOeuvre(MainOeuvre mainOeuvre) {
        this.mainOeuvre = mainOeuvre;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }
}
