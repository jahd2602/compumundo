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
    private TipoPersonalizacion tipoPersonalizacion;
    @DatabaseField(canBeNull = false)
    private double precio;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoPersonalizacion getTipoPersonalizacion() {
        return tipoPersonalizacion;
    }

    public void setTipoPersonalizacion(TipoPersonalizacion tipoPersonalizacion) {
        this.tipoPersonalizacion = tipoPersonalizacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
