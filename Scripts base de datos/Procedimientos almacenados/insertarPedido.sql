CREATE OR REPLACE PROCEDURE insertarPedido(    
    forma IN pedido.forma_entrega%TYPE,
    detalle IN pedido.forma_entrega%TYPE,
    total IN pedido.total_venta%TYPE,    
    run_cliente IN pedido.run_cliente%TYPE,
    estado IN estado_pedido.estado%TYPE,
    id_salida OUT pedido.id_pedido%TYPE
)
    
AS
   valorNum number;
BEGIN
  valorNum := sec_id_pedido.nextVal;
  INSERT INTO pedido
  VALUES (valorNum, forma, detalle, total, CURRENT_TIMESTAMP, run_cliente, estado);
  idSalida := valorNum;
  
  COMMIT;
END;
