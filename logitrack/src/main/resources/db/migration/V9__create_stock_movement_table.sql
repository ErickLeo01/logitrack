create table stock_movement (
id UUID primary key,
type varchar(20) not null,
description varchar(255) not null,
moment_date TIMESTAMP not null,
quantity INTEGER not null,
product_id UUID NOT NULL REFERENCES products (id),
source_warehouse_id UUID REFERENCES warehouses (id),
destination_warehouse_id UUID REFERENCES warehouses (id),
user_id UUID NOT NULL REFERENCES users (id)
);