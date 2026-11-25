create table stock (
id UUID primary key,
quantity integer not null,
quantity_reserved integer not null,
minimum_quantity integer not null,
version BIGINT not null,
warehouse_id UUID NOT NULL REFERENCES warehouses (id),
product_id UUID NOT NULL REFERENCES products (id),   -- Identificador do produto, obrigatório e vinculado ao ID da tabela product
                                                  -- (chave estrangeira).
UNIQUE (warehouse_id, product_id)
);