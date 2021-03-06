package upao.paw.compumundo.control.servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import upao.paw.compumundo.BD;
import upao.paw.compumundo.modelo.*;

/**
 * Crea un ejemplo en el que un cliente compra dos computadoras del mismo
 * fabricante, pero con diferentes configuraciones de pantalla
 *
 * @author jahd
 */
@WebServlet(name = "InsertarEjemplosBD", urlPatterns = {"/servlet/InsertarEjemplosBD"})
public class InsertarEjemplosBD extends HttpServlet {

    private static final String REDIRECCION = "/cm/admin/baseDeDatos.jsp";

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //<editor-fold defaultstate="collapsed" desc="Conectar">
        BD bd;
        try {
            bd = BD.getInstance();
        } catch (SQLException ex) {
            response.sendRedirect(REDIRECCION
                    + "?mensaje=No se pudo conectar a la base de datos&error=" + ex.getMessage());
            return;
        }
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Agregar usuarios por defecto">
        Usuario usrAdmin = new Usuario();
        usrAdmin.setNombre("admin");
        usrAdmin.setPass("admin");
        usrAdmin.setEsAdmin(true);
        try {
            bd.getUsuarioDao().create(usrAdmin);
        } catch (SQLException ex) {
            response.sendRedirect(REDIRECCION
                    + "?mensaje=No se pudo crear ejemplo en tabla Usuario&error=" + ex.getMessage());
            return;
        }

        Usuario usrCesar = new Usuario();
        usrCesar.setNombre("cesar");
        usrCesar.setPass("cesar");
        try {
            bd.getUsuarioDao().create(usrCesar);
        } catch (SQLException ex) {
            response.sendRedirect(REDIRECCION
                    + "?mensaje=No se pudo crear ejemplo en tabla Usuario&error=" + ex.getMessage());
            return;
        }
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Agregar TipoPersonalizacion Disco Duro">
        TipoPersonalizacion tpDiscoDuro = new TipoPersonalizacion();
        tpDiscoDuro.setNombre("Disco Duro");
        try {
            bd.getTipoPersonalizacionDao().create(tpDiscoDuro);
        } catch (SQLException ex) {
            response.sendRedirect(REDIRECCION
                    + "?mensaje=No se pudo crear ejemplo en tabla Tipo Personalizacion&error=" + ex.getMessage());
            return;
        }
        //</editor-fold>

        Personalizacion perTemp;

        //<editor-fold defaultstate="collapsed" desc="Agregar Personalizacion Disco Duro de 1tb">
        perTemp = new Personalizacion();
        perTemp.setTipoPersonalizacion(tpDiscoDuro);
        perTemp.setNombre("1tb");
        perTemp.setPrecio(80);
        try {
            bd.getPersonalizacionDao().create(perTemp);
        } catch (SQLException ex) {
            response.sendRedirect(REDIRECCION
                    + "?mensaje=No se pudo crear ejemplo en tabla Personalizacion&error=" + ex.getMessage());
            return;
        }
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Agregar Personalizacion Disco Duro de 2tb">
        perTemp = new Personalizacion();
        perTemp.setTipoPersonalizacion(tpDiscoDuro);
        perTemp.setNombre("2tb");
        perTemp.setPrecio(150);
        try {
            bd.getPersonalizacionDao().create(perTemp);
        } catch (SQLException ex) {
            response.sendRedirect(REDIRECCION
                    + "?mensaje=No se pudo crear ejemplo en tabla Personalizacion&error=" + ex.getMessage());
            return;
        }
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Agregar Personalizacion Disco Duro de 500mb">
        perTemp = new Personalizacion();
        perTemp.setTipoPersonalizacion(tpDiscoDuro);
        perTemp.setNombre("500mb");
        perTemp.setPrecio(0);
        try {
            bd.getPersonalizacionDao().create(perTemp);
        } catch (SQLException ex) {
            response.sendRedirect(REDIRECCION
                    + "?mensaje=No se pudo crear ejemplo en tabla Personalizacion&error=" + ex.getMessage());
            return;
        }
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Agregar TipoPersonalizacion Capacidad USB">
        TipoPersonalizacion tpCapacidadUSB = new TipoPersonalizacion();
        tpCapacidadUSB.setNombre("Capacidad USB");
        try {
            bd.getTipoPersonalizacionDao().create(tpCapacidadUSB);
        } catch (SQLException ex) {
            response.sendRedirect(REDIRECCION
                    + "?mensaje=No se pudo crear ejemplo en tabla Tipo Personalizacion&error=" + ex.getMessage());
            return;
        }
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Agregar Personalizacion Capacidad USB de 2gb">
        perTemp = new Personalizacion();
        perTemp.setTipoPersonalizacion(tpCapacidadUSB);
        perTemp.setNombre("2gb");
        perTemp.setPrecio(0);
        try {
            bd.getPersonalizacionDao().create(perTemp);
        } catch (SQLException ex) {
            response.sendRedirect(REDIRECCION
                    + "?mensaje=No se pudo crear ejemplo en tabla Personalizacion&error=" + ex.getMessage());
            return;
        }
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Agregar Personalizacion Capacidad USB de 4gb">
        perTemp = new Personalizacion();
        perTemp.setTipoPersonalizacion(tpCapacidadUSB);
        perTemp.setNombre("4gb");
        perTemp.setPrecio(10);
        try {
            bd.getPersonalizacionDao().create(perTemp);
        } catch (SQLException ex) {
            response.sendRedirect(REDIRECCION
                    + "?mensaje=No se pudo crear ejemplo en tabla Personalizacion&error=" + ex.getMessage());
            return;
        }
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Agregar Personalizacion Capacidad USB de 8gb">
        perTemp = new Personalizacion();
        perTemp.setTipoPersonalizacion(tpCapacidadUSB);
        perTemp.setNombre("8gb");
        perTemp.setPrecio(30);
        try {
            bd.getPersonalizacionDao().create(perTemp);
        } catch (SQLException ex) {
            response.sendRedirect(REDIRECCION
                    + "?mensaje=No se pudo crear ejemplo en tabla Personalizacion&error=" + ex.getMessage());
            return;
        }
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Agregar Personalizacion Capacidad USB de 16gb">
        perTemp = new Personalizacion();
        perTemp.setTipoPersonalizacion(tpCapacidadUSB);
        perTemp.setNombre("16gb");
        perTemp.setPrecio(50);
        try {
            bd.getPersonalizacionDao().create(perTemp);
        } catch (SQLException ex) {
            response.sendRedirect(REDIRECCION
                    + "?mensaje=No se pudo crear ejemplo en tabla Personalizacion&error=" + ex.getMessage());
            return;
        }
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Agregar Personalizacion Capacidad USB de 32gb">
        perTemp = new Personalizacion();
        perTemp.setTipoPersonalizacion(tpCapacidadUSB);
        perTemp.setNombre("32gb");
        perTemp.setPrecio(90);
        try {
            bd.getPersonalizacionDao().create(perTemp);
        } catch (SQLException ex) {
            response.sendRedirect(REDIRECCION
                    + "?mensaje=No se pudo crear ejemplo en tabla Personalizacion&error=" + ex.getMessage());
            return;
        }
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Agregar TipoPersonalizacion Pantalla">
        TipoPersonalizacion tpPantalla = new TipoPersonalizacion();
        tpPantalla.setNombre("Pantalla");
        try {
            bd.getTipoPersonalizacionDao().create(tpPantalla);
        } catch (SQLException ex) {
            response.sendRedirect(REDIRECCION
                    + "?mensaje=No se pudo crear ejemplo en tabla Tipo Personalizacion&error=" + ex.getMessage());
            return;
        }
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Agregar Personalizacion Pantalla de 15">
        Personalizacion per15 = new Personalizacion();
        per15.setTipoPersonalizacion(tpPantalla);
        per15.setNombre("15 pulgadas");
        per15.setPrecio(0);
        try {
            bd.getPersonalizacionDao().create(per15);
        } catch (SQLException ex) {
            response.sendRedirect(REDIRECCION
                    + "?mensaje=No se pudo crear ejemplo en tabla Personalizacion&error=" + ex.getMessage());
            return;
        }
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Agregar Personalizacion Pantalla de 22">
        Personalizacion per22 = new Personalizacion();
        per22.setTipoPersonalizacion(tpPantalla);
        per22.setNombre("22 pulgadas");
        per22.setPrecio(50);
        try {
            bd.getPersonalizacionDao().create(per22);
        } catch (SQLException ex) {
            response.sendRedirect(REDIRECCION
                    + "?mensaje=No se pudo crear ejemplo en tabla Personalizacion&error=" + ex.getMessage());
            return;
        }
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Agregar Categoria Desktop">
        Categoria cDesktop = new Categoria();
        cDesktop.setNombre("Desktop");
        try {
            bd.getCategoriaDao().create(cDesktop);
            AgregarProductosACategoria(bd, cDesktop, new Producto("HP Pavilion", 2500), new Producto("Inspiron One", 3200), new Producto("Apple iMac", 5500));
        } catch (SQLException ex) {
            response.sendRedirect(REDIRECCION
                    + "?mensaje=No se pudo crear ejemplo en tabla Categoria&error=" + ex.getMessage());
            return;
        }
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Agregar Categoria Laptop">
        Categoria cTemp = new Categoria();
        cTemp.setNombre("Laptop");
        try {
            bd.getCategoriaDao().create(cTemp);
            AgregarProductosACategoria(bd, cTemp, new Producto("Toshiba Notebook", 3400), new Producto("Apple Macbook Pro", 8900), new Producto("HP ProBook", 3900));

        } catch (SQLException ex) {
            response.sendRedirect(REDIRECCION
                    + "?mensaje=No se pudo crear ejemplo en tabla Categoria&error=" + ex.getMessage());
            return;
        }
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Agregar Categoria Netbook">
        cTemp = new Categoria();
        cTemp.setNombre("Netbook");
        try {
            bd.getCategoriaDao().create(cTemp);
            AgregarProductosACategoria(bd, cTemp, new Producto("Sony Netbook Amd", 1500), new Producto("HP Netbook Envy X2", 800), new Producto("Samsung Netbook AMD", 950));
        } catch (SQLException ex) {
            response.sendRedirect(REDIRECCION
                    + "?mensaje=No se pudo crear ejemplo en tabla Categoria&error=" + ex.getMessage());
            return;
        }
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Agregar Categoria Tablet">
        cTemp = new Categoria();
        cTemp.setNombre("Tablet");
        try {
            bd.getCategoriaDao().create(cTemp);
            AgregarProductosACategoria(bd, cTemp, new Producto("Lenovo A2107", 500), new Producto("Xperia S", 1100), new Producto("Bluesens Android 4.0", 350));
        } catch (SQLException ex) {
            response.sendRedirect(REDIRECCION
                    + "?mensaje=No se pudo crear ejemplo en tabla Categoria&error=" + ex.getMessage());
            return;
        }
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Agregar Categoria Videojuegos">
        cTemp = new Categoria();
        cTemp.setNombre("Videojuegos");
        try {
            bd.getCategoriaDao().create(cTemp);
            AgregarProductosACategoria(bd, cTemp, new Producto("Call of Duty Ghost", 150), new Producto("Fifa 13", 90), new Producto("Watch Dogs", 180));
        } catch (SQLException ex) {
            response.sendRedirect(REDIRECCION
                    + "?mensaje=No se pudo crear ejemplo en tabla Categoria&error=" + ex.getMessage());
            return;
        }
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Agregar Categoria Impresoras">
        cTemp = new Categoria();
        cTemp.setNombre("Impresoras");
        try {
            bd.getCategoriaDao().create(cTemp);
            AgregarProductosACategoria(bd, cTemp, new Producto("HP OjPro", 220), new Producto("Canon MX521", 90), new Producto("Epson Office TX", 110));
        } catch (SQLException ex) {
            response.sendRedirect(REDIRECCION
                    + "?mensaje=No se pudo crear ejemplo en tabla Categoria&error=" + ex.getMessage());
            return;
        }
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Agregar Categoria EReaders">
        cTemp = new Categoria();
        cTemp.setNombre("EReaders");
        try {
            bd.getCategoriaDao().create(cTemp);
            AgregarProductosACategoria(bd, cTemp, new Producto("Screen Alex", 800), new Producto("Nook", 1100), new Producto("iBook", 9990));
        } catch (SQLException ex) {
            response.sendRedirect(REDIRECCION
                    + "?mensaje=No se pudo crear ejemplo en tabla Categoria&error=" + ex.getMessage());
            return;
        }
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Agregar Categoria Accesorios">
        cTemp = new Categoria();
        cTemp.setNombre("Accesorios");
        try {
            bd.getCategoriaDao().create(cTemp);
            AgregarProductosACategoria(bd, cTemp, new Producto("Mouse Razer", 80), new Producto("Audifonos BEAT", 200), new Producto("USB Kingston", 25));
        } catch (SQLException ex) {
            response.sendRedirect(REDIRECCION
                    + "?mensaje=No se pudo crear ejemplo en tabla Categoria&error=" + ex.getMessage());
            return;
        }
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Agregar Producto Computadora HP">
        Producto proComputadora = new Producto();
        proComputadora.setCategoria(cDesktop);
        proComputadora.setDescripcion("HP Slate");
        proComputadora.setPrecio_base(890);
        try {
            bd.getProductoDao().create(proComputadora);
        } catch (SQLException ex) {
            response.sendRedirect(REDIRECCION
                    + "?mensaje=No se pudo crear ejemplo en tabla Producto&error=" + ex.getMessage());
            return;
        }
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Agregar Configuracion Inicial a Computadora HP -> Pantalla de 15">
        ConfiguracionInicial ciComputadora = new ConfiguracionInicial();
        ciComputadora.setProducto(proComputadora);
        ciComputadora.setPersonalizacion(per15);
        try {
            bd.getConfiguracionInicialDao().create(ciComputadora);
        } catch (SQLException ex) {
            response.sendRedirect(REDIRECCION
                    + "?mensaje=No se pudo crear ejemplo en tabla ConfiguracionInicial&error=" + ex.getMessage());
            return;
        }
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Crear Pedido">
        Pedido pedido = new Pedido();
        pedido.setFecha("12/12/2012");
        try {
            bd.getPedidoDao().create(pedido);
        } catch (SQLException ex) {
            response.sendRedirect(REDIRECCION
                    + "?mensaje=No se pudo crear ejemplo en tabla Pedido&error=" + ex.getMessage());
            return;
        }
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Crear LineaPedido 1 -> Computadora HP">
        LineaPedido lp1 = new LineaPedido();
        lp1.setPedido(pedido);
        lp1.setProducto(proComputadora);
        try {
            bd.getLineaPedidoDao().create(lp1);
        } catch (SQLException ex) {
            response.sendRedirect(REDIRECCION
                    + "?mensaje=No se pudo crear ejemplo en tabla LineaPedido&error=" + ex.getMessage());
            return;
        }
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Crea Configuración para LineaPedido 1 por defecto">
        Configuracion c1 = new Configuracion();
        c1.setLineaPedido(lp1);
        Producto pLp1 = lp1.getProducto();
        try {
            c1.setPersonalizacion(getPersonalizacionInicial(pLp1, bd));
        } catch (SQLException ex) {
            response.sendRedirect(REDIRECCION
                    + "?mensaje=No se pudo consultar sobre ConfiguracionInicial de Producto&error=" + ex.getMessage());
            return;
        } catch (IndexOutOfBoundsException ex) {
            response.sendRedirect(REDIRECCION
                    + "?mensaje=No se pudo refrescar Producto de LineaPedido&error=" + ex.getMessage());
            return;
        }
        try {
            bd.getConfiguracionDao().create(c1);
        } catch (SQLException ex) {
            response.sendRedirect(REDIRECCION
                    + "?mensaje=No se pudo crear ejemplo en tabla Configuracion (1)&error=" + ex.getMessage());
            return;
        }
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Crear LineaPedido 2 -> Computadora HP">
        LineaPedido lp2 = new LineaPedido();
        lp2.setPedido(pedido);
        lp2.setProducto(proComputadora);
        try {
            bd.getLineaPedidoDao().create(lp2);
        } catch (SQLException ex) {
            response.sendRedirect(REDIRECCION
                    + "?mensaje=No se pudo crear ejemplo en tabla LineaPedido&error=" + ex.getMessage());
            return;
        }
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Crea Configuración para LineaPedido 2 por defecto">
        Configuracion c2 = new Configuracion();
        c2.setLineaPedido(lp2);
        Producto pLp2 = lp2.getProducto();
        try {
            c2.setPersonalizacion(getPersonalizacionInicial(pLp2, bd));
        } catch (SQLException ex) {
            response.sendRedirect(REDIRECCION
                    + "?mensaje=No se pudo consultar sobre ConfiguracionInicial de Producto&error=" + ex.getMessage());
            return;
        } catch (IndexOutOfBoundsException ex) {
            response.sendRedirect(REDIRECCION
                    + "?mensaje=No se pudo refrescar Producto de LineaPedido&error=" + ex.getMessage());
            return;
        }
        try {
            bd.getConfiguracionDao().create(c2);
        } catch (SQLException ex) {
            response.sendRedirect(REDIRECCION
                    + "?mensaje=No se pudo crear ejemplo en tabla Configuracion (2)&error=" + ex.getMessage());
            return;
        }
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Personalizar Configuracion de Linea Pedido 2 -> Pantalla de 22">
        c2.setPersonalizacion(per22);
        try {
            bd.getConfiguracionDao().update(c2);
        } catch (SQLException ex) {
            response.sendRedirect(REDIRECCION
                    + "?mensaje=No se pudo crear ejemplo en tabla Configuracion&error=" + ex.getMessage());
            return;
        }
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Crear Comprador">
        Comprador comprador = new Comprador();
        comprador.setNombre("John");
        comprador.setApellido("Perez");
        comprador.setDireccion("Av. America");
        comprador.setCiudad("Trujillo");
        comprador.setRegion("La Libertad");
        comprador.setTipoTarjeta("Visa");
        comprador.setNumeroTarjeta("9516546541");
        try {
            bd.getCompradorDao().create(comprador);
        } catch (SQLException ex) {
            response.sendRedirect(REDIRECCION
                    + "?mensaje=No se pudo crear ejemplo en tabla Comprador&error=" + ex.getMessage());
            return;
        }
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Relacionar Pedido con Comprador y Establecer Estado a Pedido">
        pedido.setComprador(comprador);
        pedido.setEstado(Pedido.ESTADO_ACTIVO);
        try {
            bd.getPedidoDao().update(pedido);
        } catch (SQLException ex) {
            response.sendRedirect(REDIRECCION
                    + "?mensaje=No se pudo crear ejemplo en tabla Pedido&error=" + ex.getMessage());
            return;
        }
        //</editor-fold>

        response.sendRedirect(REDIRECCION
                + "?mensaje=Datos de ejemplo insertados con exito");
    }

    /**
     *
     * @param producto a buscar
     * @param bd con conexión a Base de Datos establecida
     * @return Personalización por defecto, basándose en la tabla
     * ConfiguracionInicial
     * @throws SQLException Si no puede consultar en la tabla
     * @throws IndexOutOfBoundsException Si no encontró ninguna personalización
     */
    private Personalizacion getPersonalizacionInicial(Producto producto, BD bd) throws SQLException, IndexOutOfBoundsException {
        bd.getProductoDao().refresh(producto);
        ConfiguracionInicial ciPLp1;
        ciPLp1 = bd.getConfiguracionInicialDao().queryForEq("producto_id", producto).get(0);
        return ciPLp1.getPersonalizacion();
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void AgregarProductosACategoria(BD bd, Categoria categoria, Producto... productos) throws SQLException {
        for (Producto producto : productos) {
            producto.setCategoria(categoria);
            bd.getProductoDao().create(producto);
        }

    }
}
