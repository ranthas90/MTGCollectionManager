package org.ranthas.mtgcollectionmanager.dto.scryfall;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.ranthas.mtgcollectionmanager.constant.DateTimeConstants;

import java.time.LocalDate;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ScryfallSet {
    
    private String code;
    private String name;

    @JsonProperty("released_at")
    private String releasedAt;

    @JsonProperty("card_count")
    private Integer cardCount;

    private boolean digital;

    @JsonProperty("icon_svg_uri")
    private String iconPath;

    @JsonProperty("set_type")
    private String setType;

    @JsonProperty("nonfoil_only")
    private Boolean nonFoilOnly;

    @JsonProperty("foil_only")
    private Boolean foilOnly;
    
    public ScryfallSet() {
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

    public String getReleasedAt() {
        return releasedAt;
    }

    public void setReleasedAt(String releasedAt) {
        this.releasedAt = releasedAt;
    }

    public Integer getCardCount() {
        return cardCount;
    }

    public void setCardCount(Integer cardCount) {
        this.cardCount = cardCount;
    }

    public boolean isDigital() {
        return digital;
    }

    public void setDigital(boolean digital) {
        this.digital = digital;
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    public String getSetType() {
        return setType;
    }

    public void setSetType(String setType) {
        this.setType = setType;
    }

    public Boolean getNonFoilOnly() {
        return nonFoilOnly;
    }

    public void setNonFoilOnly(Boolean nonFoilOnly) {
        this.nonFoilOnly = nonFoilOnly;
    }

    public Boolean getFoilOnly() {
        return foilOnly;
    }

    public void setFoilOnly(Boolean foilOnly) {
        this.foilOnly = foilOnly;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScryfallSet that = (ScryfallSet) o;
        return Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    public boolean isValid() {
        LocalDate releaseDate = LocalDate.parse(releasedAt, DateTimeConstants.DATE_FORMATTER);
        return cardCount > 0 && !digital && releaseDate.isBefore(LocalDate.now());
    }
}
