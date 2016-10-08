CREATE TABLE pedido (
Id_pedido integer PRIMARY KEY,
Forma_entrega varchar2(20) NOT NULL,
comentario varchar2(100) NOT NULL,
total_venta integer NOT NULL,
fecha_hora timestamp NOT NULL, 
run_cliente varchar2(15) NOT NULL,
id_estado integer NOT NULL
);