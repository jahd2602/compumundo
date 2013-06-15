package upao.paw.control.bean;

import com.j256.ormlite.dao.Dao;
import java.sql.SQLException;
import java.util.List;
import upao.paw.compumundo.BD;
import upao.paw.compumundo.modelo.Producto;

/**
 *
 * @author jahd
 */
public class ListaProductos {

    Dao<Producto, Integer> productoDao;

    public ListaProductos() throws SQLException {
        productoDao = BD.getInstance().getProductoDao();
    }

    public List<Producto> getLista() throws SQLException {
        return productoDao.queryForAll();
    }
}
