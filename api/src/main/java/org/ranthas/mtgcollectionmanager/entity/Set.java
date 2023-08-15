package org.ranthas.mtgcollectionmanager.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.ranthas.mtgcollectionmanager.constant.DateTimeConstants;

import java.time.LocalDate;

@Entity
@Table(name = "sets")
public class Set extends BaseEntity {

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "release_date")
    @JsonFormat(pattern = DateTimeConstants.DATE_PATTERN)
    private LocalDate releaseDate;

    @Column(name = "total_cards")
    private long totalCards;

    @Column(name = "owned_cards")
    private long ownedCards;

    @Column(name = "icon_path")
    private String iconPath;

    @ManyToOne
    @JoinColumn(name = "set_type_id")
    private SetType setType;
    
    public Set() {
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

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = LocalDate.parse(releaseDate, DateTimeConstants.DATE_FORMATTER);
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    public SetType getSetType() {
        return setType;
    }

    public void setSetType(SetType setType) {
        this.setType = setType;
    }

    public long getTotalCards() {
        return totalCards;
    }

    public void setTotalCards(long totalCards) {
        this.totalCards = totalCards;
    }

    public long getOwnedCards() {
        return ownedCards;
    }

    public void setOwnedCards(long ownedCards) {
        this.ownedCards = ownedCards;
    }
}
