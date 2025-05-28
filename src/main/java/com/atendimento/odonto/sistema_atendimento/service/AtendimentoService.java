package com.atendimento.odonto.sistema_atendimento.service;

import com.atendimento.odonto.sistema_atendimento.model.Atendimento;
import com.atendimento.odonto.sistema_atendimento.repository.AtendimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AtendimentoService {

    @Autowired
    private AtendimentoRepository atendimentoRepository;

    public List<Atendimento> listarTodosAtendimentos() {
        return atendimentoRepository.findAll();
    }

    public Atendimento salvarAtendimento(Atendimento atendimento) {
        return atendimentoRepository.save(atendimento);
    }

    public void excluirAtendimento(Long id) {
        atendimentoRepository.deleteById(id);
    }

    public Optional<Atendimento> buscarAtendimentoPorId(Long id) {
        return atendimentoRepository.findById(id);
    }
    
}
