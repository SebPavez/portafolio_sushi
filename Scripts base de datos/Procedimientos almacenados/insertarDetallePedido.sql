CREATE OR REPLACE PROCEDURE insertarDetallePedido(    
    id_pedido IN integer,
    id_producto IN integer,
    cantidad IN integer
)
    
AS
 
   valorNum number;
BEGIN
  valorNum := sec_id_detalle.nextVal;
  INSERT INTO detalle_pedido
  VALUES (valorNum, id_pedido, id_producto, cantidad);
  COMMIT;
END;
