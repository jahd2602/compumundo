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
    @DatabaseField
    private String descripcion;
    @DatabaseField
    private double precio_base;
    @DatabaseField(foreign = true)
    private Categoria categoria;

    public Producto() {
    }

    public Producto(String descripcion, double precio_base) {
        this.descripcion = descripcion;
        this.precio_base = precio_base;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio_base() {
        return precio_base;
    }

    public void setPrecio_base(double precio_base) {
        this.precio_base = precio_base;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
