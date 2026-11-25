create table users (
id UUID primary key,
name varchar(255) not null,
email varchar(255) not null unique,
password varchar(255) not null,
user_role varchar(20) not null
);