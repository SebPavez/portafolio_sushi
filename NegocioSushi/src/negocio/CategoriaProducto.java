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
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.categoria_producto);
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
        final CategoriaProducto other = (CategoriaProducto) obj;
        if (!Objects.equals(this.categoria_producto, other.categoria_producto)) {
            return false;
        }
        return true;
    }
  
  
    
}
