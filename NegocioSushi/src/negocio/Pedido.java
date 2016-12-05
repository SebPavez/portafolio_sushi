
package negocio;

import java.util.ArrayList;
import java.util.Date;

public class Pedido {
    private int id;
    private String formaEntrega;
    private String comentario;
    private double totalVenta;
    private Date fechaHoraPedido;
    private ArrayList<DetallePedido> detallePedido;
    private Cliente cliente;
    private String run_cliente;
    private int idEstado;

    public int getId() {
        return id;
    }

    public String getRun_cliente() {
        return run_cliente;
    }

    public void setRun_cliente(String run_cliente) {
        this.run_cliente = run_cliente;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFormaEntrega() {
        return formaEntrega;
    }

    public void setFormaEntrega(String formaEntrega) {
        this.formaEntrega = formaEntrega;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(double totalVenta) {
        this.totalVenta = totalVenta;
    }

    public Date getFechaHoraPedido() {
        return fechaHoraPedido;
    }

    public void setFechaHoraPedido(Date fechaHoraPedido) {
        this.fechaHoraPedido = fechaHoraPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public ArrayList<DetallePedido> Pedido() {
        return detallePedido;
    }

    public void setDetallePedido(ArrayList<DetallePedido> detallePedido) {
        this.detallePedido = detallePedido;
    }

    public String imprimir() {
        return  "Id Pedido: " + id +"\n"+ 
//                "run cliente: " + run_cliente + "\n"+ 
                "Forma Entrega: " + formaEntrega + "\n"+ 
                "fecha Hora Pedido: " + fechaHoraPedido + "\n"+ 
                "Comentario: " + comentario + "\n"+ 
                "Id Estado: " + idEstado + "\n"+ 
                "Total Venta: " + totalVenta +"\n"+ 
                "-----------------------------------\n"; 
    }
    
}
