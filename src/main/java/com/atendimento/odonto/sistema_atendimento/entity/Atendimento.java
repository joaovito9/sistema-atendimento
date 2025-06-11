package com.atendimento.odonto.sistema_atendimento.entity;

import com.atendimento.odonto.sistema_atendimento.entity.Enum.FormaPagamento;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "atendimento")
@NoArgsConstructor
@AllArgsConstructor
public class Atendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String procedimento;

    @Column(length = 255)
    private String observacoes;

    @NotNull
    @DecimalMin("0.0")
    private BigDecimal valorPago;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    private Boolean confirmado = false;

    @Enumerated(EnumType.STRING)
    private FormaPagamento formaPagamento;

}

