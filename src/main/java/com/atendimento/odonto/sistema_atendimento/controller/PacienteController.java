package com.atendimento.odonto.sistema_atendimento.controller;

import com.atendimento.odonto.sistema_atendimento.entity.Atendimento;
import com.atendimento.odonto.sistema_atendimento.entity.Paciente;
import com.atendimento.odonto.sistema_atendimento.exception.PacienteException;
import com.atendimento.odonto.sistema_atendimento.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @PostMapping("/cadastrarEditarPaciente")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> cadastrarEditarPaciente(@Valid @RequestBody Paciente paciente) {
        try {
            Paciente pacienteSalvo = pacienteService.cadastrarEditarPaciente(paciente);
            return ResponseEntity.ok(pacienteSalvo);
        } catch (PacienteException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/excluirPaciente/{id}")
    public ResponseEntity<String> excluirPaciente(@PathVariable Long id) {
        pacienteService.excluirPaciente(id);
        return ResponseEntity.ok("Paciente excluído com sucesso");
    }

    @GetMapping("/listarTodosPacientes")
    public List<Paciente> listarTodosPacientes() {

        return pacienteService.listarTodosPacientes();
    }

    @GetMapping("/buscarPacientePorId/{id}")
    public ResponseEntity<Paciente> buscarPacientePorId(@PathVariable Long id) {
        Optional<Paciente> paciente = pacienteService.buscarPacientePorId(id);
        return paciente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/buscarAtendimentoPorPacienteId/{id}")
    public ResponseEntity<List<Atendimento>> buscarAtendimentoPorPacienteId(@PathVariable Long id) {
        List<Atendimento> atendimentoPaciente = pacienteService.buscarAtendimentoPorPacienteId(id);
        return ResponseEntity.ok(atendimentoPaciente);
    }
}
