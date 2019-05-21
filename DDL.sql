create table produto (
	id integer primary key autoincrement,
	descricao text
);

create table compra (
	id integer primary key autoincrement,
	datacompra integer
);

create table produtocompra (
	id integer primary key autoincrement,
	idproduto integer,
	idcompra integer,
	foreign key (idproduto) references produto (id),
	foreign key (idcompra) references compra (id)
);
