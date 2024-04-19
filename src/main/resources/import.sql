INSERT INTO USUARIO(nome, email, senha) VALUES('João Silva', 'joao.silva@example.com', 'senha123');

INSERT INTO CURSO (nome, categoria) VALUES ('Curso de Java', 'Programação');
INSERT INTO CURSO (nome, categoria) VALUES ('Curso de Python', 'Análise de Dados');


INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Titulo1', 'Mensagem1', CURRENT_TIMESTAMP, 'NAO_RESPONDIDO', 1, 1);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Titulo2', 'Mensagem2', CURRENT_TIMESTAMP, 'NAO_RESPONDIDO', 2, 2);
