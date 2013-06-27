package upao.paw.compumundo.control.servlet;

import com.j256.ormlite.dao.Dao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import upao.paw.compumundo.BD;
import upao.paw.compumundo.modelo.Configuracion;
import upao.paw.compumundo.modelo.ConfiguracionInicial;
import upao.paw.compumundo.modelo.LineaPedido;
import upao.paw.compumundo.modelo.Producto;

/**
 *
 * @author jahd
 */
@WebServlet(name = "Personalizar", urlPatterns = {"/servlet/Personalizar"})
public class Personalizar extends HttpServlet {

    private static final String REDIRECCION = "/cm/";

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
        String id = request.getParameter("id");
        if (id == null || id.isEmpty()) {
            response.sendRedirect(REDIRECCION
                    + "?mensaje=No se puede personalizar&error=Falta el parametro id");
            return;
        }

        Dao<Producto, Integer> productoDao;
        Dao<Configuracion, Integer> configuracionDao;
        Dao<ConfiguracionInicial, Integer> configuracionInicialDao;
        Dao<LineaPedido, Integer> lineaPedidoDao;
        try {
            configuracionInicialDao = BD.getInstance().getConfiguracionInicialDao();
            configuracionDao = BD.getInstance().getConfiguracionDao();
            lineaPedidoDao = BD.getInstance().getLineaPedidoDao();
            productoDao = BD.getInstance().getProductoDao();
        } catch (SQLException ex) {
            response.sendRedirect(REDIRECCION
                    + "?mensaje=No se pudo conectar a la base de datos&error=" + ex.getMessage());
            return;
        }

        int productoId = new Integer(id);
        Producto prod = new Producto();
        prod.setId(productoId);
//        try {
//            productoDao.refresh(prod);
//        } catch (SQLException ex) {
//            response.sendRedirect(REDIRECCION
//                    + "?mensaje=No se pudo refrescar producto&error=" + ex.getMessage());
//            return;
//        }
        LineaPedido lp = new LineaPedido();
        lp.setProducto(prod);
        try {
            lineaPedidoDao.create(lp);
        } catch (SQLException ex) {
            response.sendRedirect(REDIRECCION
                    + "?mensaje=No se pudo crear lineaPedido&error=" + ex.getMessage());
            return;
        }
        ConfiguracionInicial ci = new ConfiguracionInicial();
        boolean tieneCI = false;
        try {
            List<ConfiguracionInicial> queryForEq = configuracionInicialDao.queryForEq("producto_id", productoId);
            if (queryForEq.isEmpty()) {
                tieneCI = false;
            } else {
                tieneCI = true;
                ci = queryForEq.get(0);
            }
        } catch (SQLException ex) {
            response.sendRedirect(REDIRECCION
                    + "?mensaje=No se pudo obtener configuracion inicial&error=" + ex.getMessage());
            return;
        }
        Configuracion configuracion = new Configuracion();
        configuracion.setLineaPedido(lp);
        if (tieneCI) {
            configuracion.setPersonalizacion(ci.getPersonalizacion());
        }
        try {
            configuracionDao.create(configuracion);
        } catch (SQLException ex) {
            response.sendRedirect(REDIRECCION
                    + "?mensaje=No se pudo crear configuracion&error=" + ex.getMessage());
            return;
        }

        response.sendRedirect("/cm/pantPersonalizar.jsp?id=" + configuracion.getId());
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
