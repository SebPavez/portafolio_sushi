ALTER TABLE pedido DROP CONSTRAINT run_cliente_FK;
ALTER TABLE pedido DROP CONSTRAINT id_estado_FK;
ALTER TABLE detalle_pedido DROP CONSTRAINT id_pedido_FK;
ALTER TABLE detalle_pedido DROP CONSTRAINT id_producto_FK
DROP TABLE pedido;
DROP TABLE estado_pedido;
DROP TABLE detalle_pedido;