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
    private int idTipoPersonalizacion;

    public BeanTiposPersonalizacion() throws SQLException {
        tipoPersonalizacionDao = BD.getInstance().getTipoPersonalizacionDao();
    }

    public TipoPersonalizacion getTipoPersonalizacionPorId() throws SQLException {
        return tipoPersonalizacionDao.queryForId(idTipoPersonalizacion);
    }

    public List<TipoPersonalizacion> getTiposPersonalizacion() throws SQLException {
        return tipoPersonalizacionDao.queryForAll();
    }

    public int getIdTipoPersonalizacion() {
        return idTipoPersonalizacion;
    }

    public void setIdTipoPersonalizacion(int idTipoPersonalizacion) {
        this.idTipoPersonalizacion = idTipoPersonalizacion;
    }
}
