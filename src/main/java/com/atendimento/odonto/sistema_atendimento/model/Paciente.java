package com.atendimento.odonto.sistema_atendimento.model;

import com.atendimento.odonto.sistema_atendimento.model.Enum.Sexo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "paciente")
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataNascimento;

    private String endereco;

    private String cpf;

    private String telefone;

    private String email;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    // relacionamento com atendimento
    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    private List<Atendimento> atendimentos;

    // Getters e Setters
}

