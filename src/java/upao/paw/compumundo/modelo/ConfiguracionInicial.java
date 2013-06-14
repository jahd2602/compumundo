package upao.paw.compumundo.modelo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class ConfiguracionInicial {

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(foreign = true, canBeNull = false)
    private Producto producto;
    @DatabaseField(foreign = true, canBeNull = false)
    private Personalizacion personalizacion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Personalizacion getPersonalizacion() {
        return personalizacion;
    }

    public void setPersonalizacion(Personalizacion personalizacion) {
        this.personalizacion = personalizacion;
    }
}
