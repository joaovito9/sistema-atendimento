package com.atendimento.odonto.sistema_atendimento.controller;

import com.atendimento.odonto.sistema_atendimento.model.Atendimento;
import com.atendimento.odonto.sistema_atendimento.service.AtendimentoService;
import com.atendimento.odonto.sistema_atendimento.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/atendimento")
public class AtendimentoController {

    @Autowired
    private AtendimentoService atendimentoService;

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public String listarAtendimentos(Model model) {
        model.addAttribute("atendimentos", atendimentoService.listarTodosAtendimentos());
        return "atendimento/lista";
    }

    @GetMapping("/novoAtendimento")
    public String novoAtendimento(Model model) {
        model.addAttribute("atendimento", new Atendimento());
        model.addAttribute("pacientes", pacienteService.listarTodos());
        return "atendimento/form";
    }

    @PostMapping("/salvarAtendimento")
    public String salvarAtendimento(@ModelAttribute Atendimento atendimento) {
        atendimentoService.salvarAtendimento(atendimento);
        return "redirect:/atendimentos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Atendimento atendimento = atendimentoService.buscarAtendimentoPorId(id).orElseThrow();
        model.addAttribute("atendimento", atendimento);
        model.addAttribute("pacientes", pacienteService.listarTodos());
        return "atendimento/form";
    }

    @GetMapping("/excluirAtendimento/{id}")
    public String excluirAtendimento(@PathVariable Long id) {
        atendimentoService.excluirAtendimento(id);
        return "redirect:/atendimentos";
    }
}
