CREATE database bruna;

USE bruna;

create table pessoa (
ID int(11) not null AUTO_INCREMENT,
UltimoNome varchar(255) not null,
PrimeiroNome varchar(255),
Idade int(11),
Profissao varchar(30),
primary key (ID)
);

create table pedido(
PedidoId int(11) not null AUTO_INCREMENT,
NumeroPedido int(11) not null,
PessoaID int(11),
Valor int(11),
primary key (PedidoId),
foreign key (PessoaID) references pessoa(ID)
);

insert into pessoa( UltimoNome, PrimeiroNome, Idade, Profissao) 
values ('Cavalcante', 'Tamer', 28, 'Professor');

insert into pessoa(UltimoNome, PrimeiroNome, Idade, Profissao) 
values ('Bueno', 'Lucas', 25, 'Professor');

insert into pessoa(UltimoNome, PrimeiroNome, Idade, Profissao) 
values ('Wachinski', 'Glaucio', 39, 'Professor');

insert into pessoa(UltimoNome, PrimeiroNome, Idade, Profissao) 
values ('Barreto', 'Luciano', 33, 'Professor');

insert into pessoa(UltimoNome, PrimeiroNome, Idade, Profissao) 
values ('Pereira', 'Flavio', 40, 'Professor');

insert into pessoa(UltimoNome, PrimeiroNome, Idade, Profissao) 
values ('Barbosa', 'Denilson', 40, 'Professor');

insert into pessoa(UltimoNome, PrimeiroNome, Idade, Profissao) 
values ('Temer', 'Michel', 99, 'Presidente');

insert into pessoa(UltimoNome, PrimeiroNome, Idade, Profissao) 
values ('Buarque', 'Chico', 73, 'Músico');

insert into pessoa(UltimoNome, PrimeiroNome, Idade, Profissao) 
values ('Carlos', 'Roberto', 76, 'Músico');

insert into pessoa(UltimoNome, PrimeiroNome, Idade, Profissao) 
values ('Junior', 'Neymar', 25, 'Jogador');

INSERT INTO pedido (NumeroPedido, PessoaID, Valor) VALUES (123,1,3123);
INSERT INTO pedido (NumeroPedido, PessoaID, Valor) VALUES (124,1,13445);
INSERT INTO pedido (NumeroPedido, PessoaID, Valor) VALUES (125,1,12344);
INSERT INTO pedido (NumeroPedido, PessoaID, Valor) VALUES (126,2,87879);
INSERT INTO pedido (NumeroPedido, PessoaID, Valor) VALUES (127,2,12266);
INSERT INTO pedido (NumeroPedido, PessoaID, Valor) VALUES (128,3,223);
INSERT INTO pedido (NumeroPedido, PessoaID, Valor) VALUES (129,3,77898);

SELECT DISTINCT profissao FROM pessoa;
SELECT PrimeiroNome FROM pessoa WHERE (Idade > 35);
SELECT UltimoNome FROM pessoa WHERE Profissao LIKE 'p%';
SELECT UltimoNome FROM pessoa WHERE (Idade >= 30) AND (Idade <= 40);
SELECT * FROM pessoa WHERE ID IN (1,5,7,10);

create table endereco(
	id int(11) not null primary key,
    rua varchar(250) not null,
    cidade varchar(50) not null,
    estado varchar(50) not null,
    cep varchar(10) not null
);

create table aluno(
	id int(11) not null primary key,
    nome varchar(100) not null,
    enderecoId int(11) not null,
    foreign key(enderecoId) references endereco(id)
);