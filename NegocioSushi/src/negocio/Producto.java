package negocio;

public class Producto {
  private int idProducto;
  private int stock;
  private String nombre;
  private int precio_normal;
  private int precio_oferta;
  private Boolean en_oferta;
  private String descripcion;
  private String categoriaProducto;
  private int idCategoriaProducto;
  private String urlImagen;

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }
    
    public int getIdCategoriaProducto() {
        return idCategoriaProducto;
    }

    public void setIdCategoriaProducto(int idCategoriaProducto) {
        this.idCategoriaProducto = idCategoriaProducto;
    }

    public Producto() {
        this.stock = 0;
        this.nombre = "aroz";
        this.precio_normal = 600;
        this.precio_oferta = 500;
        this.en_oferta = false;
        this.descripcion = "esto es arroz";
        this.categoriaProducto = "comestibles";
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio_normal() {
        return precio_normal;
    }

    public void setPrecio_normal(int precio_normal) {
        this.precio_normal = precio_normal;
    }

    public int getPrecio_oferta() {
        return precio_oferta;
    }

    public void setPrecio_oferta(int precio_oferta) {
        this.precio_oferta = precio_oferta;
    }

    public Boolean getEn_oferta() {
        return en_oferta;
    }

    public void setEn_oferta(Boolean en_oferta) {
        this.en_oferta = en_oferta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoriaProducto() {
        return categoriaProducto;
    }

    public void setCategoriaProducto(String categoriaProducto) {
        this.categoriaProducto = categoriaProducto;
    }

    @Override
    public String toString() {
        return "Nombre Producto" + " "+ nombre + "\n" +  "Stock"+" "+stock +  "\n"+ "En oferta"+ " "+ en_oferta + "\n" +"Descripcion"+ descripcion+ "\n" +"Categoria"+ " "+categoriaProducto +"\n" + "Precio Oferta" + precio_oferta + "\n" + "Precio Normal" +" "+precio_normal + "\n" + "\n";
               
    }
    
  
}
