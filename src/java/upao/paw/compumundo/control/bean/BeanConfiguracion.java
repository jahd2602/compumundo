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
    private int lineaPedidoId;
    private int configuracionId;

    public BeanConfiguracion() throws SQLException {

        configuracionDao = BD.getInstance().getConfiguracionDao();
    }

    public Personalizacion getPersonalizacionPorConfiguracionId() throws SQLException {
        Configuracion conf = configuracionDao.queryForId(configuracionId);
        Personalizacion per = conf.getPersonalizacion();
        BD.getInstance().getPersonalizacionDao().refresh(per);
        return per;
    }

    public Personalizacion getPersonalizacionRefreshTipoPorConfiguracionId() throws SQLException {
        Personalizacion per = getPersonalizacionPorConfiguracionId();
        BD.getInstance().getTipoPersonalizacionDao().refresh(per.getTipoPersonalizacion());
        return per;
    }

    public List<Configuracion> getConfiguraciones() throws SQLException {
        return configuracionDao.queryForAll();
    }

    public Configuracion getConfiguracionPorLineaPedidoId()
            throws SQLException, IndexOutOfBoundsException {
        return configuracionDao.queryForEq("lineaPedido_id", lineaPedidoId).get(0);
    }

    public double getMontoPorLineaPedidoId() throws SQLException {

        Personalizacion per = getPersonalizacionPorLineaPedidoId();
        if (per != null) {
            return per.getPrecio();
        } else {
            return 0;
        }
//        throw new SQLException("No se encontro LineaPedido o Personalizacion");
    }

    public Personalizacion getPersonalizacionPorLineaPedidoId() throws SQLException {
        Personalizacion per = getConfiguracionPorLineaPedidoId().getPersonalizacion();
        BD.getInstance().getPersonalizacionDao().refresh(per);
        return per;
    }

    public Personalizacion getPersonalizacionRefreshTipoPorLineaPedidoId() throws SQLException {
        Personalizacion per = getPersonalizacionPorLineaPedidoId();
        BD.getInstance().getTipoPersonalizacionDao().refresh(per.getTipoPersonalizacion());
        return per;
    }

    public int getLineaPedidoId() {
        return lineaPedidoId;
    }

    public void setLineaPedidoId(int lineaPedidoId) {
        this.lineaPedidoId = lineaPedidoId;
    }

    public int getConfiguracionId() {
        return configuracionId;
    }

    public void setConfiguracionId(int configuracionId) {
        this.configuracionId = configuracionId;
    }
}
