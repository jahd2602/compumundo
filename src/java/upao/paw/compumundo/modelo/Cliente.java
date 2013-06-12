package upao.paw.compumundo.modelo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Cliente {

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField
    private String nombre;
    // TODO agregar demas campos
}
