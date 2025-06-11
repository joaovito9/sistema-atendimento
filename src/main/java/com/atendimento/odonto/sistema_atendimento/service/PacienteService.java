package com.atendimento.odonto.sistema_atendimento.service;

import com.atendimento.odonto.sistema_atendimento.dto.pacienteDTO.EditarPacienteDTO;
import com.atendimento.odonto.sistema_atendimento.entity.Atendimento;
import com.atendimento.odonto.sistema_atendimento.entity.Paciente;
import com.atendimento.odonto.sistema_atendimento.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public Paciente cadastroPaciente(Paciente  paciente) {
            return pacienteRepository.save(paciente);
    }

    public Paciente editarPaciente(Long id, EditarPacienteDTO pacienteDTO) {
        Optional<Paciente> pacienteExistente = pacienteRepository.findById(id);

        if (pacienteExistente.isPresent()) {
            Paciente paciente = pacienteExistente.get();
            paciente.setNome(pacienteDTO.getNome());
            paciente.setDataNascimento(pacienteDTO.getDataNascimento());
            paciente.setProfissao(pacienteDTO.getProfissao());
            paciente.setRua(pacienteDTO.getRua());
            paciente.setNumero(pacienteDTO.getNumero());
            paciente.setBairro(pacienteDTO.getBairro());
            paciente.setCidade(pacienteDTO.getCidade());
            paciente.setEstado(pacienteDTO.getEstado());
            paciente.setCep(pacienteDTO.getCep());
            paciente.setComplemento(pacienteDTO.getComplemento());
            paciente.setCpf(pacienteDTO.getCpf());
            paciente.setTelefone(pacienteDTO.getTelefone());
            paciente.setEmail(pacienteDTO.getEmail());
            paciente.setSexo(pacienteDTO.getSexo());

            return pacienteRepository.save(paciente);
        }

        return null;
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
