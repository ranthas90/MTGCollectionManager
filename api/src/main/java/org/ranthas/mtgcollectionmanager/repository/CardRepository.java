package org.ranthas.mtgcollectionmanager.repository;

import org.ranthas.mtgcollectionmanager.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface CardRepository extends JpaRepository<Card, UUID> {
    
    @Query("from Card where mtgSet.code = ?1 order by numericCollectorNumber")
    List<Card> findAllBySetCode(String setCode);

    @Query("from Card where mtgSet.code = ?1 and slug = ?2")
    Card findBySetCodeAndSlug(String setCode, String slug);
}
