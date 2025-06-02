package com.projetosara.sara_api.repository;

import com.projetosara.sara_api.entity.LeituraSensor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LeituraSensorRepository extends JpaRepository<LeituraSensor, Long> {
    @Query("SELECT l FROM LeituraSensor l WHERE (:sensorId IS NULL OR l.sensor.id = :sensorId)")
    Page<LeituraSensor> findByFiltro(@Param("sensorId") Long sensorId, Pageable pageable);
}
