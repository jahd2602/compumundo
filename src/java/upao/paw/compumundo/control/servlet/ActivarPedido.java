package upao.paw.compumundo.control.servlet;

import com.j256.ormlite.dao.Dao;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import upao.paw.compumundo.BD;
import upao.paw.compumundo.modelo.Pedido;

/**
 *
 * @author jahd
 */
@WebServlet(name = "ActivarPedido", urlPatterns = {"/servlet/ActivarPedido"})
public class ActivarPedido extends HttpServlet {

    private static final String REDIRECCION = "/cm/admin/pedidos.jsp";

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
                    + "?mensaje=No se pudo archivar el pedido&error=Falta el parametro id");
            return;
        }

        String redireccion = "/cm/admin/verPedido.jsp?id=" + id;

        Dao<Pedido, Integer> pedidoDao;
        try {
            pedidoDao = BD.getInstance().getPedidoDao();
        } catch (SQLException ex) {
            response.sendRedirect(redireccion
                    + "&mensaje=No se pudo conectar a la base de datos&error=" + ex.getMessage());
            return;
        }

        int iid = new Integer(id);
        Pedido pedido;
        try {
            pedido = pedidoDao.queryForId(iid);
        } catch (SQLException ex) {
            response.sendRedirect(redireccion
                    + "&mensaje=No se pudo consultar pedido&error=" + ex.getMessage());
            return;
        }
        pedido.setEstado(Pedido.ESTADO_ACTIVO);
        try {
            pedidoDao.update(pedido);
        } catch (SQLException ex) {
            response.sendRedirect(redireccion
                    + "&mensaje=No se pudo actualizar pedido&error=" + ex.getMessage());
            return;
        }

        response.sendRedirect(redireccion
                + "&mensaje=Pedido re-activado");
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
