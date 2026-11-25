create table delivery_person (
id UUID primary key,
name varchar(255) not null,
email varchar(255) not null unique,
phone varchar(255) not null unique,
document varchar(255) not null unique,
status Boolean not null,
creation_date TIMESTAMP not null
);