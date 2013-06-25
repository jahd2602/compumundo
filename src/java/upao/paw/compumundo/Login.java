/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package upao.paw.compumundo;

import javax.servlet.http.HttpSession;

/**
 *
 * @author Sistemas
 */
public class Login {

    public static final String LOGIN_USUARIO = "user";
    public static final String LOGIN_PASS = "pass";
    public static final String LOGIN_ESADMIN = "esadmin";
    public static final String LOGIN_ID = "idUsuario";
    private HttpSession sesion;
    private boolean requiereAdmin;
    private String nombre;
    private boolean esAdmin;

    public boolean getAutorizado() {
        esAdmin = false;
        String usuario = (String) sesion.getAttribute(LOGIN_USUARIO);
        if (usuario == null || usuario.isEmpty()) {
            return false;
        }
        Object objEsAdmin = sesion.getAttribute(LOGIN_ESADMIN);
        if (objEsAdmin == null) {
            objEsAdmin = false;
        }
        esAdmin = (Boolean) objEsAdmin;
        if (requiereAdmin && esAdmin == false) {
            return false;
        }

        nombre = usuario.toUpperCase();
        return true;
    }

    public HttpSession getSesion() {
        return sesion;
    }

    public void setSesion(HttpSession sesion) {
        this.sesion = sesion;
    }

    public boolean isRequiereAdmin() {
        return requiereAdmin;
    }

    public void setRequiereAdmin(boolean requiereAdmin) {
        this.requiereAdmin = requiereAdmin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEsAdmin() {
        return esAdmin;
    }

    public void setEsAdmin(boolean esAdmin) {
        this.esAdmin = esAdmin;
    }
}
