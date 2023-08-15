package org.ranthas.mtgcollectionmanager.converter;

import org.ranthas.mtgcollectionmanager.dto.collection.CreaturePower;
import org.ranthas.mtgcollectionmanager.entity.Card;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CreaturePowerConverter implements Converter<Card, CreaturePower> {

    @Override
    public CreaturePower convert(Card source) {

        if (source.hasCreaturePower()) {
            return new CreaturePower(source.getPower(), source.getToughness());
        } else {
            return null;
        }
    }
}
