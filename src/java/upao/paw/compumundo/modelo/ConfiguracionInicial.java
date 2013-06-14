package upao.paw.compumundo.modelo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class ConfiguracionInicial {

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(foreign = true, canBeNull = false)
    private Pedido pedido;
    @DatabaseField(foreign = true, canBeNull = false)
    private Personalizacion personalizacion;
}
