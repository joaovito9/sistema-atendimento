package com.atendimento.odonto.sistema_atendimento.repository;

import com.atendimento.odonto.sistema_atendimento.entity.Atendimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtendimentoRepository extends JpaRepository<Atendimento, Long> {
}
