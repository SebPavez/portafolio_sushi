package aplicacion;

public class App {
    
    public static void main(String[] args){
        try{
            Pruebas pruebas = new Pruebas();
            pruebas.pruebasProducto();
        } catch (Exception exc){
            System.out.println("error en ejecución: "+exc.getMessage());
        }
        
        
    }
    
    
}
