package com.renovSolution.renov.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


@Entity(name="OdsMateriaux")
@Table(name="odsMateriaux")
public class OdsMateriaux {


    @JsonIgnore
    @EmbeddedId
    private OdsMateriauxId id;


    @ManyToOne
    @MapsId("offreServiceId")
    @JoinColumn(
            name ="offre_service_id",
            foreignKey = @ForeignKey(
                    name="ods_materiaux_offre_service_fk"
            )
    )
    @JsonBackReference(value="offreService-odsMateriaux")

    private OffreService offreService ;

    @ManyToOne
    @MapsId ("materiauxId")
    @JoinColumn(
            name ="materiaux_id",
            foreignKey = @ForeignKey(
                    name="ods_materiaux_materiaux_fk"
            )
    )
    // @JsonBackReference

    private Materiaux materiaux;


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

    public OdsMateriaux() {
    }

    public OdsMateriaux(
                     OdsMateriauxId id,
                        OffreService offreService,
                        Materiaux materiaux,
                         int quantite,
                     double prixUnitaire) {
        this.id = id;
        this.offreService = offreService;
        this.materiaux = materiaux;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
    }

    public OdsMateriauxId getId() {
        return id;
    }

    public void setId(OdsMateriauxId id) {
        this.id = id;
    }

    public OffreService getOffreService() {
        return offreService;
    }

    public void setOffreService(OffreService offreService) {
        this.offreService = offreService;
    }

    public Materiaux getMateriaux() {
        return materiaux;
    }

    public void setMateriaux(Materiaux materiaux) {
        this.materiaux = materiaux;
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
