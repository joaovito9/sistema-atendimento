package com.atendimento.odonto.sistema_atendimento.controller;

import com.atendimento.odonto.sistema_atendimento.dto.pacienteDTO.EditarPacienteDTO;
import com.atendimento.odonto.sistema_atendimento.entity.Atendimento;
import com.atendimento.odonto.sistema_atendimento.entity.Paciente;
import com.atendimento.odonto.sistema_atendimento.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @PostMapping("/criarPaciente")
    public ResponseEntity<Paciente> criarPaciente(@Valid @RequestBody Paciente paciente) {

        Paciente pacienteSalvo = pacienteService.cadastroPaciente(paciente);

        return pacienteSalvo != null
                ? ResponseEntity.ok(pacienteSalvo) : ResponseEntity.badRequest().build();
    }

    @PutMapping("/editarPaciente/{id}")
    public ResponseEntity<Paciente> editarPaciente(@PathVariable Long id, @RequestBody EditarPacienteDTO dto) {
        Paciente pacienteEditado = pacienteService.editarPaciente(id, dto);

        return ResponseEntity.ok(pacienteEditado);
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
