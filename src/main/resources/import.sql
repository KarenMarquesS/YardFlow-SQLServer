
INSERT INTO cliente (id_cliente, nome, cpf, telefone, ativo ,plano) VALUES (1, 'Ana Silva', '12345678901', '11999999999', 1,'MINHA_MOTTU');
INSERT INTO cliente (id_cliente, nome, cpf, telefone, ativo ,plano) VALUES (2, 'João Souza', '98765432100', '11888888888', 0, 'ILIMITADO');
INSERT INTO cliente (id_cliente, nome, cpf, telefone, ativo ,plano) VALUES (3, 'Carlos Pereira', '45678912300', '11777777777', 1,_m'MINHA_MOTTU');
INSERT INTO cliente (id_cliente, nome, cpf, telefone, ativo ,plano) VALUES (4, 'Mariana Lima', '32165498700', '11666666666', _m, 'ILIMITADO');
INSERT INTO cliente (id_cliente, nome, cpf, telefone, ativo ,plano) VALUES (5, 'Fernanda Costa', '78945612300', '11555555555', 1,_m'MINHA_MOTTU');
INSERT INTO cliente (id_cliente, nome, cpf, telefone, ativo ,plano) VALUES (6, 'Paulo Oliveira', '65412378900', '11444444444', _m, 'ILIMITADO');
INSERT INTO cliente (id_cliente, nome, cpf, telefone, ativo ,plano) VALUES (7, 'Renata Martins', '98712365400', '11333333333', 1, 'MINHA_MOTTU');

INSERT INTO patio (id_patio, endereco, qtd_vagas, setor) VALUES (1, 'Rua das Motos, 123', 100, 'pendencia');
INSERT INTO patio (id_patio, endereco, qtd_vagas, setor) VALUES (2, 'Avenida das Oficinas, 456', 38, 'sem_placa');
INSERT INTO patio (id_patio, endereco, qtd_vagas, setor) VALUES (3, 'Estrada Nova, 789', 204, 'danos_graves');

INSERT INTO vaga (id_vaga, ocupada, setor, id_patio) VALUES (67, 1, 'PENDENCIA', 1);
INSERT INTO vaga (id_vaga, ocupada, setor, id_patio) VALUES (76, 1, 'REPAROS_SIMPLES', 1);
INSERT INTO vaga (id_vaga, ocupada, setor, id_patio) VALUES (94, 1, 'DANOS_GRAVES', 1);
INSERT INTO vaga (id_vaga, ocupada, setor, id_patio) VALUES (22, 1, 'MOTOR_DEFEITUOSO', 2);
INSERT INTO vaga (id_vaga, ocupada, setor, id_patio) VALUES (56, 1,'MANUTENCAO', 2);
INSERT INTO vaga (id_vaga, ocupada, setor, id_patio) VALUES (10, 1, 'DISPONIVEL_ALUGUEL', 2);
INSERT INTO vaga (id_vaga, ocupada, setor, id_patio) VALUES (98, 1, 'MINHA_MOTTU', 2);
INSERT INTO vaga (id_vaga, ocupada, setor, id_patio) VALUES (37, 1, 'PENDENCIA', 1);
INSERT INTO vaga (id_vaga, ocupada, setor, id_patio) VALUES (36, 0, 'PENDENCIA', 1);
INSERT INTO vaga (id_vaga, ocupada, setor, id_patio) VALUES (18, 0, 'PENDENCIA', 1);
INSERT INTO vaga (id_vaga, ocupada, setor, id_patio) VALUES (17, 0, 'REPAROS_SIMPLES', 1);
INSERT INTO vaga (id_vaga, ocupada, setor, id_patio) VALUES (61, 0, 'REPAROS_SIMPLES', 1);
INSERT INTO vaga (id_vaga, ocupada, setor, id_patio) VALUES (43, 0, 'REPAROS_SIMPLES', 1);
INSERT INTO vaga (id_vaga, ocupada, setor, id_patio) VALUES (45, 0, 'DANOS_GRAVES', 1);
INSERT INTO vaga (id_vaga, ocupada, setor, id_patio) VALUES (5, 0, 'DANOS_GRAVES', 1);
INSERT INTO vaga (id_vaga, ocupada, setor, id_patio) VALUES (6, 0, 'DANOS_GRAVES', 1);
INSERT INTO vaga (id_vaga, ocupada, setor, id_patio) VALUES (7, 0, 'MOTOR_DEFEITUOSO', 2);
INSERT INTO vaga (id_vaga, ocupada, setor, id_patio) VALUES (8, 0, 'MOTOR_DEFEITUOSO', 2);
INSERT INTO vaga (id_vaga, ocupada, setor, id_patio) VALUES (9, 0, 'MOTOR_DEFEITUOSO', 2);
INSERT INTO vaga (id_vaga, ocupada, setor, id_patio) VALUES (20, 0, 'MANUTENCAO', 2);
INSERT INTO vaga (id_vaga, ocupada, setor, id_patio) VALUES (35,0 'MANUTENCAO', 2);
INSERT INTO vaga (id_vaga, ocupada, setor, id_patio) VALUES (40,0 'MANUTENCAO', 2);
INSERT INTO vaga (id_vaga, ocupada, setor, id_patio) VALUES (2, 0, 'DISPONIVEL_ALUGUEL', 2);
INSERT INTO vaga (id_vaga, ocupada, setor, id_patio) VALUES (3, 0, 'DISPONIVEL_ALUGUEL', 2);
INSERT INTO vaga (id_vaga, ocupada, setor, id_patio) VALUES (4, 0, 'DISPONIVEL_ALUGUEL', 2);
INSERT INTO vaga (id_vaga, ocupada, setor, id_patio) VALUES (1, 0, 'SEM_PLACA', 2);
INSERT INTO vaga (id_vaga, ocupada, setor, id_patio) VALUES (22, 0, 'SEM_PLACA', 2);
INSERT INTO vaga (id_vaga, ocupada, setor, id_patio) VALUES (23, 0, 'SEM_PLACA', 2);
INSERT INTO vaga (id_vaga, ocupada, setor, id_patio) VALUES (24, 0, 'SEM_PLACA', 2);
INSERT INTO vaga (id_vaga, ocupada, setor, id_patio) VALUES (12, 0, 'MINHA_MOTTU', 2);
INSERT INTO vaga (id_vaga, ocupada, setor, id_patio) VALUES (13, 0, 'MINHA_MOTTU', 2);
INSERT INTO vaga (id_vaga, ocupada, setor, id_patio) VALUES (14, 0, 'MINHA_MOTTU', 2);

INSERT INTO moto (id_moto, modelo, chassi, placa, historico, id_cliente) VALUES ('12', 'Mottu_Sport', '2lcEz3b43U1ST0377','2lcEz3b43U1ST0377',  'trocar escapamento', 1);
INSERT INTO moto (id_moto, modelo, chassi, placa, historico, id_cliente) VALUES ('14', 'Mottu_E',  'a8xD3u8oiu8s0sc90','a8xD3u8oiu8s0sc90',  'trocar a bateria', 2);
INSERT INTO moto (id_moto, modelo, chassi, placa, historico, id_cliente) VALUES ('13', 'Minha_Mottu',  '1CzR5PUlSwftC3834','1CzR5PUlSwftC3834',  'disponivel', 3);
INSERT INTO moto (id_moto, modelo, chassi, placa, historico, id_cliente) VALUES ('08', 'Mottu_E', '1ALWx1M9FzlpK3671','1ALWx1M9FzlpK3671',  'furtada', 4);
INSERT INTO moto (id_moto, modelo, chassi, placa, historico, id_cliente) VALUES ('26', 'Mottu_Sport',  '5RlnaDEb3S7ee1853','5RlnaDEb3S7ee1853',  'avaria na funilaria', 5);
INSERT INTO moto (id_moto, modelo, chassi, placa, historico, id_cliente) VALUES ('18', 'Minha_Mottu', '8CXgAkfuSfSdU4475','8CXgAkfuSfSdU4475',  'trocar rodas', 6);
INSERT INTO moto (id_moto, modelo, chassi, placa, historico, id_cliente) VALUES ('21', 'Mottu_E',  '9tFFAzH53jRG96502','9tFFAzH53jRG96502',  'trocar bateria',7);

INSERT INTO registro_check_in_out (id_registro, entrada_patio, saida_patio, id_vaga, id_moto) VALUES (1003, TO_DATE('2025-05-01', 'YYYY-MM-DD'), NULL, 2, 12);
INSERT INTO registro_check_in_out (id_registro, entrada_patio, saida_patio, id_vaga, id_moto) VALUES (1004, TO_DATE('2025-04-02', 'YYYY-MM-DD'),TO_DATE('2025-05-04', 'YYYY-MM-DD'), 3, 14);
INSERT INTO registro_check_in_out (id_registro, entrada_patio, saida_patio, id_vaga, id_moto) VALUES (1005, TO_DATE('2025-05-02', 'YYYY-MM-DD'), NULL, 4, 13);
INSERT INTO registro_check_in_out (id_registro, entrada_patio, saida_patio, id_vaga, id_moto) VALUES (1006, TO_DATE('2025-04-03', 'YYYY-MM-DD'),TO_DATE('2025-04-28', 'YYYY-MM-DD'), 13, 8);
INSERT INTO registro_check_in_out (id_registro, entrada_patio, saida_patio, id_vaga, id_moto) VALUES (1007, TO_DATE('2025-05-03', 'YYYY-MM-DD'), NULL, 5, 26);
INSERT INTO registro_check_in_out (id_registro, entrada_patio, saida_patio, id_vaga, id_moto) VALUES (1008, TO_DATE('2025-05-04', 'YYYY-MM-DD'), NULL, 24, 18);
INSERT INTO registro_check_in_out (id_registro, entrada_patio, saida_patio, id_vaga, id_moto) VALUES (1009, TO_DATE('2025-05-04', 'YYYY-MM-DD'), NULL, 20, 21);



