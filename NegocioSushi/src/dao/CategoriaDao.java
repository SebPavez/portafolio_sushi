package dao;

import java.util.ArrayList;
import negocio.CategoriaProducto;

public interface CategoriaDao {
    public boolean agregarCategoria(String cat);
    public boolean eliminarCategoria(String categoria);
    public ArrayList<CategoriaProducto> listarCategoria();
    public CategoriaProducto buscarCategoria(String cat);
    public boolean actualizaCategoria(CategoriaProducto categoria);
}
