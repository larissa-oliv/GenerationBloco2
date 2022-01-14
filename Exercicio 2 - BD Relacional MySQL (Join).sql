create database db_pizzaria_legal;
use db_pizzaria_legal;

drop table tb_categoria;

create table tb_categoria(
id_categoria bigint auto_increment,
tipo varchar (255) not null,
tamanho enum ('grande','broto'),
preco decimal (6,2) not null,
primary key (id_categoria)
);

insert into tb_categoria (tipo, tamanho, preco) values ("Salgada", 'grande',55.00);
insert into tb_categoria (tipo, tamanho, preco) values ("Salgada", 'grande',60.00);
insert into tb_categoria (tipo, tamanho, preco) values ("Doce", 'grande',57.00);
insert into tb_categoria (tipo, tamanho, preco) values ("Doce", 'grande',57.00);
insert into tb_categoria (tipo, tamanho, preco) values ("Doce", 'broto',30.00);

create table tb_pizza(
id_pizza bigint auto_increment,
sabor varchar (255) not null,
id_categoria bigint not null,
primary key (id_pizza),
constraint foreign key (id_categoria) references tb_categoria(id_categoria)
);

drop table tb_pizza;

insert into tb_pizza (sabor, id_categoria) value ("Calabresa", 1);
insert into tb_pizza (sabor, id_categoria) value ("Camarão",1);
insert into tb_pizza (sabor, id_categoria) value ("Doritos", 2);
insert into tb_pizza (sabor, id_categoria) value ("Escarola", 2);
insert into tb_pizza (sabor, id_categoria) value ("Brigadeiro", 3);
insert into tb_pizza (sabor, id_categoria) value ("Prestígio", 4);
insert into tb_pizza (sabor, id_categoria) value ("Morango", 4);
insert into tb_pizza (sabor, id_categoria) value ("M&M's", 5);

select * from tb_categoria where preco > 45.00;

select * from tb_categoria where preco >= 29.00 && preco <= 60;

SELECT * FROM tb_pizza WHERE sabor LIKE 'C%';

SELECT * FROM tb_categoria INNER JOIN tb_pizza;

select * from tb_categoria where tipo = "Doce";