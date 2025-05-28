package com.atendimento.odonto.sistema_atendimento.service;

import com.atendimento.odonto.sistema_atendimento.model.Paciente;
import com.atendimento.odonto.sistema_atendimento.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repository;

    // Listar todos os pacientes
    public List<Paciente> listarTodosPacientes() {
        return repository.findAll();
    }

    // Salvar ou atualizar um paciente
    public Paciente salvarPaciente(Paciente paciente) {
        return repository.save(paciente);
    }

    // Buscar paciente por ID
    public Optional<Paciente> buscarPacientePorId(Long id) {
        return repository.findById(id);
    }

    // Excluir paciente por ID
    public void excluirPaciente(Long id) {
        repository.deleteById(id);
    }
}
