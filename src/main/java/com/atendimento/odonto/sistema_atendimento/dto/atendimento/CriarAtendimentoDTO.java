package com.atendimento.odonto.sistema_atendimento.dto.atendimento;

import com.atendimento.odonto.sistema_atendimento.entity.Enum.FormaPagamento;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CriarAtendimentoDTO(String procedimento,
                                  String observacoes,
                                  BigDecimal valorPago,
                                  LocalDateTime dataHora,
                                  Long pacienteId,
                                  Boolean confirmado,
                                  FormaPagamento formaPagamento) {
}
