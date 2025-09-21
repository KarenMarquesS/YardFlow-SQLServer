
INSERT INTO tb_yf_IoT (serial, dt_ultimo_acionamento, moto_id) VALUES ('SN-ABC12345', TO_DATE('2025-01-10', 'YYYY-MM-DD'), 1);
INSERT INTO tb_yf_IoT (serial, dt_ultimo_acionamento, moto_id) VALUES ('SN-XYZ98765', TO_DATE('2025-02-20', 'YYYY-MM-DD'), 2);
INSERT INTO tb_yf_IoT (serial, dt_ultimo_acionamento, moto_id) VALUES ('SN-QWE11223', TO_DATE('2025-03-05', 'YYYY-MM-DD'), 3);
INSERT INTO tb_yf_IoT (serial, dt_ultimo_acionamento, moto_id) VALUES ('SN-ASD44556', TO_DATE('2025-04-18', 'YYYY-MM-DD'), 4);
INSERT INTO tb_yf_IoT (serial, dt_ultimo_acionamento, moto_id) VALUES ('SN-ZXC77889', TO_DATE('2025-05-25', 'YYYY-MM-DD'), 5);
INSERT INTO tb_yf_IoT (serial, dt_ultimo_acionamento, moto_id) VALUES ('SN-ZXC77889', TO_DATE('2025-05-25', 'YYYY-MM-DD'), 6);
INSERT INTO tb_yf_IoT (serial, dt_ultimo_acionamento, moto_id) VALUES ('SN-ZXC77889', TO_DATE('2025-05-25', 'YYYY-MM-DD'), 7);
INSERT INTO tb_yf_IoT (serial, dt_ultimo_acionamento, moto_id) VALUES ('SN-ZXC77889', TO_DATE('2025-05-25', 'YYYY-MM-DD'), 8);

INSERT INTO tb_yf_patio (name, qtd_vagas) VALUES ( 'Butantã', 100);
INSERT INTO tb_yf_patio (name, qtd_vagas) VALUES ( 'Marília', 38);
INSERT INTO tb_yf_patio (name, qtd_vagas) VALUES ( 'Nova Odessa', 204);

INSERT INTO tb_yf_moto (modelo, chassi, placa, historico, id_yf) VALUES ( 'MOTTU_SPORT', '2lcEz3b43U1ST0377','2lcEz3b',  'trocar escapamento', 1);
INSERT INTO tb_yf_moto (modelo, chassi, placa, historico, id_yf) VALUES ( 'MOTTU_E',  'a8xD3u8oiu8s0sc90','a8xD3u8',  'trocar a bateria', 2);
INSERT INTO tb_yf_moto (modelo, chassi, placa, historico, id_yf) VALUES ( 'MOTTU_POP',  '1CzR5PUlSwftC3834','1CzR5PU',  'disponivel', 3);
INSERT INTO tb_yf_moto (modelo, chassi, placa, historico, id_yf) VALUES ( 'MOTTU_E', '1ALWx1M9FzlpK3671','1ALWx1M',  'furtada',  4);
INSERT INTO tb_yf_moto (modelo, chassi, placa, historico, id_yf) VALUES ( 'MOTTU_SPORT',  '5RlnaDEb3S7ee1853','5RlnaD8',  'avaria na funilaria',  5);
INSERT INTO tb_yf_moto (modelo, chassi, placa, historico, id_yf) VALUES ( 'MOTTU_POP', '8CXgAkfuSfSdU4475','8CX7gAk',  'trocar rodas',  6);
INSERT INTO tb_yf_moto (modelo, chassi, placa, historico, id_yf) VALUES ( 'MOTTU_E',  '9tFFAzH53jRG96502','9tFFAzH',  'trocar bateria', 7);

INSERT INTO tb_yf_registro_check_in_out (entrada_patio, saida_patio, id_moto) VALUES (TO_DATE('2025-05-01', 'YYYY-MM-DD'), TO_DATE('2025-05-08', 'YYYY-MM-DD'),  12);
INSERT INTO tb_yf_registro_check_in_out (entrada_patio, saida_patio, id_moto) VALUES ( TO_DATE('2025-04-02', 'YYYY-MM-DD'),TO_DATE('2025-05-04', 'YYYY-MM-DD'),  14);
INSERT INTO tb_yf_registro_check_in_out (entrada_patio, saida_patio, id_moto) VALUES ( TO_DATE('2025-05-02', 'YYYY-MM-DD'), TO_DATE('2025-07-03', 'YYYY-MM-DD'),  13);
INSERT INTO tb_yf_registro_check_in_out (entrada_patio, saida_patio, id_moto) VALUES ( TO_DATE('2025-04-03', 'YYYY-MM-DD'),TO_DATE('2025-04-28', 'YYYY-MM-DD'),  8);
INSERT INTO tb_yf_registro_check_in_out (entrada_patio, saida_patio, id_moto) VALUES ( TO_DATE('2025-05-03', 'YYYY-MM-DD'), TO_DATE('2025-08-04', 'YYYY-MM-DD'), 26);
INSERT INTO tb_yf_registro_check_in_out (entrada_patio, saida_patio, id_moto) VALUES ( TO_DATE('2025-05-04', 'YYYY-MM-DD'), TO_DATE('2025-06-04', 'YYYY-MM-DD'),  18);
INSERT INTO tb_yf_registro_check_in_out (entrada_patio, saida_patio, id_moto) VALUES ( TO_DATE('2025-05-04', 'YYYY-MM-DD'), TO_DATE('2025-06-20', 'YYYY-MM-DD'),  21);

INSERT INTO tb_yf_usuario (nome, email, funcao) VALUES ('Ana Souza', 'ana.souza@example.com', 'RECEPCAO');
INSERT INTO tb_yf_usuario (nome, email, funcao) VALUES ('Carlos Oliveira', 'carlos.oliveira@example.com', 'GERENTE_PATIO');
INSERT INTO tb_yf_usuario (nome, email, funcao) VALUES ('Fernanda Lima', 'fernanda.lima@example.com', 'RECEPCAO');
INSERT INTO tb_yf_usuario (nome, email, funcao) VALUES ('João Pereira', 'joao.pereira@example.com', 'MECANICO');
INSERT INTO tb_yf_usuario (nome, email, funcao) VALUES ('Mariana Santos', 'mariana.santos@example.com', 'EXPEDICAO');

