ALTER TABLE pedido DROP CONSTRAINT run_cliente_FK;
ALTER TABLE pedido DROP CONSTRAINT id_estado_FK;
ALTER TABLE detalle_pedido DROP CONSTRAINT id_pedido_FK;
ALTER TABLE detalle_pedido DROP CONSTRAINT id_producto_FK;
ALTER TABLE producto DROP CONSTRAINT categoria_producto_fk;
ALTER TABLE producto DROP CONSTRAINT tipo_producto_fk;

DROP TABLE categoria_producto;
DROP TABLE cliente;
DROP TABLE empleado;
DROP TABLE producto;
DROP TABLE tipo_producto;
DROP TABLE pedido;
DROP TABLE estado_pedido;
DROP TABLE detalle_pedido;

DROP SEQUENCE seq_id_producto;
DROP SEQUENCE seq_id_categoria;
DROP SEQUENCE sec_id_pedido;