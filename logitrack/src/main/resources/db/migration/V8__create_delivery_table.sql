create table delivery (
id UUID primary key,
tracking_code varchar(255) unique not null,
status varchar(20) not null,
shipping_date TIMESTAMP,
actual_delivery_date TIMESTAMP,
destination_address varchar(255) not null,
estimated_delivery_date TIMESTAMP not null,
order_id UUID NOT NULL unique REFERENCES orders (id),
delivery_person_id UUID REFERENCES delivery_person (id)
);