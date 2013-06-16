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

    public double getMontoTotalPorIdPedido() throws SQLException {
        double ret = 0;
        List<LineaPedido> todos = getLineasPedidoPorIdPedido();
        BeanConfiguracion beanConf = new BeanConfiguracion();
        Producto actual;
        for (LineaPedido linea : todos) {
            actual = linea.getProducto();
            BD.getInstance().getProductoDao().refresh(actual);
            ret += actual.getPrecio_base();
            beanConf.setLineaPedidoId(linea.getId());
            ret += beanConf.getMontoPorLineaPedidoId();
        }
        return ret;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }
}
