package com.atendimento.odonto.sistema_atendimento.controller;

import com.atendimento.odonto.sistema_atendimento.dto.atendimento.EditarAtendimentoDTO;
import com.atendimento.odonto.sistema_atendimento.entity.Atendimento;
import com.atendimento.odonto.sistema_atendimento.service.AtendimentoService;
import com.atendimento.odonto.sistema_atendimento.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/atendimentos")
public class AtendimentoController {
    @Autowired
    private AtendimentoService atendimentoService;

    @Autowired
    private PacienteService pacienteService;

    @PostMapping("/cadastrarEditarAtendimento")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Atendimento> cadastrarEditarAtendimento(@RequestBody @Valid Atendimento atendimento) {
        Atendimento atendimentoSalvo = atendimentoService.cadastrarEditarAtendimento(atendimento);

        return atendimentoSalvo != null
                ? ResponseEntity.ok(atendimentoSalvo) : ResponseEntity.badRequest().build();
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
