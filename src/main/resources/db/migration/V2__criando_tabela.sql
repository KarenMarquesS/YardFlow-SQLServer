-- Tabela: tb_yf_usuario
CREATE TABLE tb_yf_usuario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    email VARCHAR(255) NOT NULL,
    funcao VARCHAR(50) NOT NULL,
    CONSTRAINT uq_usuario_email UNIQUE (email)
);

-- Tabela: tb_yf_patio
CREATE TABLE tb_yf_patio (
     id_patio INT AUTO_INCREMENT PRIMARY KEY,
     name VARCHAR(255),
     qtd_vagas INT NOT NULL
);

-- Tabela: tb_yf_moto (sem FK por enquanto)
CREATE TABLE tb_yf_moto (
    id_moto INT AUTO_INCREMENT PRIMARY KEY,
    modelo VARCHAR(50) NOT NULL,
    chassi VARCHAR(100),
    placa VARCHAR(20),
    historico TEXT,
    id_yf INT
);

-- Tabela: tb_yf_IoT (sem FK por enquanto)
CREATE TABLE tb_yf_IoT (
   id_yf INT AUTO_INCREMENT PRIMARY KEY,
   serial VARCHAR(100) NOT NULL UNIQUE,
   dt_ultimo_acionamento DATE,
   moto_id INT
);

-- Tabela: tb_yf_registro_check_in_out
CREATE TABLE tb_yf_registro_check_in_out (
     id_registro INT AUTO_INCREMENT PRIMARY KEY,
     entrada_patio DATE,
     saida_patio DATE,
     periodo INT NOT NULL,
     setor VARCHAR(50) NOT NULL,
     id_moto INT,
     CONSTRAINT fk_registro_moto FOREIGN KEY (id_moto) REFERENCES tb_yf_moto(id_moto)
);
