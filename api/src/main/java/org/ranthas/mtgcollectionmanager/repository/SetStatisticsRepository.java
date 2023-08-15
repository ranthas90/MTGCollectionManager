package org.ranthas.mtgcollectionmanager.repository;

import org.ranthas.mtgcollectionmanager.entity.SetStatistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SetStatisticsRepository extends JpaRepository<SetStatistics, String> {

    @Query("from SetStatistics where code = ?1")
    SetStatistics findByCode(String code);
}
