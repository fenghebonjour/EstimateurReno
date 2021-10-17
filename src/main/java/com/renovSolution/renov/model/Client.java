package com.renovSolution.renov.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.renovSolution.renov.repo.AppelDOffreRepo;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;


@Entity(name="Client")
@Table(name="client")
public class Client extends Utilisateur implements Serializable {
    @Column(
            name="nom",
            nullable = false,
            columnDefinition = "TEXT"
    )
      private String nom ;
    @Column(
            name="prenom",
            nullable = false,
            columnDefinition = "TEXT"
    )
      private String prenom;
    @Column(
            name="courriel",
            nullable = false,
            columnDefinition = "TEXT"
    )
      private String courriel;
    @Column(
            name="telephone",
            nullable = true,
            columnDefinition = "TEXT"
    )
      private String telephone;
@OneToMany(
        mappedBy = "client",
        orphanRemoval = true,
        cascade = {CascadeType.ALL},
        fetch = FetchType.LAZY
)
@JsonManagedReference(value="client-appelOffre")
    private List<AppelDOffre> appelDOffres =new ArrayList<>();

    public Client() {
    }

    public Client(
                  String username,
                  String password,
                  LocalDate dateInscription,
                  String type,
                  String nom,
                  String prenom,
                  String courriel,
                  String telephone
               ) {
        super(username, password, dateInscription, type);
        this.nom = nom;
        this.prenom = prenom;
        this.courriel = courriel;
        this.telephone = telephone;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public List<AppelDOffre> getAppelDOffres() {
        return appelDOffres;
    }

    public void addAppelDOffre(AppelDOffre appelDOffre){
        if(!appelDOffres.contains(appelDOffre))
        {
            appelDOffres.add(appelDOffre);
            appelDOffre.setClient(this);
        }
  }
    @Override
    public String toString() {
        return "Client{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", courriel='" + courriel + '\'' +
                ", telephone='" + telephone + '\'' +
                ", id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", dateInscription=" + dateInscription +
                ", type='" + type + '\'' +
                ", adressesUtilisateurs=" + adressesUtilisateurs +
                '}';
    }
}
