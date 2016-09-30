--CREACION DE TABLAS

CREATE TABLE pedido (
Id_pedido integer PRIMARY KEY,
Forma_entrega varchar2(20) NOT NULL,
comentario varchar2(100) NOT NULL,
total_venta integer NOT NULL,
fecha_hora timestamp NOT NULL, 
run_cliente varchar2(15) NOT NULL,
id_estado integer NOT NULL
);

CREATE TABLE estado_pedido(
    id_estado integer PRIMARY KEY,
    estado varchar2(50) NOT NULL
);

CREATE TABLE detalle_pedido(
    id_pedido integer NOT NULL,
    id_producto integer NOT NULL,
    cantidad integer NOT NULL
);


--RESTRICCIONES PARA TABLAS CREADAS

ALTER TABLE pedido ADD CONSTRAINT run_cliente_FK FOREIGN KEY (run_cliente) REFERENCES cliente (run); 
ALTER TABLE pedido ADD CONSTRAINT id_estado_FK FOREIGN KEY (id_estado) REFERENCES estado_pedido (id_estado); 
ALTER TABLE detalle_pedido ADD CONSTRAINT id_pedido_FK FOREIGN KEY (id_pedido) REFERENCES pedido (id_pedido);
ALTER TABLE detalle_pedido ADD CONSTRAINT id_producto_FK FOREIGN KEY (id_producto) REFERENCES producto (id_producto);

--DROPS

ALTER TABLE pedido DROP CONSTRAINT run_cliente_FK;
ALTER TABLE pedido DROP CONSTRAINT id_estado_FK;
ALTER TABLE detalle_pedido DROP CONSTRAINT id_pedido_FK;
ALTER TABLE detalle_pedido DROP CONSTRAINT id_producto_FK
DROP TABLE pedido;
DROP TABLE estado_pedido;
DROP TABLE detalle_pedido;

--SECUENCIAS

CREATE SEQUENCE sec_id_pedido
START WITH 1
INCREMENT BY 1
NOCACHE --sujeto a discusión
NOCYCLE;

--PROCEDIMIENTOS ALMACENADOS

CREATE OR REPLACE PROCEDURE insertarPedido(    
    forma IN pedido.forma_entrega%TYPE,
    detalle IN pedido.detalle_entrega%TYPE,
    total IN pedido.total_venta%TYPE,    
    run_cliente IN pedido.run_cliente%TYPE)
IS
BEGIN
  INSERT INTO pedido
  VALUES (sec_id_pedido.nextVal, forma, detalle, total, CURRENT_TIMESTAMP, run_cliente, 1);
  COMMIT;
END;

--INSERCIONES INICIALES

BEGIN
insert into estado_pedido VALUES (1, 'Solicitado a local');
insert into estado_pedido VALUES (2, 'En proceso');
insert into estado_pedido VALUES (3, 'En camino a domicilio');
insert into estado_pedido VALUES (4, 'Listo para retiro en local');
insert into estado_pedido VALUES (5, 'ANULADO');
END;