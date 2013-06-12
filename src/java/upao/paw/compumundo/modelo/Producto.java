package upao.paw.compumundo.modelo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 *
 * @author jahd
 */
@DatabaseTable
public class Producto {

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(canBeNull = false)
    private String descripcion;
    @DatabaseField(canBeNull = false)
    private double precio_base;
}
