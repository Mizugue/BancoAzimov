
INSERT INTO tb_role (id, authority) VALUES (1, 'ROLE_ADMIN');
INSERT INTO tb_role (id, authority) VALUES (2, 'ROLE_USER');



INSERT INTO tb_user (id, email, username, senha, ativo, criado_em) VALUES (1, 'admin@bancoazimov.com', 'admin', '123', true, '2023-01-01 10:00:00'::timestamp);
INSERT INTO tb_user (id, email, username, senha, ativo, criado_em) VALUES (2, 'cliente1@email.com', 'cliente1', '123', true, '2023-01-02 11:30:00'::timestamp);
INSERT INTO tb_user (id, email, username, senha, ativo, criado_em) VALUES (3, 'gerente@bancoazimov.com', 'gerente', '123', true, '2023-01-03 09:15:00'::timestamp);


INSERT INTO tb_usuario_role (usuario_id, role_id) VALUES (1, 1);
INSERT INTO tb_usuario_role (usuario_id, role_id) VALUES (2, 2);



INSERT INTO tb_conta_bancaria (id, numero_conta, saldo, user_id) VALUES (1, '12345-6', 5000.00, 1);
INSERT INTO tb_conta_bancaria (id, numero_conta, saldo, user_id) VALUES (2, '54321-0', 2500.50, 2);
INSERT INTO tb_conta_bancaria (id, numero_conta, saldo, user_id) VALUES (3, '98765-4', 10000.00, 3);
INSERT INTO tb_conta_bancaria (id, numero_conta, saldo, user_id) VALUES (4, '11111-1', 750.25, 2);


INSERT INTO tb_transacao (id, valor, data_hora, transacao, descricao, conta_origem_id, conta_destino_id) VALUES (1, 150.00, NOW(), 'TRANSFERENCIA', 'Pagamento de aluguel', 1, 2);
INSERT INTO tb_transacao (id, valor, data_hora, transacao, descricao, conta_origem_id, conta_destino_id) VALUES (2, 500.00, NOW(), 'DEPOSITO', 'Depósito em caixa', NULL, 1);
INSERT INTO tb_transacao (id, valor, data_hora, transacao, descricao, conta_origem_id, conta_destino_id) VALUES (3, 200.00, NOW(), 'SAQUE', 'Saque no caixa 24h', 1, NULL);