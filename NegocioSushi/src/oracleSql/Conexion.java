package oracleSql;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    public static Connection getConexion(){
        Connection connection =  null;
        try{
            String driverClassName = "oracle.jdbc.driver.OracleDriver";
            //jdbc:oracle:thin:@localhost:1521:XE [sushi on Default schema]
            String driverURI = "jdbc:oracle:thin:@localhost:1521:XE";
            Class.forName(driverClassName);
            connection = DriverManager.getConnection(driverURI, "sushi", "sushi");
        }catch (Exception e){
            System.out.println("Error en conexión a Oracle: "+e.getMessage());
        }
        return connection;
    }

}