package upao.paw.compumundo.control.bean;

import com.j256.ormlite.dao.Dao;
import java.sql.SQLException;
import java.util.List;
import upao.paw.compumundo.BD;
import upao.paw.compumundo.modelo.Personalizacion;

/**
 *
 * @author jahd
 */
public class BeanPersonalizacion {

    Dao<Personalizacion, Integer> personalizacionDao;
    private int idTipoPersonalizacion;

    public BeanPersonalizacion() throws SQLException {
        personalizacionDao = BD.getInstance().getPersonalizacionDao();
    }

    public List<Personalizacion> getPersonalizaciones() throws SQLException {
        return personalizacionDao.queryForAll();
    }

    public long getCantidadPorTipo() throws SQLException {
        long resultado = personalizacionDao.queryBuilder().setCountOf(true)
                .selectColumns().where().eq("tipoPersonalizacion_id",
                idTipoPersonalizacion).countOf();
        return resultado;
    }

    public int getIdTipoPersonalizacion() {
        return idTipoPersonalizacion;
    }

    public void setIdTipoPersonalizacion(int idTipoPersonalizacion) {
        this.idTipoPersonalizacion = idTipoPersonalizacion;
    }
}
