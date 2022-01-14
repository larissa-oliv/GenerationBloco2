create database db_construindo_a_nossa_vida;
use db_construindo_a_nossa_vida;

create table tb_categoria(
id_categoria bigint auto_increment,
tipo varchar (255) not null,
valor decimal (6,2) not null,
primary key (id_categoria)
);

insert into tb_categoria (tipo, valor) values ("Revestimentos", 29.90);
insert into tb_categoria (tipo, valor) values ("Materiais de Construção", 23.00);
insert into tb_categoria (tipo, valor) values ("Acessórios", 3.99);
insert into tb_categoria (tipo, valor) values ("Tintas", 68.00);
insert into tb_categoria (tipo, valor) values ("Revestimentos", 93.00);

create table tb_produto(
id_produto bigint auto_increment,
nome varchar (255) not null,
id_categoria bigint not null,
primary key (id_produto),
constraint foreign key (id_categoria) references tb_categoria(id_categoria)
);

insert into tb_produto (nome, id_categoria) value ("Porcelanato Onix", 5);
insert into tb_produto (nome, id_categoria) value ("Ceramica retificada madeira", 1);
insert into tb_produto (nome, id_categoria) value ("Cimento", 2);
insert into tb_produto (nome, id_categoria) value ("Prego", 3);
insert into tb_produto (nome, id_categoria) value ("Espaçadores", 3);
insert into tb_produto (nome, id_categoria) value ("Branco acetinado", 4);
insert into tb_produto (nome, id_categoria) value ("Cinza grafitte", 4);
insert into tb_produto (nome, id_categoria) value ("Areia", 2);

select * from tb_categoria where valor > 50.00;

select * from tb_categoria where valor >= 3.00 && valor <= 60.00;

SELECT * FROM tb_produto WHERE nome LIKE 'C%';

SELECT * FROM tb_categoria INNER JOIN tb_produto;

select * from tb_categoria where tipo = "Revestimentos";


