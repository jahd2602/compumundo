package upao.paw.compumundo.control.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import upao.paw.compumundo.BD;
import upao.paw.compumundo.modelo.Categoria;
import upao.paw.compumundo.modelo.ConfiguracionInicial;
import upao.paw.compumundo.modelo.Personalizacion;
import upao.paw.compumundo.modelo.Producto;

/**
 *
 * @author jahd
 */
@WebServlet(name = "GuardarProducto", urlPatterns = {"/servlet/GuardarProducto"})
public class GuardarProducto extends HttpServlet {

    private static final String REDIRECCION = "/cm/admin/productos.jsp";

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
        BD bd;
        try {
            bd = BD.getInstance();
        } catch (SQLException ex) {
            response.sendRedirect(REDIRECCION
                    + "?mensaje=No se pudo conectar a la base de datos&error=" + ex.getMessage());
            return;
        }

        Producto prod;
        try {
            prod = bd.getProductoDao().queryForId(new Integer(request.getParameter("id")));
        } catch (Exception ex) {
            response.sendRedirect(REDIRECCION
                    + "?mensaje=No se pudo obtener producto&error=" + ex.getMessage());
            return;
        }
        Categoria cat = new Categoria();
        cat.setId(new Integer(request.getParameter("categoria")));
        prod.setCategoria(cat);
        prod.setDescripcion(request.getParameter("descripcion"));
        prod.setPrecio_base(new Double(request.getParameter("precioBase")));
        try {
            bd.getProductoDao().update(prod);
        } catch (Exception ex) {
            response.sendRedirect(REDIRECCION
                    + "?mensaje=No se pudo guardar producto&error=" + ex.getMessage());
            return;
        }

        List<Personalizacion> listaPer;
        try {
            listaPer = BD.getInstance().getPersonalizacionDao().queryForEq("tipoPersonalizacion_id", request.getParameter("tipoPersonalizacion"));
        } catch (SQLException ex) {
            response.sendRedirect(REDIRECCION
                    + "?mensaje=No se pudo consultar tipoPersonalizacion&error=" + ex.getMessage());
            return;
        }
        Personalizacion pers = listaPer.get(0);
        for (Personalizacion personalizacion : listaPer) {
            if (pers.getPrecio() > personalizacion.getPrecio()) {
                pers = personalizacion;
            }
        }

        ConfiguracionInicial conf = new ConfiguracionInicial();
        conf.setPersonalizacion(pers);
        conf.setProducto(prod);

        try {
            List<ConfiguracionInicial> listaABorrar = bd.getConfiguracionInicialDao().queryForEq("producto_id", prod.getId());
            for (ConfiguracionInicial configuracionInicial : listaABorrar) {
                bd.getConfiguracionInicialDao().delete(configuracionInicial);
            }
        } catch (SQLException ex) {
        }
        try {
            bd.getConfiguracionInicialDao().create(conf);
        } catch (SQLException ex) {
            response.sendRedirect(REDIRECCION
                    + "?mensaje=No se pudo crear Configuracion Inicial&error=" + ex.getMessage());
            return;
        }

        response.sendRedirect(REDIRECCION
                + "?mensaje=Producto actualizado con exito");

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
}
