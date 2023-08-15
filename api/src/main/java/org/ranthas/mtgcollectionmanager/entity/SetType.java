package org.ranthas.mtgcollectionmanager.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "set_types")
public class SetType extends BaseEntity {

    private String code;
    private String description;

//    CORE("Core", "A yearly Magic core set (Tenth Edition, etc)"),
//    EXPANSION("Expansion", "A rotational expansion set in a block (Zendikar, etc)"),
//    MASTERS("Masters", "A reprint set that contains no new cards (Modern Masters, etc)"),
//    ALCHEMY("Alchemy", "An Arena set designed for Alchemy"),
//    MASTERPIECE("Masterpiece", "Masterpiece Series premium foil cards"),
//    ARSENAL("Arsenal", "A Commander-oriented gift set"),
//    FROM_THE_VAULT("From the vault", "From the Vault gift sets"),
//    SPELLBOOK("Spellbook", "Spellbook series gift sets"),
//    PREMIUM_DECK("Premium deck", "Premium Deck Series decks"),
//    DUEL_DECK("Duel deck", "Duel Decks"),
//    DRAFT_INNOVATION("Draft innovation", "Special draft sets, like Conspiracy and Battlebond"),
//    TREASURE_CHEST("Treasure chest", "Magic Online treasure chest prize sets"),
//    COMMANDER("Commander", "Commander preconstructed decks"),
//    PLANECHASE("Planechase", "Planechase sets"),
//    ARCHENEMY("Archenemy", "Archenemy sets"),
//    VANGUARD("Vanguard", "Vanguard card sets"),
//    FUNNY("Funny", "A funny un-set or set with funny promos (Unglued, Happy Holidays, etc)"),
//    STARTER("Starter", "A starter/introductory set (Portal, etc)"),
//    BOX("Box", "A gift box set"),
//    PROMO("Promo", "A set that contains purely promotional cards"),
//    TOKEN("Token", "A set made up of tokens and emblems."),
//    MEMORABILIA("Memorabilia", "A set made up of gold-bordered, oversize, or trophy cards that are not legal"),
//    MINIGAME("Minigame", "A set that contains minigame card inserts from booster packs");

    public SetType() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
