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
import upao.paw.compumundo.Login;
import upao.paw.compumundo.modelo.Usuario;

/**
 *
 * @author jahd
 */
@WebServlet(name = "AgregarUsuario", urlPatterns = {"/servlet/AgregarUsuario"})
public class AgregarUsuario extends HttpServlet {

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
        String user = request.getParameter(Login.LOGIN_USUARIO);
        String pass = request.getParameter(Login.LOGIN_PASS);
        String strEsAdmin = request.getParameter(Login.LOGIN_ESADMIN);
        if (user == null || user.isEmpty()) {
            response.sendRedirect(REDIRECCION
                    + "?mensaje=No se pudo crear usuario&error=Falta el usuario");
            return;
        }
        user = user.toLowerCase();
        if (pass == null || pass.isEmpty()) {
            response.sendRedirect(REDIRECCION
                    + "?mensaje=No se pudo crear usuario&error=Falta la contraseña");
            return;
        }
        boolean esAdmin = false;
        if (strEsAdmin != null) {
            if (strEsAdmin.equals("true")) {
                esAdmin = true;
            }
        }
        Usuario nuevo = new Usuario();
        nuevo.setNombre(user);
        nuevo.setPass(pass);
        nuevo.setEsAdmin(esAdmin);
        Dao<Usuario, Integer> usuarioDao;
        try {
            usuarioDao = BD.getInstance().getUsuarioDao();
        } catch (SQLException ex) {
            response.sendRedirect(REDIRECCION
                    + "?mensaje=No se pudo crear usuario&error=No se pudo conectar a la base de datos");
            return;
        }
        boolean registrado = false;
        try {
            registrado = !usuarioDao.queryForEq("nombre", user).isEmpty();
        } catch (SQLException ex) {
            response.sendRedirect(REDIRECCION
                    + "?mensaje=No se pudo crear usuario&error=No se pudo conectar a la base de datos");
            return;
        }
        if (registrado) {
            response.sendRedirect(REDIRECCION
                    + "?mensaje=No se pudo crear usuario&error=El usuario ya existe");
            return;
        }
        try {
            usuarioDao.create(nuevo);
        } catch (SQLException ex) {
            response.sendRedirect(REDIRECCION
                    + "?mensaje=No se pudo crear usuario&error=No se puede crear usuario");
            return;
        }

        response.sendRedirect(REDIRECCION
                + "?mensaje=Usuario creado con exito");
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
