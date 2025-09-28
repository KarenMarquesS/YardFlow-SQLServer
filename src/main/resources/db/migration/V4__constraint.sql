-- Ajustar relacionamentos entre Moto e Yardflow
-- Adicionar coluna yardflow_idyf na tabela tb_yf_moto
ALTER TABLE tb_yf_moto ADD COLUMN yardflow_idyf BIGINT;

-- Atualizar os registros existentes para fazer a ligação correta
UPDATE tb_yf_moto SET yardflow_idyf = idyf WHERE idyf IS NOT NULL;

-- Remover a coluna idyf antiga
ALTER TABLE tb_yf_moto DROP COLUMN idyf;

-- Adicionar constraint de foreign key
ALTER TABLE tb_yf_moto ADD CONSTRAINT fk_moto_yardflow FOREIGN KEY (yardflow_idyf) REFERENCES tb_yf_IoT(idyf);

