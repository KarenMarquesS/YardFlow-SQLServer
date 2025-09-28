
-- INSERTS PARA BANCO H2

INSERT INTO tb_yf_IoT (serial, dtultimoacionamento, idmoto) VALUES ('SN-ABC10001', DATE '2025-01-10', 1);
INSERT INTO tb_yf_IoT (serial, dtultimoacionamento, idmoto) VALUES ('SN-ABC10002', DATE '2025-02-20', 2);
INSERT INTO tb_yf_IoT (serial, dtultimoacionamento, idmoto) VALUES ('SN-ABC10003', DATE '2025-03-05', 3);
INSERT INTO tb_yf_IoT (serial, dtultimoacionamento, idmoto) VALUES ('SN-ABC10004', DATE '2025-04-18', 4);
INSERT INTO tb_yf_IoT (serial, dtultimoacionamento, idmoto) VALUES ('SN-ABC10005', DATE '2025-05-25', 5);
INSERT INTO tb_yf_IoT (serial, dtultimoacionamento, idmoto) VALUES ('SN-ABC10006', DATE '2025-05-25', 6);
INSERT INTO tb_yf_IoT (serial, dtultimoacionamento, idmoto) VALUES ('SN-ABC10007', DATE '2025-05-25', 7);
INSERT INTO tb_yf_IoT (serial, dtultimoacionamento, idmoto) VALUES ('SN-ABC10008', DATE '2025-05-25', 8);


INSERT INTO tb_yf_patio (name, qtdvagas) VALUES ('Butantã', 100);
INSERT INTO tb_yf_patio (name, qtdvagas) VALUES ('Marília', 38);
INSERT INTO tb_yf_patio (name, qtdvagas) VALUES ('Nova Odessa', 204);


INSERT INTO tb_yf_moto (modelo, chassi, placa, historico, idyf) VALUES ('MOTTU_SPORT', '2lcEz3b43U1ST0377', '2lcEz3b', 'trocar escapamento', 1);
INSERT INTO tb_yf_moto (modelo, chassi, placa, historico, idyf) VALUES ('MOTTU_E', 'a8xD3u8oiu8s0sc90', 'a8xD3u8', 'trocar a bateria', 2);
INSERT INTO tb_yf_moto (modelo, chassi, placa, historico, idyf) VALUES ('MOTTU_POP', '1CzR5PUlSwftC3834', '1CzR5PU', 'disponivel', 3);
INSERT INTO tb_yf_moto (modelo, chassi, placa, historico, idyf) VALUES ('MOTTU_E', '1ALWx1M9FzlpK3671', '1ALWx1M', 'furtada', 4);
INSERT INTO tb_yf_moto (modelo, chassi, placa, historico, idyf) VALUES ('MOTTU_SPORT', '5RlnaDEb3S7ee1853', '5RlnaD8', 'avaria na funilaria', 5);
INSERT INTO tb_yf_moto (modelo, chassi, placa, historico, idyf) VALUES ('MOTTU_POP', '8CXgAkfuSfSdU4475', '8CX7gAk', 'trocar rodas', 6);
INSERT INTO tb_yf_moto (modelo, chassi, placa, historico, idyf) VALUES ('MOTTU_E', '9tFFAzH53jRG96502', '9tFFAzH', 'trocar bateria', 7);


INSERT INTO tb_yf_registro_check_in_out (entradapatio, saidapatio, periodo, setor, idmoto) VALUES (DATE '2025-05-01', DATE '2025-05-08', 7,  'PENDENCIA', 1);
INSERT INTO tb_yf_registro_check_in_out (entradapatio, saidapatio, periodo, setor, idmoto) VALUES (DATE '2025-04-02', DATE '2025-05-04', 2,  'REPAROS_SIMPLES', 2);
INSERT INTO tb_yf_registro_check_in_out (entradapatio, saidapatio, periodo, setor, idmoto) VALUES (DATE '2025-05-02', DATE '2025-07-03', 59, 'MANUTENCAO', 3);
INSERT INTO tb_yf_registro_check_in_out (entradapatio, saidapatio, periodo, setor, idmoto) VALUES (DATE '2025-04-03', DATE '2025-04-28', 25, 'DEFEITO_MOTOR', 4);
INSERT INTO tb_yf_registro_check_in_out (entradapatio, saidapatio, periodo, setor, idmoto) VALUES (DATE '2025-05-03', DATE '2025-08-04', 91, 'DANOS_GRAVES',5);
INSERT INTO tb_yf_registro_check_in_out (entradapatio, saidapatio, periodo, setor, idmoto) VALUES (DATE '2025-05-04', DATE '2025-06-04', 30, 'SEM_PLACA', 6);
INSERT INTO tb_yf_registro_check_in_out (entradapatio, saidapatio, periodo, setor, idmoto) VALUES (DATE '2025-05-04', DATE '2025-06-20', 46, 'DISPONIVEL_ALUGUEL', 7);


INSERT INTO tb_yf_usuario (nome, email, senha, funcao) VALUES ('Ana Souza', 'ana.souza@example.com', 'ADMIN', 'ADMIN');
INSERT INTO tb_yf_usuario (nome, email, senha, funcao) VALUES ('Carlos Oliveira', 'carlos.oliveira@example.com', 'ADMIN','GERENTE_PATIO');
INSERT INTO tb_yf_usuario (nome, email, senha, funcao) VALUES ('Fernanda Lima', 'fernanda.lima@example.com', 'ADMIN','RECEPCAO');
INSERT INTO tb_yf_usuario (nome, email, senha, funcao) VALUES ('João Pereira', 'joao.pereira@example.com', 'ADMIN','MECANICO');
INSERT INTO tb_yf_usuario (nome, email, senha, funcao) VALUES ('Mariana Santos', 'mariana.santos@example.com', 'ADMIN','EXPEDICAO');

insert into tb_yf_funcao (nome) values ('ADMIN');
insert into tb_yf_funcao (nome) values ('GERENTE');

-- Garantir que todas as funções do Enum existam na tabela de função
INSERT INTO tb_yf_funcao (nome)
SELECT 'GERENTE_PATIO' WHERE NOT EXISTS (SELECT 1 FROM tb_yf_funcao WHERE nome = 'GERENTE_PATIO');
INSERT INTO tb_yf_funcao (nome)
SELECT 'RECEPCAO' WHERE NOT EXISTS (SELECT 1 FROM tb_yf_funcao WHERE nome = 'RECEPCAO');
INSERT INTO tb_yf_funcao (nome)
SELECT 'MECANICO' WHERE NOT EXISTS (SELECT 1 FROM tb_yf_funcao WHERE nome = 'MECANICO');
INSERT INTO tb_yf_funcao (nome)
SELECT 'EXPEDICAO' WHERE NOT EXISTS (SELECT 1 FROM tb_yf_funcao WHERE nome = 'EXPEDICAO');
INSERT INTO tb_yf_funcao (nome)
SELECT 'ADMIN' WHERE NOT EXISTS (SELECT 1 FROM tb_yf_funcao WHERE nome = 'ADMIN');

-- Popular a tabela de junção a partir da coluna 'funcao' da tabela de usuários
INSERT INTO usuario_funcao_tab (id, idfuncao)
SELECT u.id, f.idfuncao
FROM tb_yf_usuario u
         JOIN tb_yf_funcao f ON f.nome = u.funcao
WHERE NOT EXISTS (
    SELECT 1 FROM usuario_funcao_tab uf
    WHERE uf.id = u.id AND uf.idfuncao = f.idfuncao
);
