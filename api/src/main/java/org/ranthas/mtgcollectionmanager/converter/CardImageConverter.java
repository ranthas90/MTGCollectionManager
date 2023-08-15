package org.ranthas.mtgcollectionmanager.converter;

import org.ranthas.mtgcollectionmanager.dto.collection.CardImage;
import org.ranthas.mtgcollectionmanager.entity.Card;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CardImageConverter implements Converter<Card, CardImage> {

    @Override
    public CardImage convert(Card source) {
        return new CardImage(source.getArtCropImage(), source.getNormalImage());
    }
}
