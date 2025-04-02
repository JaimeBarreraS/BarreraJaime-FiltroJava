create database konoha_db;
use konoha_db;

create table ninja (
	 id int auto_increment primary key,
     nombre varchar(50),
     rango varchar(50),
     aldea varchar(50)
);

create table mision (
	id int auto_increment primary key,
    descripcion text,
    rango varchar(20),
    recompensa decimal(10,2)
);

create table misionNinja (
	id_ninja int,
    id_mision int,
    fecha_inicio date,
    fecha_fin date,
    primary key (id_ninja, id_mision),
    foreign key (id_ninja) references ninja(id),
    foreign key (id_mision) references mision(id)
);

create table habilidad (
	id int auto_increment primary key,
    id_ninja int,
    nombre varchar(50),
    descripcion text,
    foreign key (id_ninja) references ninja(id)
);

insert into ninja (nombre, rango , aldea) values 
("Naruto Uzumaki", "Hokage", "Konoha"),
("Sasuke Uchiha", "Jounin Elite", "Konoha"),
("Kakashi Hatake", "Jounin", "Konoha");

insert into mision (descripcion, rango , recompensa) values 
("Proteger al señor Feudal", "A", 5000),
("Capturar un criminal", "B", 3000),
("Esponiaje en otra aldea", "S", 10000);

insert into misionNinja (id_ninja, id_mision, fecha_inicio, fecha_fin) values
(1,1, "2024-03-01", "2024-03-10"),
(2,2, "2022-01-03", "2022-01-20"),
(3,3, "2025-05-05", "2025-05-30");

insert into habilidad (id_ninja, nombre, descripcion) values
(1, "Rasengan", "Tecnica de chakara en espiral"),
(2, "Sharingan", "Ojo especial del clan uchiha"),
(3, "Chidori", "Tecnica de electricidad rapida");

show databases;





 