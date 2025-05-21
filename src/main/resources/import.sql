
INSERT INTO cliente (nome, cpf, telefone, ativo ,plano) VALUES ( 'Ana Silva', '12345678901', '11999999999', 1,'MINHA_MOTTU');
INSERT INTO cliente (nome, cpf, telefone, ativo ,plano) VALUES ( 'João Souza', '98765432100', '11888888888', 0, 'ILIMITADO');
INSERT INTO cliente (nome, cpf, telefone, ativo ,plano) VALUES ( 'Carlos Pereira', '45678912300', '11777777777', 1,_m'MINHA_MOTTU');
INSERT INTO cliente (nome, cpf, telefone, ativo ,plano) VALUES ( 'Mariana Lima', '32165498700', '11666666666', _m, 'ILIMITADO');
INSERT INTO cliente (nome, cpf, telefone, ativo ,plano) VALUES ( 'Fernanda Costa', '78945612300', '11555555555', 1,_m'MINHA_MOTTU');
INSERT INTO cliente (nome, cpf, telefone, ativo ,plano) VALUES ( 'Paulo Oliveira', '65412378900', '11444444444', _m, 'ILIMITADO');
INSERT INTO cliente (nome, cpf, telefone, ativo ,plano) VALUES ( 'Renata Martins', '98712365400', '11333333333', 1, 'MINHA_MOTTU');

INSERT INTO patio (endereco, qtd_vagas, setor) VALUES ( 'Rua das Motos, 123', 100, 'PENDENCIA');
INSERT INTO patio (endereco, qtd_vagas, setor) VALUES ( 'Avenida das Oficinas, 456', 38, 'SEM_PLACA');
INSERT INTO patio (endereco, qtd_vagas, setor) VALUES ( 'Estrada Nova, 789', 204, 'DANOS_GRAVES');

INSERT INTO vaga (ocupada, setor, id_patio) VALUES ( 1, 'PENDENCIA', 1);
INSERT INTO vaga (ocupada, setor, id_patio) VALUES ( 1, 'REPAROS_SIMPLES', 1);
INSERT INTO vaga (ocupada, setor, id_patio) VALUES ( 1, 'DANOS_GRAVES', 1);
INSERT INTO vaga (ocupada, setor, id_patio) VALUES ( 1, 'MOTOR_DEFEITUOSO', 2);
INSERT INTO vaga (ocupada, setor, id_patio) VALUES ( 1,'MANUTENCAO', 2);
INSERT INTO vaga (ocupada, setor, id_patio) VALUES ( 1, 'DISPONIVEL_ALUGUEL', 2);
INSERT INTO vaga (ocupada, setor, id_patio) VALUES ( 1, 'MINHA_MOTTU', 2);
INSERT INTO vaga (ocupada, setor, id_patio) VALUES ( 1, 'PENDENCIA', 1);
INSERT INTO vaga (ocupada, setor, id_patio) VALUES ( 0, 'PENDENCIA', 1);
INSERT INTO vaga (ocupada, setor, id_patio) VALUES ( 0, 'PENDENCIA', 1);
INSERT INTO vaga (ocupada, setor, id_patio) VALUES ( 0, 'REPAROS_SIMPLES', 1);
INSERT INTO vaga (ocupada, setor, id_patio) VALUES ( 0, 'REPAROS_SIMPLES', 1);
INSERT INTO vaga (ocupada, setor, id_patio) VALUES ( 0, 'REPAROS_SIMPLES', 1);
INSERT INTO vaga (ocupada, setor, id_patio) VALUES ( 0, 'DANOS_GRAVES', 1);
INSERT INTO vaga (ocupada, setor, id_patio) VALUES ( 0, 'DANOS_GRAVES', 1);
INSERT INTO vaga (ocupada, setor, id_patio) VALUES ( 0, 'DANOS_GRAVES', 1);
INSERT INTO vaga (ocupada, setor, id_patio) VALUES ( 0, 'MOTOR_DEFEITUOSO', 2);
INSERT INTO vaga (ocupada, setor, id_patio) VALUES ( 0, 'MOTOR_DEFEITUOSO', 2);
INSERT INTO vaga (ocupada, setor, id_patio) VALUES ( 0, 'MOTOR_DEFEITUOSO', 2);
INSERT INTO vaga (ocupada, setor, id_patio) VALUES ( 0, 'MANUTENCAO', 2);
INSERT INTO vaga (ocupada, setor, id_patio) VALUES (0 'MANUTENCAO', 2);
INSERT INTO vaga (ocupada, setor, id_patio) VALUES (0 'MANUTENCAO', 2);
INSERT INTO vaga (ocupada, setor, id_patio) VALUES ( 0, 'DISPONIVEL_ALUGUEL', 2);
INSERT INTO vaga (ocupada, setor, id_patio) VALUES ( 0, 'DISPONIVEL_ALUGUEL', 2);
INSERT INTO vaga (ocupada, setor, id_patio) VALUES ( 0, 'DISPONIVEL_ALUGUEL', 2);
INSERT INTO vaga (ocupada, setor, id_patio) VALUES ( 0, 'SEM_PLACA', 2);
INSERT INTO vaga (ocupada, setor, id_patio) VALUES ( 0, 'SEM_PLACA', 2);
INSERT INTO vaga (ocupada, setor, id_patio) VALUES ( 0, 'SEM_PLACA', 2);
INSERT INTO vaga (ocupada, setor, id_patio) VALUES ( 0, 'SEM_PLACA', 2);
INSERT INTO vaga (ocupada, setor, id_patio) VALUES (12, 0, 'MINHA_MOTTU', 2);
INSERT INTO vaga (ocupada, setor, id_patio) VALUES ( 0, 'MINHA_MOTTU', 2);
INSERT INTO vaga (ocupada, setor, id_patio) VALUES ( 0, 'MINHA_MOTTU', 2);

INSERT INTO moto (modelo, chassi, placa, historico, id_cliente) VALUES ( 'Mottu_Sport', '2lcEz3b43U1ST0377','2lcEz3b43U1ST0377',  'trocar escapamento', 1);
INSERT INTO moto (modelo, chassi, placa, historico, id_cliente) VALUES ( 'Mottu_E',  'a8xD3u8oiu8s0sc90','a8xD3u8oiu8s0sc90',  'trocar a bateria', 2);
INSERT INTO moto (modelo, chassi, placa, historico, id_cliente) VALUES ( 'Minha_Mottu',  '1CzR5PUlSwftC3834','1CzR5PUlSwftC3834',  'disponivel', 3);
INSERT INTO moto (modelo, chassi, placa, historico, id_cliente) VALUES ( 'Mottu_E', '1ALWx1M9FzlpK3671','1ALWx1M9FzlpK3671',  'furtada', 4);
INSERT INTO moto (modelo, chassi, placa, historico, id_cliente) VALUES ( 'Mottu_Sport',  '5RlnaDEb3S7ee1853','5RlnaDEb3S7ee1853',  'avaria na funilaria', 5);
INSERT INTO moto (modelo, chassi, placa, historico, id_cliente) VALUES ( 'Minha_Mottu', '8CXgAkfuSfSdU4475','8CXgAkfuSfSdU4475',  'trocar rodas', 6);
INSERT INTO moto (modelo, chassi, placa, historico, id_cliente) VALUES ( 'Mottu_E',  '9tFFAzH53jRG96502','9tFFAzH53jRG96502',  'trocar bateria',7);

INSERT INTO registro_check_in_out (entrada_patio, saida_patio, id_vaga, id_moto) VALUES (TO_DATE('2025-05-01', 'YYYY-MM-DD'), NULL, 2, 12);
INSERT INTO registro_check_in_out (entrada_patio, saida_patio, id_vaga, id_moto) VALUES ( TO_DATE('2025-04-02', 'YYYY-MM-DD'),TO_DATE('2025-05-04', 'YYYY-MM-DD'), 3, 14);
INSERT INTO registro_check_in_out (entrada_patio, saida_patio, id_vaga, id_moto) VALUES ( TO_DATE('2025-05-02', 'YYYY-MM-DD'), NULL, 4, 13);
INSERT INTO registro_check_in_out (entrada_patio, saida_patio, id_vaga, id_moto) VALUES ( TO_DATE('2025-04-03', 'YYYY-MM-DD'),TO_DATE('2025-04-28', 'YYYY-MM-DD'), 13, 8);
INSERT INTO registro_check_in_out (entrada_patio, saida_patio, id_vaga, id_moto) VALUES ( TO_DATE('2025-05-03', 'YYYY-MM-DD'), NULL, 5, 26);
INSERT INTO registro_check_in_out (entrada_patio, saida_patio, id_vaga, id_moto) VALUES ( TO_DATE('2025-05-04', 'YYYY-MM-DD'), NULL, 24, 18);
INSERT INTO registro_check_in_out (entrada_patio, saida_patio, id_vaga, id_moto) VALUES ( TO_DATE('2025-05-04', 'YYYY-MM-DD'), NULL, 20, 21);



