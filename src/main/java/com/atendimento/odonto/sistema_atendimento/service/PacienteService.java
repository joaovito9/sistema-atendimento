package com.atendimento.odonto.sistema_atendimento.service;

import com.atendimento.odonto.sistema_atendimento.entity.Atendimento;
import com.atendimento.odonto.sistema_atendimento.entity.Paciente;
import com.atendimento.odonto.sistema_atendimento.exception.PacienteException;
import com.atendimento.odonto.sistema_atendimento.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public Paciente cadastrarEditarPaciente(Paciente  paciente) throws PacienteException {
        if (paciente.getCpf() == null || paciente.getCpf().isEmpty()) {
            throw new PacienteException("CPF não pode ser nulo");
        }

        Paciente procurarPaciente = pacienteRepository.findByCpf(paciente.getCpf());

        if (procurarPaciente != null) {
            throw new PacienteException("Já existe um paciente com esse CPF");
        }

        return pacienteRepository.save(paciente);
    }

    public List<Paciente> listarTodosPacientes() {
        return pacienteRepository.findAll();
    }

    public Optional<Paciente> buscarPacientePorId(Long id) {
        return pacienteRepository.findById(id);
    }

    public List<Atendimento> buscarAtendimentoPorPacienteId(Long pacienteId) {
        Optional<Paciente> paciente = pacienteRepository.findById(pacienteId);

        return paciente.map(Paciente::getAtendimentos).orElse(null);

    }

    public void excluirPaciente(Long id) {
        pacienteRepository.deleteById(id);
    }
}
