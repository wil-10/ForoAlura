create table topicos(

    id bigint not null auto_increment,
    titulo varchar(100) not null,
    mensaje varchar(100) not null,
    fecha TIMESTAMP NOT NULL,
    status  varchar(100) not null,
    autor  varchar(100) not null,
    nombre_curso  varchar(100) not null,




    primary key(id)

);