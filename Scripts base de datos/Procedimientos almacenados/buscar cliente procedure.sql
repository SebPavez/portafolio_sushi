create or replace procedure mostrar_cliente
( var_nombre out cliente.nombre_completo%type , 
  var_correo out cliente.correo_electronico%type,
  var_rut out cliente.cliente_run%type , 
  var_direccion out cliente.direccion%type , 
  var_comuna out cliente.comuna%type , 
  var_provincia out cliente.provincia%type , 
  var_region out cliente.region%type , 
  var_telefono out cliente.numero_telefonico%type ,
  var_nacimiento out cliente.fecha_nacimiento%type ,
  var_genero out cliente.genero%type ,   
  var_corr in cliente.correo_electronico%type,
  var_pass in  cliente.nombre_completo%type )
is
begin 
select cliente_run, nombre_completo, direccion, comuna, provincia,region,fecha_nacimiento genero, numero_telefonico,correo_electronico 
    into var_nombre,var_correo, var_rut,var_direccion, var_comuna, var_provincia, var_region, var_telefono, var_nacimiento, var_genero
    from cliente where correo_electronico = var_corr and password = var_pass;
end mostrar_cliente;


declare
v_nombre cliente.nombre_completo%type; 
v_correo cliente.correo_electronico%type;


begin 
 mostrar_cliente(v_nombre, v_correo,'correo@gmail.com', 'pass123' );
 dbms_output.put_line(v_correo);
 dbms_output.put_line(v_nombre);
end;
