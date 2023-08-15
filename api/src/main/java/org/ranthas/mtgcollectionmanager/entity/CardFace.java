package org.ranthas.mtgcollectionmanager.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "card_faces")
public class CardFace extends BaseEntity {
    
    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;

    @Column(name = "name")
    private String name;

    @Column(name = "mana_cost")
    private String manaCost;

    @Column(name = "type_line")
    private String typeLine;

    @Column(name = "oracle_text")
    private String oracleText;

    @Column(name = "power")
    private String power;

    @Column(name = "toughness")
    private String toughness;

    public CardFace() {
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManaCost() {
        return manaCost;
    }

    public void setManaCost(String manaCost) {
        this.manaCost = manaCost;
    }

    public String getTypeLine() {
        return typeLine;
    }

    public void setTypeLine(String typeLine) {
        this.typeLine = typeLine;
    }

    public String getOracleText() {
        return oracleText;
    }

    public void setOracleText(String oracleText) {
        this.oracleText = oracleText;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getToughness() {
        return toughness;
    }

    public void setToughness(String toughness) {
        this.toughness = toughness;
    }
}
