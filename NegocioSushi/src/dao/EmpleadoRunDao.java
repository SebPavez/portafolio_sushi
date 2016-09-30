package dao;

import java.util.ArrayList;
import negocio.EmpleadoRun;

public interface EmpleadoRunDao {
    
    public boolean almacenarEmpleado(EmpleadoRun nuevoEmpleado);
    public boolean eliminarEmpleado(EmpleadoRun empleadoRun);
    public boolean modificarCliente(EmpleadoRun empleadoModificado);
    public ArrayList<EmpleadoRun> listarEmpleados();
}
