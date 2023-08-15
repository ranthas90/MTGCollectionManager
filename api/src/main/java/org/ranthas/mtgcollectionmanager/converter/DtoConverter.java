package org.ranthas.mtgcollectionmanager.converter;

import org.ranthas.mtgcollectionmanager.dto.collection.*;
import org.ranthas.mtgcollectionmanager.entity.Card;
import org.ranthas.mtgcollectionmanager.entity.Set;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class DtoConverter {
    
    private final SymbolConverter symbolConverter;
    private final CardPriceConverter cardPriceConverter;
    private final CreaturePowerConverter creaturePowerConverter;
    private final CardImageConverter cardImageConverter;

    
    public DtoConverter(
        SymbolConverter symbolConverter,
        CardPriceConverter cardPriceConverter,
        CreaturePowerConverter creaturePowerConverter,
        CardImageConverter cardImageConverter
    ) {
        this.symbolConverter = symbolConverter;
        this.cardPriceConverter = cardPriceConverter;
        this.creaturePowerConverter = creaturePowerConverter;
        this.cardImageConverter = cardImageConverter;
    }

    public SetDto convert(Set set) {
        
        String code = set.getCode();
        String name = set.getName();
        String iconUri = set.getIconPath();
        long totalCards = set.getTotalCards();
        long ownedCards = set.getOwnedCards();
        LocalDate releaseDate = set.getReleaseDate();
        String setType = set.getSetType().getCode();

        return new SetDto(code, name, iconUri, totalCards, ownedCards, releaseDate, setType);
    }

    public CardDto convert(Card card) {

        String name = card.getName();
        String slug = card.getSlug();
        String rarity = card.getRarity();
        String type = card.getTypeLine();
        String collectorNumber = card.getCollectorNumber();
        Long numericCollectorNumber = card.getNumericCollectorNumber();
        List<String> manaCost = symbolConverter.convert(card.getManaCost());
        String oracleText = card.getOracleText();
        String flavorText = card.getFlavorText();
        CreaturePower creaturePower = creaturePowerConverter.convert(card);
        CardQuantity quantity = new CardQuantity(card.getNonFoilQuantity(), card.getFoilQuantity());
        CardPrice price = cardPriceConverter.convert(card);
        CardImage image = cardImageConverter.convert(card);

        return new CardDto(
                name,
                slug,
                rarity,
                type,
                collectorNumber,
                numericCollectorNumber,
                manaCost,
                oracleText,
                flavorText,
                creaturePower,
                quantity,
                price,
                image
        );
    }
}
