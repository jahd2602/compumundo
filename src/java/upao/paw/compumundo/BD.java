package upao.paw.compumundo;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import java.sql.SQLException;
import upao.paw.compumundo.modelo.Producto;

/**
 *
 * @author jahd
 */
public class BD {

    private static BD instance;
    private JdbcPooledConnectionSource conexion;
    private Dao<Producto, Integer> productoDao = null;

    private BD(JdbcPooledConnectionSource conexion) {
        this.conexion = conexion;
    }

    public static BD getInstance() throws SQLException {
        if (instance == null) {
            instance = new BD(new JdbcPooledConnectionSource(
                    Constantes.BD_URL, Constantes.BD_USER, Constantes.BD_PWD));
            instance.conexion.setTestBeforeGet(true);
        }
        return instance;
    }

    public JdbcPooledConnectionSource getConexion() {
        return conexion;
    }

    public Dao<Producto, Integer> getProductoDao() throws SQLException {
        return productoDao == null ? productoDao = DaoManager.createDao(
                conexion, Producto.class) : productoDao;
    }
}
