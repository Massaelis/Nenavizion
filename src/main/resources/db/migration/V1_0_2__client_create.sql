create table client
(
    email varchar(255) not null
        primary key,
    name  varchar(255),
    pass  varchar(255)
);

alter table client
    owner to postgres;

