create database db_farmacia_do_bem;
use db_farmacia_do_bem;

create table tb_categoria(
id_categoria bigint auto_increment,
tipo varchar (255) not null,
valor decimal (6,2) not null,
primary key (id_categoria)
);

insert into tb_categoria (tipo, valor) values ("Cosmético", 29.90);
insert into tb_categoria (tipo, valor) values ("Antibiótico", 67.90);
insert into tb_categoria (tipo, valor) values ("Anti-inflamatório", 11.73);
insert into tb_categoria (tipo, valor) values ("Anti-alérgico", 19.99);
insert into tb_categoria (tipo, valor) values ("Cosmético", 50.90);

create table tb_produto(
id_produto bigint auto_increment,
nome varchar (255) not null,
id_categoria bigint not null,
primary key (id_produto),
constraint foreign key (id_categoria) references tb_categoria(id_categoria)
);

insert into tb_produto (nome, id_categoria) value ("Base BB Cream", 1);
insert into tb_produto (nome, id_categoria) value ("Creme Facial", 1);
insert into tb_produto (nome, id_categoria) value ("Cefalexina", 2);
insert into tb_produto (nome, id_categoria) value ("Torsilax", 3);
insert into tb_produto (nome, id_categoria) value ("Diclofenaco", 3);
insert into tb_produto (nome, id_categoria) value ("Histamin", 4);
insert into tb_produto (nome, id_categoria) value ("Loratadina", 4);
insert into tb_produto (nome, id_categoria) value ("Kit hidratação Power", 5);

select * from tb_categoria where valor > 50.00;

select * from tb_categoria where valor >= 3.00 && valor <= 60.00;

SELECT * FROM tb_produto WHERE nome LIKE 'B%';

SELECT * FROM tb_categoria INNER JOIN tb_produto;

select * from tb_categoria where tipo = "Cosmético";


