package com.atendimento.odonto.sistema_atendimento.dto.atendimento;

import com.atendimento.odonto.sistema_atendimento.entity.Enum.FormaPagamento;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class EditarAtendimentoDTO {

    private String procedimento;
    private BigDecimal valorPago;
    private String dataHora;
    private String observacoes;
    private Boolean confirmado;
    private FormaPagamento formaPagamento;

}
