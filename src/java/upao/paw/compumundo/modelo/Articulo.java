package upao.paw.compumundo.modelo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 *
 * @author jahd
 */
@DatabaseTable
public class Articulo {

    @DatabaseField
    private String descripcion;
    @DatabaseField
    private double precio_base;
}
