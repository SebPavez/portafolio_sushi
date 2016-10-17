ALTER TABLE pedido ADD CONSTRAINT run_cliente_FK FOREIGN KEY (run_cliente) REFERENCES cliente (cliente_run); 
ALTER TABLE pedido ADD CONSTRAINT id_estado_FK FOREIGN KEY (id_estado) REFERENCES estado_pedido (id_estado); 
ALTER TABLE detalle_pedido ADD CONSTRAINT id_pedido_FK FOREIGN KEY (id_pedido) REFERENCES pedido (id_pedido);
ALTER TABLE detalle_pedido ADD CONSTRAINT id_producto_FK FOREIGN KEY (id_producto) REFERENCES producto (id_producto);
ALTER TABLE producto add constraint categoria_producto_fk foreign key (categoria) references categoria_producto (id_categoria);
ALTER TABLE producto add constraint tipo_producto_fk foreign key (tipo_producto) references tipo_producto (id_tipo_producto);