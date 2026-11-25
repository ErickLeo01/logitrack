create table products (
id UUID primary key,
name varchar(255) not null,
description varchar(255) not null,
category varchar(255) not null,
brand varchar(255) not null,
product_code varchar(255) not null unique,
price decimal(10, 2) not null,
status Boolean not null
);