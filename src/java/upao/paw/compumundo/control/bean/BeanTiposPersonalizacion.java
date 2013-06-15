package upao.paw.compumundo.control.bean;

import com.j256.ormlite.dao.Dao;
import java.sql.SQLException;
import java.util.List;
import upao.paw.compumundo.BD;
import upao.paw.compumundo.modelo.TipoPersonalizacion;

/**
 *
 * @author jahd
 */
public class BeanTiposPersonalizacion {

    Dao<TipoPersonalizacion, Integer> tipoPersonalizacionDao;

    public BeanTiposPersonalizacion() throws SQLException {
        tipoPersonalizacionDao = BD.getInstance().getTipoPersonalizacionDao();
    }

    public List<TipoPersonalizacion> getTiposPersonalizacion() throws SQLException {
        return tipoPersonalizacionDao.queryForAll();
    }
}
