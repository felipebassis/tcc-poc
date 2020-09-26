--liquibase formatted sql

--changeset master:1
create extension if not exists "uuid-ossp";

--changeset master:2
create table "product" (
    "id"                uuid           not null default uuid_generate_v4(),
    "name"              varchar(600)   not null,
    "description"       text           null,
    "cash_value"        numeric(19, 2) not null,
    "term_value"         numeric(19, 2) not null,
    "quantity_in_stock" numeric(19, 4) not null,
    constraint "produto_pk" primary key ("id")
);
--rollback drop table product;
