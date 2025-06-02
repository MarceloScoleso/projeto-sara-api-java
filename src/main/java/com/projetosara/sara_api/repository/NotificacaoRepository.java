package com.projetosara.sara_api.repository;

import com.projetosara.sara_api.entity.Notificacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface NotificacaoRepository extends JpaRepository<Notificacao, Long> {
    @Query("SELECT n FROM Notificacao n WHERE (:usuarioId IS NULL OR n.usuario.id = :usuarioId)")
    Page<Notificacao> findByFiltro(@Param("usuarioId") Long usuarioId, Pageable pageable);
}
