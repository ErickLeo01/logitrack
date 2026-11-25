create table order_item (
id UUID primary key,
quantity INTEGER not null,
unit_price decimal(10, 2) not null,
order_id UUID NOT NULL REFERENCES orders (id),
product_id UUID NOT NULL REFERENCES products (id)
);