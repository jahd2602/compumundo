package upao.paw.compumundo.control.bean;

import com.j256.ormlite.dao.Dao;
import java.sql.SQLException;
import java.util.List;
import upao.paw.compumundo.BD;
import upao.paw.compumundo.modelo.Usuario;

/**
 *
 * @author jahd
 */
public class BeanUsuarios {

    Dao<Usuario, Integer> usuarioDao;

    public BeanUsuarios() throws SQLException {
        usuarioDao = BD.getInstance().getUsuarioDao();
    }

    public List<Usuario> getUsuarios() throws SQLException {
        return usuarioDao.queryForAll();
    }
}
