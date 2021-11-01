create schema dbconteiner;


use dbconteiner;

create table conteiners(
 cpf varchar(15) not null primary key,
 numero varchar(11), 
 tipo varchar(2),
 sttus varchar(5),
 categoria varchAR(10));
 
 create table movimentacoes(
 em int(2),
 des int(2),
 gin int(2),
 gout int(2),
 rep int(2),
 pes int(2),
 sca int(2),
 mov int(2),
 dataInicio varchar(11),
 horaInicio varchar(6),
 dataFim varchar(11),
 horaFim varchar(6),
 cpf varchar(11),
 constraint fk_conteiners foreign key (cpf) references conteiners(cpf));