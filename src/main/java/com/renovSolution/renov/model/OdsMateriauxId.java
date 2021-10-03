package com.renovSolution.renov.model;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OdsMateriauxId implements Serializable {


    @Column(
            name ="offre_service_id"
    )

    private Long offreServiceId ;

    @Column(
            name ="materiaux_id"
    )
    private Long materiauxId ;

    public OdsMateriauxId() {
    }

    public OdsMateriauxId(Long offreServiceId, Long materiauxId) {
        offreServiceId = offreServiceId;
        this.materiauxId = materiauxId;
    }

    public Long getOffreServiceId() {
        return offreServiceId;
    }

    public void setOffreServiceId(Long offreServiceId) {
        offreServiceId = offreServiceId;
    }

    public Long getMateriauxId() {
        return materiauxId;
    }

    public void setMateriauxId(Long materiauxId) {
        this.materiauxId = materiauxId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OdsMateriauxId that = (OdsMateriauxId) o;
        return Objects.equals(offreServiceId, that.offreServiceId) && Objects.equals(materiauxId, that.materiauxId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(offreServiceId, materiauxId);
    }
}
