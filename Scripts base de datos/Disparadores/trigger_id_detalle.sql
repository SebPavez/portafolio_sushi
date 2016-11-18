create or replace trigger TRIGGER_ID_DETALLE  
   before insert on "SUSHI"."DETALLE_PEDIDO" 
   for each row 
begin  
   if inserting then 
      if :NEW."ID_DETALLE" is null then 
         select SEC_ID_DETALLE.nextval into :NEW."ID_DETALLE" from dual; 
      end if; 
   end if; 
end;
