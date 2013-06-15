package upao.paw.compumundo.modelo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Pedido {

    public static final int ESTADO_PEDIDO = 1;
    public static final int ESTADO_CANCELADO = 2;
    public static final int ESTADO_ENVIADO = 3;
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(foreign = true)
    private Comprador comprador;
    @DatabaseField(defaultValue = "1")
    private Integer estado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Comprador getComprador() {
        return comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
}
