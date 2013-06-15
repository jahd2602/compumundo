package upao.paw.compumundo.control.bean;

import com.j256.ormlite.dao.Dao;
import java.sql.SQLException;
import java.util.List;
import upao.paw.compumundo.BD;
import upao.paw.compumundo.modelo.Categoria;

/**
 *
 * @author jahd
 */
public class BeanCategorias {

    Dao<Categoria, Integer> categoriaDao;

    public BeanCategorias() throws SQLException {
        categoriaDao = BD.getInstance().getCategoriaDao();
    }

    public List<Categoria> getCategorias() throws SQLException {
        return categoriaDao.queryForAll();
    }
}
