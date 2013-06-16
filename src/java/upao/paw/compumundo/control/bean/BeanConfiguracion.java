package upao.paw.compumundo.control.bean;

import com.j256.ormlite.dao.Dao;
import java.sql.SQLException;
import java.util.List;
import upao.paw.compumundo.BD;
import upao.paw.compumundo.modelo.Configuracion;
import upao.paw.compumundo.modelo.Personalizacion;

/**
 *
 * @author jahd
 */
public class BeanConfiguracion {

    Dao<Configuracion, Integer> configuracionDao;
    private int lineaPedidoId; // TODO deberia ser linea pedido

    public BeanConfiguracion() throws SQLException {

        configuracionDao = BD.getInstance().getConfiguracionDao();
    }

    public List<Configuracion> getConfiguraciones() throws SQLException {
        return configuracionDao.queryForAll();
    }

    public Configuracion getConfiguracionPorProductoId()
            throws SQLException, IndexOutOfBoundsException {
        return configuracionDao.queryForEq("lineaPedido_id", lineaPedidoId).get(0);
    }

    public double getMontoPorLineaPedidoId() throws SQLException {
        Personalizacion per = getConfiguracionPorProductoId().getPersonalizacion();
        BD.getInstance().getPersonalizacionDao().refresh(per);
        return per.getPrecio();
    }

    public int getLineaPedidoId() {
        return lineaPedidoId;
    }

    public void setLineaPedidoId(int lineaPedidoId) {
        this.lineaPedidoId = lineaPedidoId;
    }
}
