package upao.paw.compumundo.modelo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Pedido {

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(foreign = true)
    private Comprador cliente;
}
