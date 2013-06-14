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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Personalizacion getPersonalizacion() {
        return personalizacion;
    }

    public void setPersonalizacion(Personalizacion personalizacion) {
        this.personalizacion = personalizacion;
    }
}
