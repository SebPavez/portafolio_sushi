CREATE TABLE detalle_pedido(
    id_detalle integer PRIMARY KEY,
    id_pedido integer NOT NULL,
    id_producto integer NOT NULL,
    cantidad integer NOT NULL
);