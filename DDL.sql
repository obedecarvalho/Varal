create table produto (
	id integer primary key,
	descricao text
);

create table compra (
	id integer primary key,
	datacompra integer
);

create table produtocompra (
	id integer primary key,
	idproduto integer,
	idcompra integer,
	foreign key (idproduto) references produto (id),
	foreign key (idcompra) references compra (id)
);
