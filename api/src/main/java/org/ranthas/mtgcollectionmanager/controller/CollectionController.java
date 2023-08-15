package org.ranthas.mtgcollectionmanager.controller;

import org.ranthas.mtgcollectionmanager.constant.Endpoints;
import org.ranthas.mtgcollectionmanager.converter.DtoConverter;
import org.ranthas.mtgcollectionmanager.dto.collection.CardDto;
import org.ranthas.mtgcollectionmanager.dto.collection.CardQuantity;
import org.ranthas.mtgcollectionmanager.dto.collection.SetDto;
import org.ranthas.mtgcollectionmanager.entity.Card;
import org.ranthas.mtgcollectionmanager.entity.Set;
import org.ranthas.mtgcollectionmanager.entity.SetStatistics;
import org.ranthas.mtgcollectionmanager.service.CollectionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
public class CollectionController {
    
    private final CollectionService collectionService;
    private final DtoConverter dtoConverter;

    public CollectionController(CollectionService collectionService, DtoConverter dtoConverter) {
        this.collectionService = collectionService;
        this.dtoConverter = dtoConverter;
    }
    
    @GetMapping(Endpoints.SETS)
    public List<SetDto> findSets() {
        return collectionService
                .fetchAll()
                .stream()
                .map(dtoConverter::convert)
                .collect(Collectors.toList());
    }

    @GetMapping(Endpoints.SET_BY_CODE)
    public SetDto findSetByCode(@PathVariable String code) {
        Set set = collectionService.fetchSetByCode(code);
        return dtoConverter.convert(set);
    }

    @GetMapping(Endpoints.SET_CARDS)
    public List<CardDto> findCardsInSet(@PathVariable String code) {
        return collectionService
                .fetchSetCards(code)
                .stream()
                .map(dtoConverter::convert)
                .collect(Collectors.toList());
    }

    @GetMapping(Endpoints.SET_CARD)
    public CardDto findCard(@PathVariable String code, @PathVariable String slug) {
        Card card = collectionService.fetchCardBySetAndSlug(code, slug);
        return dtoConverter.convert(card);
    }

    @PutMapping(Endpoints.SET_CARD)
    public CardDto updateQuantity(
            @PathVariable String code,
            @PathVariable String slug,
            @RequestBody CardQuantity request
    ) {
        Card card = collectionService.fetchCardBySetAndSlug(code, slug);
        card.setNonFoilQuantity(request.nonFoil());
        card.setFoilQuantity(request.foil());

        Card savedCard = collectionService.saveCard(card);
        return dtoConverter.convert(savedCard);
    }

    @GetMapping(Endpoints.SET_STATS)
    public SetStatistics findSetStatistics(@PathVariable String code) {
        return collectionService.findByCode(code);
    }
}
