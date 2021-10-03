package com.renovSolution.renov.model;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OdsMainOeuvreId implements Serializable {

    @Column(
            name ="offre_service_id"
    )

    private Long offreServiceId ;

    @Column(
            name ="main_oeuvre_id"
    )
    private Long mainOeuvreId ;

    public OdsMainOeuvreId() {
    }

    public OdsMainOeuvreId(Long offreServiceId, Long mainOeuvreId) {
        offreServiceId = offreServiceId;
        this.mainOeuvreId = mainOeuvreId;
    }


    public Long getOffreServiceId() {
        return offreServiceId;
    }

    public void setOffreServiceId(Long offreServiceId) {
        offreServiceId = offreServiceId;
    }

    public Long getMainOeuvreId() {
        return mainOeuvreId;
    }

    public void setMainOeuvreId(Long mainOeuvreId) {
        this.mainOeuvreId = mainOeuvreId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OdsMainOeuvreId that = (OdsMainOeuvreId) o;
        return Objects.equals(offreServiceId, that.offreServiceId) && Objects.equals(mainOeuvreId, that.mainOeuvreId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(offreServiceId, mainOeuvreId);
    }
}
