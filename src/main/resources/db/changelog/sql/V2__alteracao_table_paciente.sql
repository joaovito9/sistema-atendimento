ALTER TABLE paciente
DROP COLUMN IF EXISTS ativo;

ALTER TABLE paciente
ADD COLUMN endereco_complemento VARCHAR(255);
