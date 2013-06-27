package upao.paw.compumundo.modelo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Configuracion {

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(foreign = true, canBeNull = false)
    private LineaPedido lineaPedido;
    @DatabaseField(foreign = true)
    private Personalizacion personalizacion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LineaPedido getLineaPedido() {
        return lineaPedido;
    }

    public void setLineaPedido(LineaPedido lineaPedido) {
        this.lineaPedido = lineaPedido;
    }

    public Personalizacion getPersonalizacion() {
        return personalizacion;
    }

    public void setPersonalizacion(Personalizacion personalizacion) {
        this.personalizacion = personalizacion;
    }
}
