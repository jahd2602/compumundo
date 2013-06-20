/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package upao.paw.compumundo;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sistemas
 */
public class Carrito {

    public static final String ITEMS_CARRITO = "items_carrito";
    private HttpSession sesion;

    public List<Integer> getItems() {
        ArrayList<Integer> items = (ArrayList<Integer>) sesion.getAttribute(ITEMS_CARRITO);
        if (items == null) {
            items = new ArrayList<Integer>();
            sesion.setAttribute(ITEMS_CARRITO, items);
        }
        return items;
    }
    
    public void setItems(List<Integer> items){
        sesion.setAttribute(ITEMS_CARRITO, items);
    }

    public HttpSession getSesion() {
        return sesion;
    }

    public void setSesion(HttpSession sesion) {
        this.sesion = sesion;
    }
}
