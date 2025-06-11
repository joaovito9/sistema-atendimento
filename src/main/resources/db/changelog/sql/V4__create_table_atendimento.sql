CREATE TABLE atendimento (
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    procedimento VARCHAR(255) NOT NULL,
    observacoes VARCHAR(255),
    valor_pago NUMERIC(10,2) NOT NULL CHECK (valor_pago >= 0),
    data_hora TIMESTAMP NOT NULL,
    paciente_id BIGINT REFERENCES paciente(id) ON DELETE CASCADE,
    confirmado BOOLEAN DEFAULT FALSE,
    forma_pagamento VARCHAR(255)
);
