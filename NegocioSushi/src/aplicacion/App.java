package aplicacion;

import vistas.Login;

public class App {
    
    public static void main(String[] args){
        //EJECUCION DE PRUEBAS
//        try{
//            Pruebas pruebas = new Pruebas();
//            pruebas.pruebasPedido();
//        } catch (Exception exc){
//            System.out.println("error en ejecución: "+exc.getMessage());
//        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
        
    }
    
    
}
