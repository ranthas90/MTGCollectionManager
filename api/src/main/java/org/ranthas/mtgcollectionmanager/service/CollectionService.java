package org.ranthas.mtgcollectionmanager.service;

import org.ranthas.mtgcollectionmanager.entity.Card;
import org.ranthas.mtgcollectionmanager.entity.Set;
import org.ranthas.mtgcollectionmanager.entity.SetStatistics;
import org.ranthas.mtgcollectionmanager.repository.CardRepository;
import org.ranthas.mtgcollectionmanager.repository.SetRepository;
import org.ranthas.mtgcollectionmanager.repository.SetStatisticsRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionService {
    
    private final SetRepository setRepository;
    private final CardRepository cardRepository;
    private final SetStatisticsRepository setStatisticsRepository;

    public CollectionService(
            SetRepository setRepository,
            CardRepository cardRepository,
            SetStatisticsRepository setStatisticsRepository
    ) {
        this.setRepository = setRepository;
        this.cardRepository = cardRepository;
        this.setStatisticsRepository = setStatisticsRepository;
    }
    
    public List<Set> fetchAll() {
        return setRepository.findAll(Sort.by(Direction.DESC, "releaseDate"));
    }

    public Set fetchSetByCode(String code) {
        return setRepository.findByCode(code);
    }

    public List<Card> fetchSetCards(String setCode) {
        return cardRepository.findAllBySetCode(setCode);
    }

    public Card fetchCardBySetAndSlug(String setCode, String slug) {
        return cardRepository.findBySetCodeAndSlug(setCode, slug);
    }

    public Card saveCard(Card card) {
        return cardRepository.save(card);
    }

    public SetStatistics findByCode(String code) {
        return setStatisticsRepository.findByCode(code);
    }
}
