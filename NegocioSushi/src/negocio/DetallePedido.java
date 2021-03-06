package negocio;

public class DetallePedido {
    private int idPedido;
    private Producto producto;
    private int cantidad;
    private double totalDetalle;

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

   
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotalDetalle() {
        return totalDetalle;
    }

    public void setTotalDetalle(double totalDetalle) {
        this.totalDetalle = totalDetalle;
    }

    @Override
    public String toString() {
        return "ID Pedido " + idPedido + ", producto=" + producto + ", cantidad=" + cantidad + ", totalDetalle=" + totalDetalle + '}';
    }
    
}
