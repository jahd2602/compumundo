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
    private int idProducto;

    public BeanProductos() throws SQLException {
        productoDao = BD.getInstance().getProductoDao();
    }

    public Producto getProductoPorId() throws SQLException {
        return productoDao.queryForId(idProducto);
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

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
}
