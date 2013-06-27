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
import upao.paw.compumundo.modelo.Usuario;

/**
 *
 * @author jahd
 */
@WebServlet(name = "AccionesUsuario", urlPatterns = {"/servlet/AccionesUsuario"})
public class AccionesUsuario extends HttpServlet {

    private static final String REDIRECCION = "/cm/admin/usuarios.jsp";

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
        } else if (id == null) {
            response.sendRedirect(REDIRECCION + "?mensaje=Error realizando accion&error=Falta parametro id");
            return;
        }
        if (accion.equals("Elevar") || accion.equals("Revocar")) {
            Dao<Usuario, Integer> usuarioDao;
            try {
                usuarioDao = BD.getInstance().getUsuarioDao();
            } catch (SQLException ex) {
                response.sendRedirect(REDIRECCION + "?mensaje=Error realizando accion&error=No se pudo conectar a la base de datos");
                return;
            }
            Usuario usuario;
            try {
                usuario = usuarioDao.queryForId(new Integer(id));
            } catch (SQLException ex) {
                response.sendRedirect(REDIRECCION + "?mensaje=Error realizando accion&error=No se encuentra usuario");
                return;
            }
            if (usuario == null) {
                response.sendRedirect(REDIRECCION + "?mensaje=Error realizando accion&error=No se encuentra usuario");
                return;
            }
            if (accion.equals("Elevar")) {
                if (usuario.isEsAdmin()) {
                    response.sendRedirect(REDIRECCION + "?mensaje=Error realizando accion&error=El usuario ya es administrador");
                    return;
                }
                usuario.setEsAdmin(true);
                try {
                    usuarioDao.update(usuario);
                } catch (SQLException ex) {
                    response.sendRedirect(REDIRECCION + "?mensaje=Error realizando accion&error=No se pudo actualizar usuario");
                    return;
                }
                response.sendRedirect(REDIRECCION + "?mensaje=Usuario elevado con exito");
                return;
            } else { // Revocar
                if (!usuario.isEsAdmin()) {
                    response.sendRedirect(REDIRECCION + "?mensaje=Error realizando accion&error=El usuario no es administrador");
                    return;
                }
                int size;
                try {
                    size = usuarioDao.queryForEq("esAdmin", true).size();
                }catch (SQLException ex) {
                    response.sendRedirect(REDIRECCION + "?mensaje=Error realizando accion&error=No se pudo contar administradores");
                    return;
                }
                if (size<=1) {
                    response.sendRedirect(REDIRECCION + "?mensaje=Error realizando accion&error=El sistema no puede quedarse sin administradores");
                    return;
                }
                usuario.setEsAdmin(false);
                try {
                    usuarioDao.update(usuario);
                } catch (SQLException ex) {
                    response.sendRedirect(REDIRECCION + "?mensaje=Error realizando accion&error=No se pudo actualizar usuario");
                    return;
                }
                response.sendRedirect(REDIRECCION + "?mensaje=Permisos de usuario revocados con exito");
                return;
            }
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
