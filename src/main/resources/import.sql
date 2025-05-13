-- Cliente
INSERT INTO clienteMottu (idCliente, nome, cpf, telefone, plano)
    VALUES (1, 'Ana Silva', '12345678901', '11999999999', 'MINHA_MOTTU');

INSERT INTO clienteMottu (idCliente, nome, cpf, telefone, plano)
    VALUES (2, 'João Souza', '98765432100', '11888888888', 'ILIMITADO');

INSERT INTO clienteMottu (idCliente, nome, cpf, telefone, plano)
    VALUES (3, 'Carlos Pereira', '45678912300', '11777777777', 'MINHA_MOTTU');

INSERT INTO clienteMottu (idCliente, nome, cpf, telefone, plano)
    VALUES (4, 'Mariana Lima', '32165498700', '11666666666', 'ILIMITADO');

INSERT INTO clienteMottu (idCliente, nome, cpf, telefone, plano)
    VALUES (5, 'Fernanda Costa', '78945612300', '11555555555', 'MINHA_MOTTU');

INSERT INTO clienteMottu (idCliente, nome, cpf, telefone, plano)
    VALUES (6, 'Paulo Oliveira', '65412378900', '11444444444', 'ILIMITADO');

INSERT INTO clienteMottu (idCliente, nome, cpf, telefone, plano)
    VALUES (7, 'Renata Martins', '98712365400', '11333333333', 'MINHA_MOTTU');


-- Moto
INSERT INTO moto (idMoto, modelo, ano_fabricacao, chassi, nMotor, placa, historico, idCliente)
    VALUES ('12', 'Mottu_Sport', '2023', '2lcEz3b43U1ST0377',
            '2lcEz3b43U1ST0377', 'HUT472', 'trocar escapamento', 1);

INSERT INTO moto (idMoto, modelo, ano_fabricacao, chassi, nMotor, placa, historico, idCliente)
    VALUES ('14', 'Mottu_E', '2020', 'a8xD3u8oiu8s0sc90',
            'a8xD3u8oiu8s0sc90', 'HQG328', 'trocar a bateria', 2);

INSERT INTO moto (idMoto, modelo, ano_fabricacao, chassi, nMotor, placa, historico, idCliente)
    VALUES ('13', 'Minha_Mottu', '2025', '1CzR5PUlSwftC3834',
            '1CzR5PUlSwftC3834', 'LVY209', 'disponivel', 3);

INSERT INTO moto (idMoto, modelo, ano_fabricacao, chassi, nMotor, placa, historico, idCliente)
    VALUES ('08', 'Mottu_E', '2025', '1ALWx1M9FzlpK3671',
            '1ALWx1M9FzlpK3671', 'MXD047', 'furtada', 4);

INSERT INTO moto (idMoto, modelo, ano_fabricacao, chassi, nMotor, placa, historico, idCliente)
    VALUES ('26', 'Mottu_Sport', '2022', '5RlnaDEb3S7ee1853',
            '5RlnaDEb3S7ee1853', 'KLU727', 'avaria na funilaria', 5);

INSERT INTO moto (idMoto, modelo, ano_fabricacao, chassi, nMotor, placa, historico, idCliente)
    VALUES ('18', 'Minha_Mottu', '2024', '8CXgAkfuSfSdU4475',
            '8CXgAkfuSfSdU4475', 'NEK079', 'trocar rodas', 6);

INSERT INTO moto (idMoto, modelo, ano_fabricacao, chassi, nMotor, placa, historico, idCliente)
    VALUES ('21', 'Mottu_E', '2025', '9tFFAzH53jRG96502',
            '9tFFAzH53jRG96502', 'NCW246', 'trocar bateria',7);

-- Vaga
INSERT INTO vaga (idVaga, ocupada, setor, idPatio)
    VALUES ('1-P', 'S', 'PENDENCIA', 1);

INSERT INTO vaga (idVaga, ocupada, setor, idPatio)
    VALUES ('1-R', 'S', 'REPAROS_SIMPLES', 1);

INSERT INTO vaga (idVaga, ocupada, setor, idPatio)
    VALUES ('1-D', 'S', 'DANOS_GRAVES', 1);

INSERT INTO vaga (idVaga, ocupada, setor, idPatio)
    VALUES ('1-M', 'S', 'MOTOR_DEFEITUOSO', 2);

INSERT INTO vaga (idVaga, ocupada, setor, idPatio)
    VALUES ('1-N', 'S', 'MANUTENCAO', 2);

INSERT INTO vaga (idVaga, ocupada, setor, idPatio)
    VALUES ('1-A', 'S', 'DISPONIVEL_ALUGUEL', 2);

INSERT INTO vaga (idVaga, ocupada, setor, idPatio)
    VALUES ('1-T', 'S', 'MINHA_MOTTU', 2);

INSERT INTO vaga (idVaga, ocupada, setor, idPatio) VALUES ('2-P', 'N', 'PENDENCIA', 1);

INSERT INTO vaga (idVaga, ocupada, setor, idPatio) VALUES ('3-P', 'N', 'PENDENCIA', 1);

INSERT INTO vaga (idVaga, ocupada, setor, idPatio) VALUES ('4-P', 'N', 'PENDENCIA', 1);

INSERT INTO vaga (idVaga, ocupada, setor, idPatio) VALUES ('2-R', 'N', 'REPAROS_SIMPLES', 1);

INSERT INTO vaga (idVaga, ocupada, setor, idPatio) VALUES ('3-R', 'N', 'REPAROS_SIMPLES', 1);

INSERT INTO vaga (idVaga, ocupada, setor, idPatio) VALUES ('4-R', 'N', 'REPAROS_SIMPLES', 1);

INSERT INTO vaga (idVaga, ocupada, setor, idPatio) VALUES ('2-D', 'N', 'DANOS_GRAVES', 1);

INSERT INTO vaga (idVaga, ocupada, setor, idPatio) VALUES ('3-D', 'N', 'DANOS_GRAVES', 1);

INSERT INTO vaga (idVaga, ocupada, setor, idPatio) VALUES ('4-D', 'N', 'DANOS_GRAVES', 1);

INSERT INTO vaga (idVaga, ocupada, setor, idPatio) VALUES ('2-M', 'N', 'MOTOR_DEFEITUOSO', 2);

INSERT INTO vaga (idVaga, ocupada, setor, idPatio) VALUES ('3-M', 'N', 'MOTOR_DEFEITUOSO', 2);

INSERT INTO vaga (idVaga, ocupada, setor, idPatio) VALUES ('4-M', 'N', 'MOTOR_DEFEITUOSO', 2);

INSERT INTO vaga (idVaga, ocupada, setor, idPatio) VALUES ('2-N', 'N', 'MANUTENCAO', 2);

INSERT INTO vaga (idVaga, ocupada, setor, idPatio) VALUES ('3-N', 'N', 'MANUTENCAO', 2);

INSERT INTO vaga (idVaga, ocupada, setor, idPatio) VALUES ('4-N', 'N', 'MANUTENCAO', 2);

INSERT INTO vaga (idVaga, ocupada, setor, idPatio) VALUES ('2-A', 'N', 'DISPONIVEL_ALUGUEL', 2);

INSERT INTO vaga (idVaga, ocupada, setor, idPatio) VALUES ('3-A', 'N', 'DISPONIVEL_ALUGUEL', 2);

INSERT INTO vaga (idVaga, ocupada, setor, idPatio) VALUES ('4-A', 'N', 'DISPONIVEL_ALUGUEL', 2);

INSERT INTO vaga (idVaga, ocupada, setor, idPatio) VALUES ('1-S', 'N', 'SEM_PLACA', 2);

INSERT INTO vaga (idVaga, ocupada, setor, idPatio) VALUES ('2-S', 'N', 'SEM_PLACA', 2);

INSERT INTO vaga (idVaga, ocupada, setor, idPatio) VALUES ('3-S', 'N', 'SEM_PLACA', 2);

INSERT INTO vaga (idVaga, ocupada, setor, idPatio) VALUES ('4-S', 'N', 'SEM_PLACA', 2);

INSERT INTO vaga (idVaga, ocupada, setor, idPatio) VALUES ('2-T', 'N', 'MINHA_MOTTU', 2);

INSERT INTO vaga (idVaga, ocupada, setor, idPatio) VALUES ('3-T', 'N', 'MINHA_MOTTU', 2);

INSERT INTO vaga (idVaga, ocupada, setor, idPatio) VALUES ('4-T', 'N', 'MINHA_MOTTU', 2);

                                            /*
                                            Legenda sobre as Vagas
                                            | idVaga | Setor               | Letra |
                                            | ------ | ------------------- | ----- |
                                            | 1-P    | PENDENCIA           | P     |
                                            | 1-R    | REPAROS\_SIMPLES    | R     |
                                            | 1-D    | DANOS\_GRAVES       | D     |
                                            | 1-M    | MOTOR\_DEFEITUOSO   | M     |
                                            | 1-N    | MANUTENCAO          | N     |
                                            | 1-A    | DISPONIVEL\_ALUGUEL | A     |
                                            | 1-T    | MINHA\_MOTTU        | T     |

                                            */

--Registro CheckIn Out
-- Assumindo pátio 1 e vagas existentes nele.
INSERT INTO registroCheckIn_Out (idRegistro, entrada_patio, saida_patio, idVaga, idMoto)
    VALUES (1003, TO_DATE('2025-05-01', 'YYYY-MM-DD'), NULL, '2-P', 12);

INSERT INTO registroCheckIn_Out (idRegistro, entrada_patio, saida_patio, idVaga, idMoto)
    VALUES (1004, TO_DATE('2025-04-02', 'YYYY-MM-DD'),
            TO_DATE('2025-05-04', 'YYYY-MM-DD'), '3-P', 14);

INSERT INTO registroCheckIn_Out (idRegistro, entrada_patio, saida_patio, idVaga, idMoto)
    VALUES (1005, TO_DATE('2025-05-02', 'YYYY-MM-DD'), NULL, '4-R', 13);

INSERT INTO registroCheckIn_Out (idRegistro, entrada_patio, saida_patio, idVaga, idMoto)
    VALUES (1006, TO_DATE('2025-04-03', 'YYYY-MM-DD'),
            TO_DATE('2025-04-28', 'YYYY-MM-DD'), '3-D', 8);

INSERT INTO registroCheckIn_Out (idRegistro, entrada_patio, saida_patio, idVaga, idMoto)
    VALUES (1007, TO_DATE('2025-05-03', 'YYYY-MM-DD'), NULL, '2-R', 26);

INSERT INTO registroCheckIn_Out (idRegistro, entrada_patio, saida_patio, idVaga, idMoto)
    VALUES (1008, TO_DATE('2025-05-04', 'YYYY-MM-DD'), NULL, '4-D', 18);

INSERT INTO registroCheckIn_Out (idRegistro, entrada_patio, saida_patio, idVaga, idMoto)
    VALUES (1009, TO_DATE('2025-05-04', 'YYYY-MM-DD'), NULL, '2-D', 21);


-- Pátio
INSERT INTO patio (idPatio, endereco, qtdVagas)
    VALUES (1, 'Rua das Motos, 123', 100);

INSERT INTO patio (idPatio, endereco, qtdVagas)
    VALUES (2, 'Avenida das Oficinas, 456', 38);

INSERT INTO patio (idPatio, endereco, qtdVagas)
    VALUES (3, 'Estrada Nova, 789', 204);

