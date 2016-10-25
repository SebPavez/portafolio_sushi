CREATE TABLE producto ( 
     id_producto INTEGER  PRIMARY KEY , 
     stock INTEGER  NOT NULL , 
     nombre VARCHAR2 (50)  NOT NULL , 
     precio_normal INTEGER  NOT NULL , 
     precio_oferta INTEGER  NOT NULL , 
     en_oferta CHAR (1)  NOT NULL , 
     descripcion VARCHAR2 (50)  NOT NULL , 
     categoria INTEGER NOT NULL,
     link_internet varchar2(200) not null) ;