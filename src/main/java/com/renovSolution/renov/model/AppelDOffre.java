package com.renovSolution.renov.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;


@Entity(name="AppelDOffre")
@Table(name="appel_offre")
public class AppelDOffre implements Serializable {

    @Id
    @SequenceGenerator(
            name="appelDOffre_sequence",
            sequenceName = "appelDOffre_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "appelDOffre_sequence"
    )

    @Column(
            name="appel_offre_id",
            nullable = false,
            updatable = false
    )
    private Long id ;
    @Column(
            name="date_demande",
            nullable = false,
            columnDefinition = "DATE"
    )
    private LocalDate dateDemande;
    @Column(
            name="date_limite",
            nullable = false,
            columnDefinition = "DATE"
    )
    private LocalDate dateLimite;
    @Column(
            name="date_debut_trav",
            nullable = false,
            columnDefinition = "DATE"
    )
    private LocalDate dateDebutTraveaux;
    @Column(
            name="date_fin_trav",
            nullable = false,
            columnDefinition = "DATE"
    )
    private LocalDate dateFinTraveaux;
    @Column(
            name="statut",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String statut ;
    @Column(
            name="type",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String type;
    @ManyToOne
    @JoinColumn(
            name="utilisateur_id",

            referencedColumnName = "utilisateur_id",
            foreignKey = @ForeignKey(
                    name="appel_offre_client_fk"
            )

    )
    @JsonBackReference
 private Client client;

    @OneToMany(
            mappedBy = "appelDOffre",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    @JsonManagedReference
    private List<OffreService> offresService =new ArrayList<>();

    public AppelDOffre() {
    }

    public AppelDOffre(LocalDate dateDemande, LocalDate dateLimite, LocalDate dateDebutTraveaux,
                       LocalDate dateFinTraveaux, String statut, String type) {
        this.dateDemande = dateDemande;
        this.dateLimite = dateLimite;
        this.dateDebutTraveaux = dateDebutTraveaux;
        this.dateFinTraveaux = dateFinTraveaux;
        this.statut = statut;
        this.type = type;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande(LocalDate dateDemande) {
        this.dateDemande = dateDemande;
    }

    public LocalDate getDateLimite() {
        return dateLimite;
    }

    public void setDateLimite(LocalDate dateLimite) {
        this.dateLimite = dateLimite;
    }

    public LocalDate getDateDebutTraveaux() {
        return dateDebutTraveaux;
    }

    public void setDateDebutTraveaux(LocalDate dateDebutTraveaux) {
        this.dateDebutTraveaux = dateDebutTraveaux;
    }

    public LocalDate getDateFinTraveaux() {
        return dateFinTraveaux;
    }

    public void setDateFinTraveaux(LocalDate dateFinTraveaux) {
        this.dateFinTraveaux = dateFinTraveaux;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void addOffreService(OffreService offreService){
        if(!offresService.contains(offreService))
        {
            offresService.add(offreService);
            offreService.setAppelDOffre(this);
        }
    }

  @Override
    public String toString() {
        return "AppelDOffre{" +
                "id=" + id +
                ", dateDemande=" + dateDemande +
                ", dateLimite=" + dateLimite +
                ", dateDebutTraveaux=" + dateDebutTraveaux +
                ", dateFinTraveaux=" + dateFinTraveaux +
                ", statut='" + statut + '\'' +
                ", type='" + type + '\'' +

                '}';
    }


}
