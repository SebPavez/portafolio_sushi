/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author David Perez
 */
public class Producto {
  private int idProducto;
  private int stock;
  private String nombre;
  private int precio_normal;
  private int precio_oferta;
  private Boolean en_oferta;
  private String descripcion;
  private String categoriaProducto;

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
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.idProducto;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        if (this.idProducto != other.idProducto) {
            return false;
        }
        return true;
    }
    
  
}
