/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.Objects;

public class CategoriaProducto {
  private String categoria_producto;
  

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
        return "CategoriaProducto{" + "categoria_producto=" + categoria_producto + '}';
    }
  
  
    
}
