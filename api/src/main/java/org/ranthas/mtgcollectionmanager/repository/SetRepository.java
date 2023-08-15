package org.ranthas.mtgcollectionmanager.repository;

import org.ranthas.mtgcollectionmanager.entity.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface SetRepository extends JpaRepository<Set, UUID> {
    
    @Query("from Set where code = ?1")
    Set findByCode(String code);
}
