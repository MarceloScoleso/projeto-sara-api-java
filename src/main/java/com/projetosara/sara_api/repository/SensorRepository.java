package com.projetosara.sara_api.repository;

import com.projetosara.sara_api.entity.Sensor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SensorRepository extends JpaRepository<Sensor, Long> {
    @Query("SELECT s FROM Sensor s WHERE (:localizacaoId IS NULL OR s.localizacao.id = :localizacaoId)")
    Page<Sensor> findByFiltro(@Param("localizacaoId") Long localizacaoId, Pageable pageable);
}   