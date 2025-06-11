package com.atendimento.odonto.sistema_atendimento.service;

import com.atendimento.odonto.sistema_atendimento.dto.atendimento.CriarAtendimentoDTO;
import com.atendimento.odonto.sistema_atendimento.dto.atendimento.EditarAtendimentoDTO;
import com.atendimento.odonto.sistema_atendimento.dto.pacienteDTO.EditarPacienteDTO;
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

    public Atendimento cadastrarAtendimento(CriarAtendimentoDTO atendimentoDTO) {

        Paciente paciente = pacienteService.buscarPacientePorId(atendimentoDTO.pacienteId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente não encontrado com o ID: " + atendimentoDTO.pacienteId()));

        Atendimento atendimento = new Atendimento();

        atendimento.setProcedimento(atendimentoDTO.procedimento());
        atendimento.setObservacoes(atendimentoDTO.observacoes());
        atendimento.setValorPago(atendimentoDTO.valorPago());
        atendimento.setDataHora(atendimentoDTO.dataHora());
        atendimento.setPaciente(paciente); // Atribui o objeto Paciente completo encontrado
        atendimento.setConfirmado(atendimentoDTO.confirmado());
        atendimento.setFormaPagamento(atendimentoDTO.formaPagamento());

        return atendimentoRepository.save(atendimento);
    }

    public Atendimento editarAtendimento(Long id, EditarAtendimentoDTO atendimentoDTO) {
        Optional<Atendimento> atendimentoExistente = atendimentoRepository.findById(id);

        if (atendimentoExistente.isPresent()) {
            Atendimento atendimentoEditado = atendimentoExistente.get();
            atendimentoEditado.setProcedimento(atendimentoDTO.getProcedimento());
            atendimentoEditado.setValorPago(atendimentoDTO.getValorPago());
            atendimentoEditado.setObservacoes(atendimentoDTO.getObservacoes());
            atendimentoEditado.setConfirmado(atendimentoDTO.getConfirmado());
            atendimentoEditado.setFormaPagamento(atendimentoDTO.getFormaPagamento());

            return atendimentoRepository.save(atendimentoEditado);

        }

        return null;
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
