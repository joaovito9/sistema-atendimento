package com.atendimento.odonto.sistema_atendimento.repository;

import com.atendimento.odonto.sistema_atendimento.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Paciente findByCpf(String cpf);
}
