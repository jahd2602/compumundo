package upao.paw.compumundo.control.bean;

import com.j256.ormlite.dao.Dao;
import java.sql.SQLException;
import java.util.List;
import upao.paw.compumundo.BD;
import upao.paw.compumundo.modelo.Producto;

/**
 *
 * @author jahd
 */
public class BeanProductos {

    Dao<Producto, Integer> productoDao;
    private int idCategoria;

    public BeanProductos() throws SQLException {
        productoDao = BD.getInstance().getProductoDao();
    }

    public List<Producto> getProductos() throws SQLException {
        return productoDao.queryForAll();
    }

    public List<Producto> getProductosPorIdCategoria() throws SQLException {
        return productoDao.queryForEq("categoria_id", idCategoria);
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
}
