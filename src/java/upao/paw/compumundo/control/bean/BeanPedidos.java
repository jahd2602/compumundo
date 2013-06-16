package upao.paw.compumundo.control.bean;

import com.j256.ormlite.dao.Dao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import upao.paw.compumundo.BD;
import upao.paw.compumundo.modelo.Pedido;

/**
 *
 * @author jahd
 */
public class BeanPedidos {

    Dao<Pedido, Integer> pedidoDao;

    public BeanPedidos() throws SQLException {
        pedidoDao = BD.getInstance().getPedidoDao();
    }

    public List<Pedido> getPedidos() throws SQLException {
        return pedidoDao.queryForAll();
    }

    public List<Pedido> getPedidosActivos() throws SQLException {
        List<Pedido> lista = getPedidos();
        List<Pedido> ret = new ArrayList<Pedido>();
        for (Pedido pedido : lista) {
            if (pedido.getEstado().equals(Pedido.ESTADO_ACTIVO)) {
                ret.add(pedido);
            }
        }
        return ret;
    }

    public List<Pedido> getPedidosRefreshComprador() throws SQLException {
        List<Pedido> lista = getPedidosActivos();
        for (Pedido pedido : lista) {
            BD.getInstance().getCompradorDao().refresh(pedido.getComprador());
        }
        return lista;
    }
}
