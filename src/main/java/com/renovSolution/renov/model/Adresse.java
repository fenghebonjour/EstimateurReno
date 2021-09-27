package com.renovSolution.renov.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name="Adresse")
@Table(name="adresse")
public class Adresse {

    @Id
    @SequenceGenerator(
            name="adresse_sequence",
            sequenceName = "adresse_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "adresse_sequence"
    )

    @Column(
            name="adresse_id",
            nullable = false,
            updatable = false
    )
    private Long id;
    @Column(
            name="numero_civ",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String numeroCiv;
    @Column(
            name="appartement",
            nullable = true,
            columnDefinition = "TEXT"
    )
    private String appartement;
    @Column(
            name="rue",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String rue;
    @Column(
            name="ville",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String ville;
    @Column(
            name="province",
            nullable = true,
            columnDefinition = "TEXT"
    )
    private String province;
    @Column(
            name="pays",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String pays;
    @Column(
            name="codePostal",
            nullable = true,
            columnDefinition = "TEXT"
    )
    private String codePostal;


    @OneToMany(
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE},
            mappedBy = "adresse"
    )
    @JsonManagedReference
    private List<AdresseUtilisateur> adressesUtilisateurs = new ArrayList<>();

    public Adresse() {
    }

    public Adresse(String numeroCiv, String appartement, String rue, String ville,
                   String province, String pays, String codePostal) {
        this.numeroCiv = numeroCiv;
        this.appartement = appartement;
        this.rue = rue;
        this.ville = ville;
        this.province = province;
        this.pays = pays;
        this.codePostal = codePostal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroCiv() {
        return numeroCiv;
    }

    public void setNumeroCiv(String numeroCiv) {
        this.numeroCiv = numeroCiv;
    }

    public String getAppartement() {
        return appartement;
    }

    public void setAppartement(String appartement) {
        this.appartement = appartement;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public List<AdresseUtilisateur> getAdressesUtilisateurs() {
        return adressesUtilisateurs;
    }

    public void addAdresseToUtilisateur(AdresseUtilisateur adresseUtilisateur){
        if(!adressesUtilisateurs.contains(adresseUtilisateur)){
            adressesUtilisateurs.add(adresseUtilisateur);
        }
    }

    public void removeAdresseToUtilisateur(AdresseUtilisateur adresseUtilisateur){
        if(adressesUtilisateurs.contains(adresseUtilisateur)){
            adressesUtilisateurs.remove(adresseUtilisateur);
        }
    }

    @Override
    public String toString() {
        return "Adresse{" +
                "id=" + id +
                ", numeroCiv='" + numeroCiv + '\'' +
                ", appartement='" + appartement + '\'' +
                ", rue='" + rue + '\'' +
                ", ville='" + ville + '\'' +
                ", province='" + province + '\'' +
                ", pays='" + pays + '\'' +
                ", codePostal='" + codePostal + '\'' +
                '}';
    }
}
