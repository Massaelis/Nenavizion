create table jewelry
(
    price integer      not null,
    color varchar(255),
    id    varchar(255) not null
        primary key,
    name  varchar(255),
    type  varchar(255)
);

alter table jewelry
    owner to postgres;