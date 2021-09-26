create sequence hibernate_sequence;

alter sequence hibernate_sequence owner to postgres;

create table k_pac_set
(
    id    bigint not null
        constraint k_pac_set_pkey
            primary key,
    title varchar(250)
);

alter table k_pac_set
    owner to postgres;

create table k_pac
(
    id           bigint not null
        constraint k_pac_pkey
            primary key,
    created_at   timestamp,
    description  varchar(2000),
    title        varchar(250),
    k_pac_set_id bigint
        constraint fkrmaf5ona1m2pwfja16yy5yov3
            references k_pac_set
);

alter table k_pac
    owner to postgres;
