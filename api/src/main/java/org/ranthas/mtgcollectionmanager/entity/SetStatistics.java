package org.ranthas.mtgcollectionmanager.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "sets_statistics")
public class SetStatistics {

    @Id
    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "total_non_foil_price")
    private Double totalNonFoilPrice;

    @Column(name = "total_foil_price")
    private Double totalFoilPrice;

    public SetStatistics() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getTotalNonFoilPrice() {
        return totalNonFoilPrice;
    }

    public void setTotalNonFoilPrice(Double totalNonFoilPrice) {
        this.totalNonFoilPrice = totalNonFoilPrice;
    }

    public Double getTotalFoilPrice() {
        return totalFoilPrice;
    }

    public void setTotalFoilPrice(Double totalFoilPrice) {
        this.totalFoilPrice = totalFoilPrice;
    }
}
