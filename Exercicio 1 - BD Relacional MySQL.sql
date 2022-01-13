create database db_rh;
use db_rh;

drop table tb_funcionaries;

create table tb_funcionaries(
id bigint auto_increment,
nome varchar (255) not null,
setor varchar (255) not null,
salario decimal (6,2) not null,
primary key (id)
);

insert into tb_funcionaries (nome, setor, salario) values ("Maria", "Gerencia", 3459.00);
insert into tb_funcionaries (nome, setor, salario) values ("Pedro", "Segurança", 1550.29);
insert into tb_funcionaries (nome, setor, salario) values ("Alice", "Vendas", 1460.43);
insert into tb_funcionaries (nome, setor, salario) values ("Antonio", "Vendas", 1460.43);
insert into tb_funcionaries (nome, setor, salario) values ("Andréia", "Marketing",2639.00);


select * from tb_funcionaries where salario > 2000.00;

select * from tb_funcionaries where salario < 2000.00;

update tb_funcionaries set salario = 2500.00 where id =3;
