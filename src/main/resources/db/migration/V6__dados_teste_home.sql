-- Dados de teste para a home funcionar corretamente
-- Adicionar registros com saidapatio = null (motos ainda no pátio)

-- Moto 1: Entrou há 3 dias (não deve aparecer em +5 dias)
INSERT INTO tb_yf_registro_check_in_out (entradapatio, saidapatio, periodo, setor, idmoto) 
VALUES (DATE '2025-01-15', NULL, 3, 'MANUTENCAO', 1);

-- Moto 2: Entrou há 7 dias (deve aparecer em +5 dias)
INSERT INTO tb_yf_registro_check_in_out (entradapatio, saidapatio, periodo, setor, idmoto) 
VALUES (DATE '2025-01-11', NULL, 7, 'REPAROS_SIMPLES', 2);

-- Moto 3: Entrou há 10 dias (deve aparecer em +5 dias)
INSERT INTO tb_yf_registro_check_in_out (entradapatio, saidapatio, periodo, setor, idmoto) 
VALUES (DATE '2025-01-08', NULL, 10, 'DANOS_GRAVES', 3);

-- Moto 4: Entrou há 2 dias (não deve aparecer em +5 dias)
INSERT INTO tb_yf_registro_check_in_out (entradapatio, saidapatio, periodo, setor, idmoto) 
VALUES (DATE '2025-01-16', NULL, 2, 'PENDENCIA', 4);

-- Moto 5: Entrou há 15 dias (deve aparecer em +5 dias)
INSERT INTO tb_yf_registro_check_in_out (entradapatio, saidapatio, periodo, setor, idmoto) 
VALUES (DATE '2025-01-03', NULL, 15, 'DEFEITO_MOTOR', 5);
