-- Tabela: tb_yf_funcao
CREATE TABLE tb_yf_funcao (
  idfuncao BIGINT IDENTITY(1,1) PRIMARY KEY,
  nome VARCHAR(50) NOT NULL
);

-- Tabela: tb_yf_usuario
CREATE TABLE tb_yf_usuario (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL
    funcao VARCHAR(50) NOT NULL,
    CONSTRAINT uq_usuario_email UNIQUE (email)
);

-- Tabela: tb_yf_patio
CREATE TABLE tb_yf_patio (
    idpatio BIGINT IDENTITY(1,1) PRIMARY KEY,
    name VARCHAR(255),
    qtdvagas BIGINT NOT NULL
);

-- Tabela: tb_yf_moto (sem FK por enquanto)
CREATE TABLE tb_yf_moto (
    idmoto BIGINT IDENTITY(1,1) PRIMARY KEY,
    modelo VARCHAR(50) NOT NULL,
    chassi VARCHAR(100),
    placa VARCHAR(20),
    historico TEXT,
    idyf BIGINT
    );

-- Tabela: tb_yf_IoT (sem FK por enquanto)
CREATE TABLE tb_yf_IoT (
   idyf BIGINT IDENTITY(1,1) PRIMARY KEY,
   serial VARCHAR(100) NOT NULL UNIQUE,
   dtultimoacionamento DATETIME2,
   idmoto BIGINT
);

-- Tabela: tb_yf_registro_check_in_out
CREATE TABLE tb_yf_registro_check_in_out (
    idregistro BIGINT IDENTITY(1,1) PRIMARY KEY,
    entradapatio DATETIME2,
    saidapatio DATETIME2,
    periodo BIGINT NOT NULL,
    setor VARCHAR(50) NOT NULL,
    idmoto BIGINT,
    CONSTRAINT fk_registro_moto FOREIGN KEY (idmoto) REFERENCES tb_yf_moto(idmoto)
);

-- Criar tabela de junção esperada pelo mapeamento @ManyToMany (Usuario <-> Funcao)
CREATE TABLE IF NOT EXISTS usuario_funcao_tab (
  id BIGINT NOT NULL,
  idfuncao BIGINT NOT NULL,
  PRIMARY KEY (id, idfuncao),
    FOREIGN KEY (id) REFERENCES tb_yf_usuario(id),
    FOREIGN KEY (idfuncao) REFERENCES tb_yf_funcao(idfuncao)
);