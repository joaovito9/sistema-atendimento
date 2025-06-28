package com.atendimento.odonto.sistema_atendimento.service;

import com.atendimento.odonto.sistema_atendimento.entity.Atendimento;
import com.atendimento.odonto.sistema_atendimento.entity.Paciente;
import com.atendimento.odonto.sistema_atendimento.repository.AtendimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AtendimentoService {

    @Autowired
    private AtendimentoRepository atendimentoRepository;

    @Autowired
    private PacienteService pacienteService;

    public Atendimento cadastrarEditarAtendimento(Atendimento atendimento) {

        Optional<Paciente> paciente = pacienteService.buscarPacientePorId(atendimento.getPaciente().getId());

        if (!paciente.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente não encontrado");
        }

        atendimento.setPaciente(paciente.get());

        return atendimentoRepository.save(atendimento);
    }

    public List<Atendimento> listarTodosAtendimentos() {
        return atendimentoRepository.findAll();
    }

    public void excluirAtendimento(Long id) {
        atendimentoRepository.deleteById(id);
    }

    public Optional<Atendimento> buscarAtendimentoPorId(Long id) {
        return atendimentoRepository.findById(id);
    }
    
}
