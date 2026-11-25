create table orders (
id UUID primary key,
order_date TIMESTAMP not null,
updated_at TIMESTAMP not null,
total_amount decimal(10, 2) not null,
delivery_address varchar(255) not null,
status varchar(20) not null,
user_id UUID not null REFERENCES users (id)
);