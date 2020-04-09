insert into selective_process_type (name) values ('Graduação')
insert into selective_process_type (name) values ('Pós-Graduação')

insert into selective_process (name, type_id) values ('Tecnologia Educacional', 1)
insert into selective_process (name, type_id) values ('Ciência 10', 2)

insert into step (name, begin, end, selective_process_id) values ('Pré-Matrícula', '2020-03-20T08:00', '2020-04-30T23:59', 2)

insert into course (name) values ('Especialização em Ensino de Ciências – Anos Finais do Ensino Fundamental “Ciência é Dez!”')

insert into demand (name) values ('Demanda Interna – Profissionais da rede pública de educação em efetivo exercício (municipal, estadual ou federal)')
insert into demand (name) values ('Servidores do quadro permanente da UFMT')
insert into demand (name) values ('Comunidade de baixa renda')

insert into document_type (name, description) values ('FORMAÇÃO ACADÊMICA (não cumulativo)', 'Graduação em Licenciatura em Ciências, Biologia, Química ou Física')
insert into document_type (name, description) values ('EXPERIÊNCIA PROFISSIONAL (tempo de experiência comprovada)', 'Docência de Ensino Básico, na área de Ciência (no mínimo 1 ano)')
insert into document_type (name, description) values ('EXPERIÊNCIA PROFISSIONAL (tempo de experiência comprovada)', 'Docência de Ensino Básico, na área de Biologia, Química ou Física. (no mínimo 1 ano)')

insert into document_type (name, description) values ('FORMAÇÃO ACADÊMICA', 'Certificado ou Diploma de conclusão do Ensino Médio')
insert into document_type (name, description) values ('FORMAÇÃO ACADÊMICA', 'Histórico Escolar de Ensino Médio devidamente registrado')

insert into selective_process_document_type (selective_process_id, document_type_id, points, mandatory) values (2, 1, 5.0, false)
insert into selective_process_document_type (selective_process_id, document_type_id, points, mandatory) values (2, 2, 3.0, false)
insert into selective_process_document_type (selective_process_id, document_type_id, points, mandatory) values (2, 3, 2.0, false)

insert into selective_process_document_type (selective_process_id, document_type_id, points, mandatory) values (1, 4, 0, true)
insert into selective_process_document_type (selective_process_id, document_type_id, points, mandatory) values (1, 5, 0, true)

insert into person (name, cpf, email, birth) values ('Atreus', '49407314057', 'atreus@gmail.com', '1994-03-31')

insert into candidate (person_id, selective_process_id, status) values (1, 2, 'REGISTERED')

insert into role (name) values ('ROLE_ADMIN')
insert into role (name) values ('ROLE_CANDIDATE')

insert into user (email, password, name) values ('robson.costa@gmail.com', '$2a$10$LgfcTF8/7K4IXVOjkpGbBOehTUn93OD4OTjjNApeXdv1yshZJvLj2', 'Robson Oliveira da Costa')

insert into user_role (user_id, role_id) values (1, 1)
