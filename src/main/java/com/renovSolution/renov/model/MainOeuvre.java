package com.renovSolution.renov.model;


import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name="MainOeuvre")
@Table(name="main_oeuvre")
public class MainOeuvre {

    @Id
    @SequenceGenerator(
            name="main_oeuvre_sequence",
            sequenceName = "main_oeuvre_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "main_oeuvre_sequence"
    )

    @Column(
            name="main_oeuvre_id",
            nullable = false,
            updatable = false
    )
    protected Long id ;
    @Column(
            name="description",
            nullable = false,
    columnDefinition = "TEXT")

    private String description;

    @Column(
            name="grade",
            nullable = true )

    private int grade;

    @Column(
            name="salaire",
            nullable = true
            )
    private double salaire;

    public MainOeuvre() {
    }

    public MainOeuvre(String description, int grade, double salaire) {
        this.description = description;
        this.grade = grade;
        this.salaire = salaire;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    public Long getId() {
        return id;
    }
}
