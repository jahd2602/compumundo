package upao.paw.compumundo.control.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import upao.paw.compumundo.Carrito;

/**
 *
 * @author jahd
 */
@WebServlet(name = "AgregarAlCarrito", urlPatterns = {"/servlet/AgregarAlCarrito"})
public class AgregarAlCarrito extends HttpServlet {

    private static final String REDIRECCION = "/cm/carrito.jsp";

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
                    + "?mensaje=No se pudo agregar al carrito&error=Falta el parametro id");
            return;
        }

        Carrito carrito = new Carrito();
        carrito.setSesion(request.getSession());
        List<Integer> items = carrito.getItems();
        int iid = new Integer(id);
        if (!items.contains(iid)) {
            items.add(iid);
            carrito.setItems(items);
            response.sendRedirect(REDIRECCION + "?mensaje=Articulo agregado al carrito");
        } else {
            response.sendRedirect(REDIRECCION + "?mensaje=Articulo modificado");
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
