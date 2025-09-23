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
     idpatio INT AUTO_INCREMENT PRIMARY KEY,
     name VARCHAR(255),
     qtdvagas INT NOT NULL
);

-- Tabela: tb_yf_moto (sem FK por enquanto)
CREATE TABLE tb_yf_moto (
    idmoto INT AUTO_INCREMENT PRIMARY KEY,
    modelo VARCHAR(50) NOT NULL,
    chassi VARCHAR(100),
    placa VARCHAR(20),
    historico TEXT,
    idyf INT
);

-- Tabela: tb_yf_IoT (sem FK por enquanto)
CREATE TABLE tb_yf_IoT (
   idyf INT AUTO_INCREMENT PRIMARY KEY,
   serial VARCHAR(100) NOT NULL UNIQUE,
   dt_ultimo_acionamento DATE,
   idmoto INT
);

-- Tabela: tb_yf_registro_check_in_out
CREATE TABLE tb_yf_registro_check_in_out (
     idregistro INT AUTO_INCREMENT PRIMARY KEY,
     entradapatio DATE,
     saidapatio DATE,
     periodo INT NOT NULL,
     setor VARCHAR(50) NOT NULL,
     idmoto INT,
     CONSTRAINT fk_registro_moto FOREIGN KEY (idmoto) REFERENCES tb_yf_moto(idmoto)
);
