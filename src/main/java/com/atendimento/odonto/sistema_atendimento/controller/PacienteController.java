package com.atendimento.odonto.sistema_atendimento.controller;

import com.atendimento.odonto.sistema_atendimento.model.Paciente;
import com.atendimento.odonto.sistema_atendimento.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    // Lista todos os pacientes
    @GetMapping
    public String listarTodosPacientes(Model model) {
        model.addAttribute("pacientes", pacienteService.listarTodosPacientes());
        return "paciente/lista"; // /templates/paciente/lista.html
    }

    // Formulário para novo paciente
    @GetMapping("/novoPaciente")
    public String novoPaciente(Model model) {
        model.addAttribute("paciente", new Paciente());
        return "paciente/form"; // /templates/paciente/form.html
    }

    // Salvar novo ou atualizado
    @PostMapping("/salvarPaciente")
    public String salvarPaciente(@ModelAttribute Paciente paciente) {
        pacienteService.salvarPaciente(paciente);
        return "redirect:/pacientes";
    }

    // Editar paciente existente
    @GetMapping("/editarPaciente/{id}")
    public String editarPaciente(@PathVariable Long id, Model model) {
        Paciente paciente = pacienteService.buscarPacientePorId(id).orElseThrow(()
                -> new IllegalArgumentException("Paciente não encontrado: " + id));
        model.addAttribute("paciente", paciente);
        return "paciente/form";
    }

    // Excluir paciente
    @GetMapping("/excluirPaciente/{id}")
    public String excluirPaciente(@PathVariable Long id) {
        pacienteService.excluirPaciente(id);
        return "redirect:/pacientes";
    }
}
