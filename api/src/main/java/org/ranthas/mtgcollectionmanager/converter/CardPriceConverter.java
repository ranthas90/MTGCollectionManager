package org.ranthas.mtgcollectionmanager.converter;

import org.ranthas.mtgcollectionmanager.dto.collection.CardPrice;
import org.ranthas.mtgcollectionmanager.entity.Card;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CardPriceConverter implements Converter<Card, CardPrice> {

    @Override
    public CardPrice convert(Card source) {
        return new CardPrice(source.getNonFoilPrice(), source.getFoilPrice());
    }
}
