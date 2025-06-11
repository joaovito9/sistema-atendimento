package com.atendimento.odonto.sistema_atendimento.dto.pacienteDTO;

import com.atendimento.odonto.sistema_atendimento.entity.Enum.Sexo;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EditarPacienteDTO {

    private String nome;

    private String telefone;

    private String email;

    private String profissao;

    private LocalDate dataNascimento;

    private String rua;

    private String numero;

    private String bairro;

    private String cidade;

    private String estado;

    private String cep;

    private String complemento;

    private String cpf;

    private Sexo sexo;

    // Evita campos como CPF, atendimentos, etc.
}
