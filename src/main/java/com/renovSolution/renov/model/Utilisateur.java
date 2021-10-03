package com.renovSolution.renov.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name="Utilisateur")
@Table(name="utilisateur")
@Inheritance (strategy=InheritanceType.JOINED)
public class Utilisateur implements Serializable {
    @Id
    @SequenceGenerator(
            name="utilisateur_sequence",
            sequenceName = "utilisateur_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "utilisateur_sequence"
    )

    @Column(
            name="utilisateur_id",
            nullable = false,
            updatable = false
    )
    protected Long id ;
    @Column(
            name="username",
            nullable = true,
            columnDefinition = "TEXT"
    )
   protected String username;
    @Column(
            name="password",
            nullable = true,
            columnDefinition = "TEXT"
    )
    protected String password;
    @Column(
            name="date_inscription",
            nullable = true,
            columnDefinition = "date"
    )
    protected LocalDate dateInscription ;
    @Column(
            name="type",
            nullable = true,
            columnDefinition = "TEXT"
    )
    protected String type ;


    /*
    @ManyToMany(
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE}
    )

    @JoinTable(
            name="adresse_utilisateur",
            joinColumns = @JoinColumn(
                    name = "utilisateur_id",
                    foreignKey = @ForeignKey(name="utilisateur_id")
            ),
            inverseJoinColumns =@JoinColumn(
                    name = "adresse_id",
            foreignKey = @ForeignKey(name="adresse_id")
    )
    )

    private List<Adresse> adresses = new ArrayList<>();
    */

    @OneToMany(
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            mappedBy = "utilisateur"


    )
    @JsonManagedReference
   // @JsonIgnore
    protected List<AdresseUtilisateur> adressesUtilisateurs = new ArrayList<>();


    public Utilisateur() {
    }

    public Utilisateur(String username, String password, LocalDate dateInscription,
                       String type) {
        this.username = username;
        this.password = password;
        this.dateInscription = dateInscription;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(LocalDate dateInscription) {
        this.dateInscription = dateInscription;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<AdresseUtilisateur> getAdressesUtilisateurs() {
        return adressesUtilisateurs;
    }

    public void addAdresseToUtilisateur(AdresseUtilisateur adresseUtilisateur){
        if(!adressesUtilisateurs.contains(adresseUtilisateur)){
            adressesUtilisateurs.add(adresseUtilisateur);
        }
    }

    public void removeAdresseFromUtilisateur(AdresseUtilisateur adresseUtilisateur){
        if(adressesUtilisateurs.contains(adresseUtilisateur)){
            adressesUtilisateurs.remove(adresseUtilisateur);
        }
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", dateInscription=" + dateInscription +
                ", type='" + type + '\'' +
                '}';
    }
}
