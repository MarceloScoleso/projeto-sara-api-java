package com.projetosara.sara_api.repository;

import com.projetosara.sara_api.entity.Alerta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface AlertaRepository extends JpaRepository<Alerta, Long> {

    @Query("SELECT a FROM Alerta a WHERE " +
        "(:titulo IS NULL OR LOWER(a.mensagem) LIKE LOWER(CONCAT('%', :titulo, '%')))")
    Page<Alerta> findByFiltro(@Param("titulo") String titulo, Pageable pageable);

    Page<Alerta> findByNivelAlertaId(Long nivelAlertaId, Pageable pageable);

    @Query("SELECT a FROM Alerta a WHERE a.dataHora BETWEEN :dataInicio AND :dataFim")
    Page<Alerta> findByDataHoraBetween(@Param("dataInicio") LocalDateTime dataInicio,
                                    @Param("dataFim") LocalDateTime dataFim,
                                    Pageable pageable);
}