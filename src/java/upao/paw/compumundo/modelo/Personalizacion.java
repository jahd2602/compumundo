package upao.paw.compumundo.modelo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Personalizacion {

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(canBeNull = false)
    private String nombre;
    @DatabaseField(foreign = true, canBeNull = false)
    private Producto producto;
    @DatabaseField(foreign = true, canBeNull = false)
    private TipoPersonalizacion tipoPersonalizacion;
}
