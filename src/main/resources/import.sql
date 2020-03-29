insert into selective_process_type (description) values ('Graduação');
insert into selective_process_type (description) values ('Pós-Graduação');

insert into selective_process (name, type_id) values ('Tecnologia Educacional', 1);
insert into selective_process (name, type_id) values ('Ciência 10', 2);

insert into candidate_status (description) values ('Inscrito');
insert into candidate_status (description) values ('Pré-Matrículado');
insert into candidate_status (description) values ('Classificado');
insert into candidate_status (description) values ('Aprovado');

insert into step (name, begin, end, selective_process_id) values ('Pré-Matrícula', '2020-03-20T08:00', '2020-03-23T23:59', 2);

insert into course (name) values ('Especialização em Ensino de Ciências – Anos Finais do Ensino Fundamental “Ciência é Dez!”');

insert into pole (name) values ('Cuiabá');
insert into pole (name) values ('Água Boa');
insert into pole (name) values ('Sorriso');

insert into demand (name) values ('Demanda Interna – Profissionais da rede pública de educação em efetivo exercício (municipal, estadual ou federal)');
insert into demand (name) values ('Servidores do quadro permanente da UFMT');
insert into demand (name) values ('Comunidade de baixa renda');
