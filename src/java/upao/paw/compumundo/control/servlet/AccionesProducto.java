package upao.paw.compumundo.control.servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import upao.paw.compumundo.BD;

/**
 *
 * @author jahd
 */
@WebServlet(name = "AccionesProducto", urlPatterns = {"/servlet/AccionesProducto"})
public class AccionesProducto extends HttpServlet {

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
        String accion = request.getParameter("accion");
        String id = request.getParameter("id");
        if (accion == null) {
            response.sendRedirect(REDIRECCION + "?mensaje=Error realizando accion&error=Falta parametro accion");
            return;
        } else if (id == null || id.isEmpty()) {
            response.sendRedirect(REDIRECCION + "?mensaje=Error realizando accion&error=Falta parametro id");
            return;
        }
        if (accion.equals("Detalle")) {
            response.sendRedirect("/cm/admin/verProducto.jsp?id=" + id);
            return;
        } else if (accion.equals("Eliminar")) {
            try {
                BD.getInstance().getProductoDao().delete(
                        BD.getInstance().getProductoDao().queryForId(new Integer(id)));
            } catch (SQLException ex) {
                response.sendRedirect(REDIRECCION + "?mensaje=Error eliminando producto&error=" + ex.getMessage());
                return;
            }
            response.sendRedirect(REDIRECCION + "?mensaje=Producto eliminado con exito");
            return;
        } else {
            response.sendRedirect(REDIRECCION + "?mensaje=Ocurrio un error&error=No existe la acccion " + accion);
            return;
        }
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
