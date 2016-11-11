/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;


public class CategoriaProducto {
  private int id_categoria;
  private String categoria_producto;

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }
  

    public CategoriaProducto() {
        this.categoria_producto = "Rolls";
    }


    public String getCategoria_producto() {
        return categoria_producto;
    }

    public void setCategoria_producto(String categoria_producto) {
        this.categoria_producto = categoria_producto;
    }


    @Override
    public String toString() {
        return this.getCategoria_producto();
    }
    
    public String datosCategoria(){
        return this.getId_categoria()+" || "+this.getCategoria_producto();
    }
    
}
