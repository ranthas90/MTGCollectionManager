package org.ranthas.mtgcollectionmanager.entity;

import jakarta.persistence.*;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cards")
public class Card extends BaseEntity {
    
    @Column(name = "cardmarket_id")
    private Integer cardmarketId;

    @Column(name = "name")
    private String name;

    @Column(name = "slug")
    private String slug;

    @Column(name = "mana_cost")
    private String manaCost;

    @Column(name = "type_line")
    private String typeLine;

    @Column(name = "oracle_text")
    private String oracleText;

    @Column(name = "flavor_text")
    private String flavorText;

    @Column(name = "power")
    private String power;

    @Column(name = "toughness")
    private String toughness;

    @Column(name = "rarity")
    private String rarity;

    @Column(name = "collector_number")
    private String collectorNumber;

    @Column(name = "numeric_collector_number")
    private Long numericCollectorNumber;

    @Column(name = "non_foil_quantity")
    private long nonFoilQuantity;

    @Column(name = "foil_quantity")
    private long foilQuantity;

    @ManyToOne
    @JoinColumn(name = "set_id")
    private Set mtgSet;

    @Column(name = "small_image")
    private String smallImage;

    @Column(name = "normal_image")
    private String normalImage;

    @Column(name = "large_image")
    private String largeImage;

    @Column(name = "art_crop_image")
    private String artCropImage;

    @Column(name = "border_crop_image")
    private String borderCropImage;

    @Column(name = "non_foil_price")
    private Double nonFoilPrice;

    @Column(name = "foil_price")
    private Double foilPrice;

    @OneToMany(mappedBy = "card")
    private List<CardFace> cardFaces;

    public Card() {
    }

    public Integer getCardmarketId() {
        return cardmarketId;
    }

    public void setCardmarketId(Integer cardmarketId) {
        this.cardmarketId = cardmarketId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
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

    public String getFlavorText() {
        return flavorText;
    }

    public void setFlavorText(String flavorText) {
        this.flavorText = flavorText;
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

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getCollectorNumber() {
        return collectorNumber;
    }

    public void setCollectorNumber(String collectorNumber) {
        this.collectorNumber = collectorNumber;
    }

    public Long getNumericCollectorNumber() {
        return numericCollectorNumber;
    }

    public void setNumericCollectorNumber(Long numericCollectorNumber) {
        this.numericCollectorNumber = numericCollectorNumber;
        this.createSlug();
    }

    public long getNonFoilQuantity() {
        return nonFoilQuantity;
    }

    public void setNonFoilQuantity(long nonFoilQuantity) {
        this.nonFoilQuantity = nonFoilQuantity;
    }

    public long getFoilQuantity() {
        return foilQuantity;
    }

    public void setFoilQuantity(long foilQuantity) {
        this.foilQuantity = foilQuantity;
    }

    public Set getMtgSet() {
        return mtgSet;
    }

    public void setMtgSet(Set mtgSet) {
        this.mtgSet = mtgSet;
    }

    public String getSmallImage() {
        return smallImage;
    }

    public void setSmallImage(String smallImage) {
        this.smallImage = smallImage;
    }

    public String getNormalImage() {
        return normalImage;
    }

    public void setNormalImage(String normalImage) {
        this.normalImage = normalImage;
    }

    public String getLargeImage() {
        return largeImage;
    }

    public void setLargeImage(String largeImage) {
        this.largeImage = largeImage;
    }

    public String getArtCropImage() {
        return artCropImage;
    }

    public void setArtCropImage(String artCropImage) {
        this.artCropImage = artCropImage;
    }

    public String getBorderCropImage() {
        return borderCropImage;
    }

    public void setBorderCropImage(String borderCropImage) {
        this.borderCropImage = borderCropImage;
    }

    public Double getNonFoilPrice() {
        return nonFoilPrice;
    }

    public void setNonFoilPrice(Double nonFoilPrice) {
        this.nonFoilPrice = nonFoilPrice;
    }

    public void setNonFoilPrice(String nonFoilPrice) {
        this.nonFoilPrice = nonFoilPrice == null ? null : Double.parseDouble(nonFoilPrice);
    }

    public Double getFoilPrice() {
        return foilPrice;
    }

    public void setFoilPrice(Double foilPrice) {
        this.foilPrice = foilPrice;
    }

    public void setFoilPrice(String foilPrice) {
        this.foilPrice = foilPrice == null ? null : Double.parseDouble(foilPrice);
    }

    public List<CardFace> getCardFaces() {
        return cardFaces;
    }

    public void setCardFaces(List<CardFace> cardFaces) {
        this.cardFaces = cardFaces;
    }

    public void addCardFace(CardFace cardFace) {
        if (cardFaces == null) {
            cardFaces = new ArrayList<>();
        }
        cardFaces.add(cardFace);
        cardFace.setCard(this);
    }
    
    public boolean hasCreaturePower() {
        return power != null && toughness != null;
    }

    private void createSlug() {
        Assert.notNull(name, "Card name cannot be null for slug generation");
        Assert.notNull(numericCollectorNumber, "Numeric collector number cannot be null for slug generation");
        slug = name
                .replaceAll(",", "-")
                .replaceAll("//", "-")
                .replaceAll("'", "")
                .replaceAll(" ", "-")
                .replaceAll("--", "-")
                .concat("-")
                .concat(Long.toString(numericCollectorNumber));
    }    
}
