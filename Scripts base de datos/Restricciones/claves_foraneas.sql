ALTER TABLE pedido ADD CONSTRAINT run_cliente_FK FOREIGN KEY (run_cliente) REFERENCES cliente (cliente_run); 
ALTER TABLE pedido ADD CONSTRAINT id_estado_FK FOREIGN KEY (id_estado) REFERENCES estado_pedido (id_estado); 
ALTER TABLE detalle_pedido ADD CONSTRAINT id_pedido_FK FOREIGN KEY (id_pedido) REFERENCES pedido (id_pedido);
ALTER TABLE detalle_pedido ADD CONSTRAINT id_producto_FK FOREIGN KEY (id_producto) REFERENCES producto (id_producto);
ALTER TABLE tipo_producto  ADD CONSTRAINT tipo_producto PK PRIMARY KEY (nombre);
ALTER TABLE producto add constraint categoria_producto_fk foreign key (categoria) references tipo_producto (nombre);