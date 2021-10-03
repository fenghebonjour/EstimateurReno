package com.renovSolution.renov.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name="OffreService")
@Table(name="offre_service")
public class OffreService {

    @Id
    @SequenceGenerator(
            name="offre_service_sequence",
            sequenceName = "offre_service_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "offre_service_sequence"
    )

    @Column(
            name="offre_service_id",
            nullable = false,
            updatable = false
    )
    protected Long id ;
    @Column(
            name="date_offre",
            nullable = true,
            columnDefinition = "date"
    )
    protected LocalDate dateOffre ;
    @Column(
            name="date_valide",
            nullable = true,
            columnDefinition = "date"
    )
    protected LocalDate dateValide ;
    @Column(
            name="statut",
            nullable = true,
            columnDefinition = "TEXT"
    )
    protected String statut ;

    @Column(
            name="montant",
            nullable = true
    )

    private double montant ;

    @ManyToOne
    @JoinColumn(
            name="appel_offre_id",

            referencedColumnName = "appel_offre_id",
            foreignKey = @ForeignKey(
                    name="offre_service_appel_offre_fk"
            )

    )
    @JsonBackReference
    private AppelDOffre appelDOffre;


    @ManyToOne
    @JoinColumn(
            name="utilisateur_id",

            referencedColumnName = "utilisateur_id",
            foreignKey = @ForeignKey(
                    name="offre_service_contracteur_fk"
            )

    )
    @JsonBackReference
    private Contracteur contracteur;


    @OneToMany(
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            mappedBy = "offreService"


    )
    @JsonManagedReference
    // @JsonIgnore
    protected List<OdsMateriaux> odsMateriauxList = new ArrayList<>();

    @OneToMany(
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            mappedBy = "offreService"


    )
    @JsonManagedReference
    // @JsonIgnore
    protected List<OdsMainOeuvre> odsMainOeuvreList = new ArrayList<>();

    public OffreService() {
    }

    public OffreService(LocalDate dateOffre, LocalDate dateValide, String statut, double montant) {
        this.dateOffre = dateOffre;
        this.dateValide = dateValide;
        this.statut = statut;
        this.montant = montant;
    }

    public LocalDate getDateOffre() {
        return dateOffre;
    }

    public void setDateOffre(LocalDate dateOffre) {
        this.dateOffre = dateOffre;
    }

    public LocalDate getDateValide() {
        return dateValide;
    }

    public void setDateValide(LocalDate dateValide) {
        this.dateValide = dateValide;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Long getId() {
        return id;
    }

    public AppelDOffre getAppelDOffre() {
        return appelDOffre;
    }

    public void setAppelDOffre(AppelDOffre appelDOffre) {
        this.appelDOffre = appelDOffre;
    }

    public Contracteur getContracteur() {
        return contracteur;
    }

    public void setContracteur(Contracteur contracteur) {
        this.contracteur = contracteur;
    }


    public void addMateriauToOffreService(OdsMateriaux odsMateriaux){
        if(!odsMateriauxList.contains(odsMateriaux)){
            odsMateriauxList.add(odsMateriaux);
        }
    }
    public void addMainOeuvreToOffreService(OdsMainOeuvre odsMainOeuvre){
        if(!odsMainOeuvreList.contains(odsMainOeuvre)){
            odsMainOeuvreList.add(odsMainOeuvre);
        }
    }

}
