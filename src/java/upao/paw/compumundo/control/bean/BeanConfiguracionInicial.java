package upao.paw.compumundo.control.bean;

import com.j256.ormlite.dao.Dao;
import java.sql.SQLException;
import java.util.List;
import upao.paw.compumundo.BD;
import upao.paw.compumundo.modelo.ConfiguracionInicial;
import upao.paw.compumundo.modelo.Personalizacion;

/**
 *
 * @author jahd
 */
public class BeanConfiguracionInicial {

    Dao<ConfiguracionInicial, Integer> configuracionInicialDao;
    private int productoId;

    public BeanConfiguracionInicial() throws SQLException {

        configuracionInicialDao = BD.getInstance().getConfiguracionInicialDao();
    }

    public List<ConfiguracionInicial> getConfiguraciones() throws SQLException {
        return configuracionInicialDao.queryForAll();
    }

    public ConfiguracionInicial getConfiguracionInicialPorProductoId()
            throws SQLException, IndexOutOfBoundsException {
        return configuracionInicialDao.queryForEq("producto_id", productoId).get(0);
    }


    public Personalizacion getPersonalizacionPorProductoId() throws SQLException {
        Personalizacion per = getConfiguracionInicialPorProductoId().getPersonalizacion();
        BD.getInstance().getPersonalizacionDao().refresh(per);
        return per;
    }

    public Personalizacion getPersonalizacionRefreshTipoPorProductoId() throws SQLException {
        Personalizacion per = getPersonalizacionPorProductoId();
        BD.getInstance().getTipoPersonalizacionDao().refresh(per.getTipoPersonalizacion());
        return per;
    }

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }
}
