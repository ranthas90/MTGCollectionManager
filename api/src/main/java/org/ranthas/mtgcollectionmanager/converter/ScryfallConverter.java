package org.ranthas.mtgcollectionmanager.converter;

import org.ranthas.mtgcollectionmanager.dto.scryfall.*;
import org.ranthas.mtgcollectionmanager.entity.*;
import org.ranthas.mtgcollectionmanager.repository.SetTypeRepository;
import org.springframework.stereotype.Component;

@Component
public class ScryfallConverter {

    private final SetTypeRepository setTypeRepository;

    public ScryfallConverter(SetTypeRepository setTypeRepository) {
        this.setTypeRepository = setTypeRepository;
    }

    public Set convert(ScryfallSet scryfallSet) {

        Set set = new Set();
        SetType setType = setTypeRepository.findByCode(scryfallSet.getSetType());

        set.setCode(scryfallSet.getCode());
        set.setName(scryfallSet.getName());
        set.setTotalCards(scryfallSet.getCardCount());
        set.setOwnedCards(0L);
        set.setIconPath(scryfallSet.getIconPath());
        set.setReleaseDate(scryfallSet.getReleasedAt());
        set.setSetType(setType);

        return set;
    }

    public Card convert(ScryfallCard scryfallCard) {

        Card card = new Card();

        card.setCardmarketId(scryfallCard.getCardmarketId());
        card.setName(scryfallCard.getName());
        card.setManaCost(scryfallCard.getManaCost());
        card.setTypeLine(scryfallCard.getTypeLine());
        card.setOracleText(scryfallCard.getOracleText());
        card.setFlavorText(scryfallCard.getFlavorText());
        card.setPower(scryfallCard.getPower());
        card.setToughness(scryfallCard.getToughness());
        card.setRarity(scryfallCard.getRarity());
        card.setCollectorNumber(scryfallCard.getCollectorNumber());

        if (scryfallCard.getCardPrices() != null) {

            ScryfallCardPrice cardPrices = scryfallCard.getCardPrices();
            card.setFoilPrice(cardPrices.getEurFoil());
            card.setNonFoilPrice(cardPrices.getEur());
        }

        if (scryfallCard.getCardImages() != null) {

            ScryfallCardImage cardImages = scryfallCard.getCardImages();

            card.setSmallImage(cardImages.getSmall());
            card.setNormalImage(cardImages.getNormal());
            card.setLargeImage(cardImages.getLarge());
            card.setArtCropImage(cardImages.getArtCrop());
            card.setBorderCropImage(cardImages.getBorderCrop());
        }

        if (card.getCardFaces() != null) {
            for (ScryfallCardFace scryfallCardFace : scryfallCard.getCardFaces()) {

                CardFace cardFace = new CardFace();
                cardFace.setName(scryfallCardFace.getName());
                cardFace.setPower(scryfallCardFace.getPower());
                cardFace.setToughness(scryfallCardFace.getToughness());
                cardFace.setManaCost(scryfallCardFace.getManaCost());
                cardFace.setTypeLine(scryfallCardFace.getTypeLine());

                card.addCardFace(cardFace);
            }
        }

        return card;
    }

    public Symbol convert(ScryfallSymbol scryfallSymbol) {

        Symbol symbol = new Symbol();

        symbol.setCode(scryfallSymbol.getSymbol());
        symbol.setImagePath(scryfallSymbol.getSvgPath());

        return symbol;
    }
}
