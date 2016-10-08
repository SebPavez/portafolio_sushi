CREATE TABLE cliente(
    cliente_run varchar2(15) PRIMARY KEY,
    nombre_completo varchar2(100) NOT NULL,
    direccion varchar2(50) NOT NULL, 
    comuna varchar2(50) NOT NULL,
    provincia varchar2(50) NOT NULL,
    region varchar2(50) NOT NULL,
    fecha_nacimiento date NOT NULL,
    genero varchar2(20) NOT NULL,
    correo_electronico varchar2(100) NOT NULL,
    numero_telefonico varchar2(15) NOT NULL,
    password varchar2(50) NOT NULL
);