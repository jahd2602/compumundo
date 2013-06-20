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
import upao.paw.compumundo.modelo.Configuracion;
import upao.paw.compumundo.modelo.Personalizacion;

/**
 *
 * @author jahd
 */
@WebServlet(name = "CambiarConfiguracion", urlPatterns = {"/servlet/CambiarConfiguracion"})
public class CambiarConfiguracion extends HttpServlet {

    private static final String REDIRECCION = "/cm/index.jsp";

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
                    + "?mensaje=No se pudo cambiar configuracion&error=Falta el parametro id");
            return;
        }

        String redireccion = "/cm/pantPersonalizar.jsp?id=" + id;

        String idCambia = request.getParameter("idCambia");
        if (idCambia == null || idCambia.isEmpty()) {
            response.sendRedirect(redireccion
                    + "&mensaje=No se pudo cambiar configuracion&error=Falta el parametro idCambia");
            return;
        }

        Dao<Configuracion, Integer> configuracionDao;
        try {
            configuracionDao = BD.getInstance().getConfiguracionDao();
        } catch (SQLException ex) {
            response.sendRedirect(redireccion
                    + "&mensaje=No se pudo conectar a la base de datos&error=" + ex.getMessage());
            return;
        }

        Configuracion conf;
        try {
            conf = configuracionDao.queryForId(new Integer(id));
        } catch (SQLException ex) {
            response.sendRedirect(redireccion
                    + "&mensaje=No se pudo encontrar configuracion&error=" + ex.getMessage());
            return;
        }
        Personalizacion per = new Personalizacion();
        per.setId(new Integer(idCambia));
        conf.setPersonalizacion(per);
        try {
            configuracionDao.update(conf);
        } catch (SQLException ex) {
            response.sendRedirect(redireccion
                    + "&mensaje=No se pudo actualizar configuracion&error=" + ex.getMessage());
            return;
        }

        response.sendRedirect(redireccion);
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
