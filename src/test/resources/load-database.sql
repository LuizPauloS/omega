INSERT INTO pessoa (nome_pessoa, cpf) VALUES('Lucas Teste', '111.111.111-11');
INSERT INTO pessoa (nome_pessoa, cpf) VALUES('Marcos Teste', '111.111.111-12');
INSERT INTO pessoa (nome_pessoa, cpf) VALUES('Maria Teste', '111.111.111-13');
INSERT INTO pessoa (nome_pessoa, cpf) VALUES('João Teste', '111.111.111-14');
INSERT INTO pessoa (nome_pessoa, cpf) VALUES('Julia Teste', '111.111.111-15');

INSERT INTO profissional (nome_profissional) VALUES('Mariana');
INSERT INTO profissional (nome_profissional) VALUES('Caroline');
INSERT INTO profissional (nome_profissional) VALUES('Leticia');
INSERT INTO profissional (nome_profissional) VALUES('Luana');
INSERT INTO profissional (nome_profissional) VALUES('Juliana');

INSERT INTO agenda (data_agendamento, observacao, paciente_id, psicologo_id) VALUES(CURRENT_DATE, 'Testando OBS.', (SELECT id FROM pessoa WHERE cpf = '111.111.111-11'), (SELECT id FROM profissional WHERE nome_profissional LIKE '%Mariana%'));
INSERT INTO agenda (data_agendamento, observacao, paciente_id, psicologo_id) VALUES(CURRENT_DATE, 'Testando OBS.', (SELECT id FROM pessoa WHERE cpf = '111.111.111-12'), (SELECT id FROM profissional WHERE nome_profissional LIKE '%Caroline%'));
INSERT INTO agenda (data_agendamento, observacao, paciente_id, psicologo_id) VALUES(CURRENT_DATE, 'Testando OBS.', (SELECT id FROM pessoa WHERE cpf = '111.111.111-13'), (SELECT id FROM profissional WHERE nome_profissional LIKE '%Leticia%'));
INSERT INTO agenda (data_agendamento, observacao, paciente_id, psicologo_id) VALUES(CURRENT_DATE, 'Testando OBS.', (SELECT id FROM pessoa WHERE cpf = '111.111.111-14'), (SELECT id FROM profissional WHERE nome_profissional LIKE '%Juliana%'));
INSERT INTO agenda (data_agendamento, observacao, paciente_id, psicologo_id) VALUES(CURRENT_DATE, 'Testando OBS.', (SELECT id FROM pessoa WHERE cpf = '111.111.111-15'), (SELECT id FROM profissional WHERE nome_profissional LIKE '%Luana%'));
