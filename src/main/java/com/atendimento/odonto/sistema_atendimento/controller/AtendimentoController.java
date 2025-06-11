package com.atendimento.odonto.sistema_atendimento.controller;

import com.atendimento.odonto.sistema_atendimento.dto.atendimento.CriarAtendimentoDTO;
import com.atendimento.odonto.sistema_atendimento.dto.atendimento.EditarAtendimentoDTO;
import com.atendimento.odonto.sistema_atendimento.entity.Atendimento;
import com.atendimento.odonto.sistema_atendimento.entity.Paciente;
import com.atendimento.odonto.sistema_atendimento.service.AtendimentoService;
import com.atendimento.odonto.sistema_atendimento.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/atendimentos")
public class AtendimentoController {
    @Autowired
    private AtendimentoService atendimentoService;

    @Autowired
    private PacienteService pacienteService;

    @PostMapping("/cadastrarAtendimento")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Atendimento> cadastrarAtendimento(@RequestBody @Valid CriarAtendimentoDTO atendimentoDTO) {
        Atendimento atendimentoSalvo = atendimentoService.cadastrarAtendimento(atendimentoDTO);

        return atendimentoSalvo != null
                ? ResponseEntity.ok(atendimentoSalvo) : ResponseEntity.badRequest().build();
    }

    @PutMapping("/editarAtendimento/{id}")
    public ResponseEntity<Atendimento> editarAtendimento(@PathVariable Long id, @RequestBody EditarAtendimentoDTO atendimentoDTO) {
        Atendimento atendimentoEditado = atendimentoService.editarAtendimento(id, atendimentoDTO);

        return atendimentoEditado != null
                ? ResponseEntity.ok(atendimentoEditado) : ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/excluirAtendimento/{id}")
    public ResponseEntity<String> excluirAtendimento(@PathVariable Long id) {
        atendimentoService.excluirAtendimento(id);
        return ResponseEntity.ok("Atendimento excluído com sucesso");
    }

    @GetMapping("/listarAtendimentos")
    public ResponseEntity<Iterable<Atendimento>> listarAtendimentos() {
        return ResponseEntity.ok(atendimentoService.listarTodosAtendimentos());
    }

}
