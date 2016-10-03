package negocio;

public class EstadoPedido {
    private int idEstado;
    private String estado;

    public int getIdEstado() {
        return idEstado;
    }
    
    public void setIdEstado(int estado){
        this.idEstado = estado;
    }
    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "EstadoPedido{" + "idEstado=" + idEstado + ", estado=" + estado + '}';
    }
}
