CREATE OR REPLACE PROCEDURE insertarPedido(    
    forma IN pedido.forma_entrega%TYPE,
    detalle IN pedido.forma_entrega%TYPE,
    total IN pedido.total_venta%TYPE,    
    run_cliente IN pedido.run_cliente%TYPE,
    estado in estado_pedido.estado%type)
    
IS
BEGIN
  INSERT INTO pedido
  VALUES (sec_id_pedido.nextVal, forma, detalle, total, CURRENT_TIMESTAMP, run_cliente, estado);
  COMMIT;
END;
