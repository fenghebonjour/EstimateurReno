package com.renovSolution.renov.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AdresseUtilisateurId implements Serializable {
    @Column(
            name ="utilisateur_id"
    )
    private Long utilisateurId;

    @Column(
            name ="adresse_id"
    )
    private Long adresseId;

    public AdresseUtilisateurId(Long utilisateurId, Long adresseId) {
        this.utilisateurId = utilisateurId;
        this.adresseId = adresseId;
    }

    public AdresseUtilisateurId() {
    }

    public Long getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(Long utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

    public Long getAdresseId() {
        return adresseId;
    }

    public void setAdresseId(Long adresseId) {
        this.adresseId = adresseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdresseUtilisateurId that = (AdresseUtilisateurId) o;
        return Objects.equals(utilisateurId, that.utilisateurId) && Objects.equals(adresseId, that.adresseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(utilisateurId, adresseId);
    }

    @Override
    public String toString() {
        return "AdresseUtilisateurId{" +
                "utilisateurId=" + utilisateurId +
                ", adresseId=" + adresseId +
                '}';
    }
}
