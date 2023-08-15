package org.ranthas.mtgcollectionmanager.dto.scryfall;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ScryfallCard {
    
    @JsonProperty("cardmarket_id")
    private Integer cardmarketId;

    @JsonProperty("card_faces")
    private List<ScryfallCardFace> cardFaces;

    @JsonProperty("mana_cost")
    private String manaCost;

    private String name;

    @JsonProperty("oracle_text")
    private String oracleText;

    private String power;
    private String toughness;

    @JsonProperty("type_line")
    private String typeLine;

    @JsonProperty("collector_number")
    private String collectorNumber;

    private boolean digital;

    @JsonProperty("flavor_text")
    private String flavorText;

    @JsonProperty("image_uris")
    private ScryfallCardImage cardImages;

    @JsonProperty("prices")
    private ScryfallCardPrice cardPrices;

    private String rarity;

    public ScryfallCard() {
    }

    public Integer getCardmarketId() {
        return cardmarketId;
    }

    public void setCardmarketId(Integer cardmarketId) {
        this.cardmarketId = cardmarketId;
    }

    public List<ScryfallCardFace> getCardFaces() {
        return cardFaces;
    }

    public void setCardFaces(List<ScryfallCardFace> cardFaces) {
        this.cardFaces = cardFaces;
    }

    public String getManaCost() {
        return manaCost;
    }

    public void setManaCost(String manaCost) {
        this.manaCost = manaCost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getTypeLine() {
        return typeLine;
    }

    public void setTypeLine(String typeLine) {
        this.typeLine = typeLine;
    }

    public String getCollectorNumber() {
        return collectorNumber;
    }

    public void setCollectorNumber(String collectorNumber) {
        this.collectorNumber = collectorNumber;
    }

    public boolean isDigital() {
        return digital;
    }

    public void setDigital(boolean digital) {
        this.digital = digital;
    }

    public String getFlavorText() {
        return flavorText;
    }

    public void setFlavorText(String flavorText) {
        this.flavorText = flavorText;
    }

    public ScryfallCardImage getCardImages() {
        return cardImages;
    }

    public void setCardImages(ScryfallCardImage cardImages) {
        this.cardImages = cardImages;
    }

    public ScryfallCardPrice getCardPrices() {
        return cardPrices;
    }

    public void setCardPrices(ScryfallCardPrice cardPrices) {
        this.cardPrices = cardPrices;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }
}
