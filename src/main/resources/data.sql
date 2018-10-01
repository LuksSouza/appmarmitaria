INSERT INTO CLIENTE (NOME, ATIVO)
VALUES ('Pedro', true),
('Maria', true);

INSERT INTO PRATO (NOME, DESCRICAO)
VALUES ('Frango Xadrez', 'Porção de frango xadrez com arroz e batata frita'),
('Bife Acebolado', 'Porção de Bife Acebolado com arroz e feijão carioca');

INSERT INTO PEDIDO (DATA, QUANTIDADE, CLIENTE_ID, PRATO_ID)
VALUES ('2018-09-30', 1, 1, 1),
('2018-10-01', 2, 2, 2);
