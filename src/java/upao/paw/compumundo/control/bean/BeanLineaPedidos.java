package upao.paw.compumundo.control.bean;

import com.j256.ormlite.dao.Dao;
import java.sql.SQLException;
import java.util.List;
import upao.paw.compumundo.BD;
import upao.paw.compumundo.modelo.LineaPedido;
import upao.paw.compumundo.modelo.Producto;

/**
 *
 * @author jahd
 */
public class BeanLineaPedidos {

    Dao<LineaPedido, Integer> lineaPedidoDao;
    private int idPedido;
    private int idLineaPedido;

    public BeanLineaPedidos() throws SQLException {
        lineaPedidoDao = BD.getInstance().getLineaPedidoDao();
    }

    public List<LineaPedido> getLineasPedido() throws SQLException {
        return lineaPedidoDao.queryForAll();
    }

    public long getCantidadPorIdPedido() throws SQLException {
        long resultado = lineaPedidoDao.queryBuilder().setCountOf(true)
                .selectColumns().where().eq("pedido_id",
                idPedido).countOf();
        return resultado;
    }

    public List<LineaPedido> getLineasPedidoPorIdPedido() throws SQLException {
        return lineaPedidoDao.queryForEq("pedido_id", idPedido);
    }

    public List<LineaPedido> getLineasPedidoRefreshProductoPorIdPedido() throws SQLException {
        List<LineaPedido> ret = lineaPedidoDao.queryForEq("pedido_id", idPedido);
        Dao<Producto, Integer> productoDao = BD.getInstance().getProductoDao();
        for (LineaPedido lp : ret) {
            productoDao.refresh(lp.getProducto());
        }
        return ret;
    }

    public double getMontoTotalPorIdPedido() throws SQLException {
        double ret = 0;
        List<LineaPedido> todos = getLineasPedidoPorIdPedido();
        BeanConfiguracion beanConf = new BeanConfiguracion();
        Producto actual;
        Dao<Producto, Integer> productoDao = BD.getInstance().getProductoDao();
        for (LineaPedido linea : todos) {
            actual = linea.getProducto();
            productoDao.refresh(actual);
            ret += actual.getPrecio_base();
            beanConf.setLineaPedidoId(linea.getId());
            ret += beanConf.getMontoPorLineaPedidoId();
        }
        return ret;
    }

    public double getMontoPorIdLineaPedido() throws SQLException {
        BeanConfiguracion beanConf = new BeanConfiguracion();
        LineaPedido linea = lineaPedidoDao.queryForId(idLineaPedido);
        Producto actual = linea.getProducto();
        BD.getInstance().getProductoDao().refresh(actual);
        double ret = actual.getPrecio_base();
        beanConf.setLineaPedidoId(linea.getId());
        ret += beanConf.getMontoPorLineaPedidoId();
        return ret;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdLineaPedido() {
        return idLineaPedido;
    }

    public void setIdLineaPedido(int idLineaPedido) {
        this.idLineaPedido = idLineaPedido;
    }
}
