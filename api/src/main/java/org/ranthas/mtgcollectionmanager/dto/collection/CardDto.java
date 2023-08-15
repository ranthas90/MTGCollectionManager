package org.ranthas.mtgcollectionmanager.dto.collection;

import java.util.List;

public record CardDto(
        String name,
        String slug,
        String rarity,
        String type,
        String collectorNumber,
        Long numericCollectorNumber,
        List<String> manaCost,
        String oracleText,
        String flavorText,
        CreaturePower creaturePower,
        CardQuantity quantity,
        CardPrice price,
        CardImage image
) {

    // TODO 05/01/2023 Rubén: Objeto para las distantas faces

}
