CREATE TABLE if not exists paciente (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    data_nascimento DATE,
    profissao VARCHAR(100),

    endereco_rua VARCHAR(100),
    endereco_numero VARCHAR(20),
    endereco_bairro VARCHAR(100),
    endereco_cidade VARCHAR(100),
    endereco_estado VARCHAR(2),
    endereco_cep VARCHAR(10),

    cpf VARCHAR(14) UNIQUE NOT NULL,
    telefone VARCHAR(20),
    email VARCHAR(100),
    sexo VARCHAR(10),

    ativo BOOLEAN DEFAULT TRUE
);
