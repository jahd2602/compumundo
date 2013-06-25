package upao.paw.compumundo.control.bean;

import com.j256.ormlite.dao.Dao;
import java.sql.SQLException;
import java.util.List;
import upao.paw.compumundo.BD;
import upao.paw.compumundo.modelo.Categoria;
import upao.paw.compumundo.modelo.Comprador;

/**
 *
 * @author jahd
 */
public class BeanComprador {

    Dao<Comprador, Integer> compradorDao;
    private int usuarioId;

    public BeanComprador() throws SQLException {
        compradorDao = BD.getInstance().getCompradorDao();
    }

    public List<Comprador> getCompradoresPorUsuarioId() throws SQLException {
        return compradorDao.queryForEq("usuario_id", usuarioId);
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }
    
    
}
