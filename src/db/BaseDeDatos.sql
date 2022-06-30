drop database proyectoSemestral;
CREATE DATABASE IF NOT EXISTS proyectoSemestral;
use proyectoSemestral;



create table departamento(
id int,
nombre varchar(20),
alias varchar(5),
primary key (id)
);

create table usuario (
login varchar(10),
password varchar(10),
id_departamento int,
primary key (login)
);

alter table usuario add FOREIGN KEY (id_departamento) references departamento(id);

create table categoria(
id int not null,
nombre varchar(100) not null,
primary key(id));


create table pelicula(
id int auto_increment not null,
nombre varchar(50) not null,
fechaLanzamiento date not null,
metodoCompra varchar(1) not null,  /*online o presencial*/
precio real not null,
mayoriaEdad bit not null, /*requisito de mayoria de edad para poder jugarlo*/
id_categoria int not null,
primary key (id));
alter table pelicula add FOREIGN KEY (id_categoria) references categoria(id);

alter table pelicula AUTO_INCREMENT = 1;

select * from pelicula order by id;


insert into  categoria values (1, 'terror');
insert into  categoria values (2, 'comedia');
insert into  categoria values (3, 'romance');
insert into  categoria values (4, 'ciencia ficcion');

insert into  pelicula (nombre, fechaLanzamiento,metodoCompra, precio, mayoriaEdad, id_categoria) values ('Titanic', '1997-02-03', 'P', 1500,true , 3 );
insert into  pelicula (nombre, fechaLanzamiento,metodoCompra, precio, mayoriaEdad, id_categoria) values ('Jurassic park', '2022-06-09', 'O', 3000, false,1 );
insert into  pelicula (nombre, fechaLanzamiento,metodoCompra, precio, mayoriaEdad, id_categoria) values ('Avengers', '2019-04-22', 'O', 2500,false , 4);


insert into  departamento values (1, 'Gerencia', 'Ger');
insert into  departamento values (2, 'Personal', 'Per');
insert into  departamento values (3, 'Marketing', 'Mkt');


insert into usuario values ('cmoya', 'cami', 2);
insert into usuario values ('smardones', 'seba', 3);

