package upao.paw.compumundo;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import java.sql.SQLException;
import upao.paw.compumundo.modelo.*;

/**
 *
 * @author jahd
 */
public class BD {

    public static Class[] ENTIDADES = {Categoria.class, Comprador.class,
        Configuracion.class, ConfiguracionInicial.class, LineaPedido.class,
        Pedido.class, Personalizacion.class, Producto.class,
        TipoPersonalizacion.class};
    private static BD instance;
    private JdbcPooledConnectionSource conexion;
    private Dao<Categoria, Integer> categoriaDao = null;
    private Dao<Comprador, Integer> compradorDao = null;
    private Dao<Configuracion, Integer> configuracionDao = null;
    private Dao<ConfiguracionInicial, Integer> configuracionInicialDao = null;
    private Dao<LineaPedido, Integer> lineaPedidoDao = null;
    private Dao<Pedido, Integer> pedidoDao = null;
    private Dao<Personalizacion, Integer> personalizacionDao = null;
    private Dao<Producto, Integer> productoDao = null;
    private Dao<TipoPersonalizacion, Integer> tipoPersonalizacionDao = null;

    private BD(JdbcPooledConnectionSource conexion) {
        this.conexion = conexion;
    }

    public static BD getInstance() throws SQLException {
        if (instance == null) {
            instance = new BD(new JdbcPooledConnectionSource(
                    Constantes.BD_URL, Constantes.BD_USER, Constantes.BD_PWD));
            //instance.conexion.setTestBeforeGet(true);
        }
        return instance;
    }

    public JdbcPooledConnectionSource getConexion() {
        return conexion;
    }

    //<editor-fold defaultstate="collapsed" desc="Getters Dao">
    public Dao<Categoria, Integer> getCategoriaDao() throws SQLException {
        return categoriaDao == null ? categoriaDao = DaoManager.createDao(
                conexion, Categoria.class) : categoriaDao;
    }

    public Dao<Comprador, Integer> getCompradorDao() throws SQLException {
        return compradorDao == null ? compradorDao = DaoManager.createDao(
                conexion, Comprador.class) : compradorDao;
    }

    public Dao<Configuracion, Integer> getConfiguracionDao() throws SQLException {
        return configuracionDao == null ? configuracionDao = DaoManager.createDao(
                conexion, Configuracion.class) : configuracionDao;
    }

    public Dao<ConfiguracionInicial, Integer> getConfiguracionInicialDao() throws SQLException {
        return configuracionInicialDao == null ? configuracionInicialDao = DaoManager.createDao(
                conexion, ConfiguracionInicial.class) : configuracionInicialDao;
    }

    public Dao<LineaPedido, Integer> getLineaPedidoDao() throws SQLException {
        return lineaPedidoDao == null ? lineaPedidoDao = DaoManager.createDao(
                conexion, LineaPedido.class) : lineaPedidoDao;
    }

    public Dao<Pedido, Integer> getPedidoDao() throws SQLException {
        return pedidoDao == null ? pedidoDao = DaoManager.createDao(
                conexion, Pedido.class) : pedidoDao;
    }

    public Dao<Personalizacion, Integer> getPersonalizacionDao() throws SQLException {
        return personalizacionDao == null ? personalizacionDao = DaoManager.createDao(
                conexion, Personalizacion.class) : personalizacionDao;
    }

    public Dao<Producto, Integer> getProductoDao() throws SQLException {
        return productoDao == null ? productoDao = DaoManager.createDao(
                conexion, Producto.class) : productoDao;
    }

    public Dao<TipoPersonalizacion, Integer> getTipoPersonalizacionDao() throws SQLException {
        return tipoPersonalizacionDao == null ? tipoPersonalizacionDao = DaoManager.createDao(
                conexion, TipoPersonalizacion.class) : tipoPersonalizacionDao;
    }
    //</editor-fold>
}
