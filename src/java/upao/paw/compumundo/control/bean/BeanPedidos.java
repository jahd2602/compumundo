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
    int idPedido;

    public BeanPedidos() throws SQLException {
        pedidoDao = BD.getInstance().getPedidoDao();
    }

    public Pedido getPedidoRefreshComprador() throws SQLException {
        Pedido ret = pedidoDao.queryForId(idPedido);
        BD.getInstance().getCompradorDao().refresh(ret.getComprador());
        return ret;
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

    public List<Pedido> getPedidosArchivados() throws SQLException {
        List<Pedido> lista = getPedidos();
        List<Pedido> ret = new ArrayList<Pedido>();
        for (Pedido pedido : lista) {
            if (pedido.getEstado().equals(Pedido.ESTADO_ARCHIVADO)) {
                ret.add(pedido);
            }
        }
        return ret;
    }

    public List<Pedido> getPedidosArchivadosRefreshComprador() throws SQLException {
        List<Pedido> lista = getPedidosArchivados();
        for (Pedido pedido : lista) {
            BD.getInstance().getCompradorDao().refresh(pedido.getComprador());
        }
        return lista;
    }

    public List<Pedido> getPedidosRefreshComprador() throws SQLException {
        List<Pedido> lista = getPedidosActivos();
        for (Pedido pedido : lista) {
            BD.getInstance().getCompradorDao().refresh(pedido.getComprador());
        }
        return lista;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }
}
