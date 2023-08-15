package org.ranthas.mtgcollectionmanager.repository;

import org.ranthas.mtgcollectionmanager.entity.SetType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface SetTypeRepository extends JpaRepository<SetType, UUID> {

    @Query("from SetType where code = ?1")
    SetType findByCode(String code);
}
