create or replace trigger trigger_id_pedido  
   before insert on "SUSHI"."PEDIDO" 
   for each row 
begin  
   if inserting then 
      if :NEW."ID_PEDIDO" is null then 
         select SEC_ID_PEDIDO.nextval into :NEW."ID_PEDIDO" from dual; 
      end if; 
   end if; 
end;
