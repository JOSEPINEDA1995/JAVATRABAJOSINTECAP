
package conectormvc2021;


import com.sun.org.apache.bcel.internal.generic.AALOAD;
import controlador.ControladorInsertar;
import controlador.ControladorMenu;
import controlador.ControladorModificarEliminar;

import controlador.ControladorMostrar;
import modelo.Conector;
import modelo.PaisDAO;
import modelo.PaisVO;
import vista.Frm_BorrarModificar;

import vista.Frm_Insertar;
import vista.Frm_Menu;

import vista.Frm_Mostrar;

/**
 *
 * @author Jonathan Pimentel
 */
public class ConectorMVC2021 {

   
    public static void main(String[] args) {
        // TODO code application logic here
//        Conector c = new Conector();
//        c.conectar();
        
        //Vistas
        Frm_Menu m = new Frm_Menu();
        Frm_Insertar fi = new Frm_Insertar();
        Frm_Mostrar fm = new Frm_Mostrar();
        Frm_BorrarModificar vs = new Frm_BorrarModificar();
        //Accesos a los datos
        PaisVO pvo = new PaisVO();
        PaisDAO pdao = new PaisDAO();
        
        //Controladores
        ControladorMenu cm = new ControladorMenu(m, fi, fm, vs);
        ControladorInsertar ci = new ControladorInsertar(fi, pvo, pdao);
        ControladorMostrar cmo = new ControladorMostrar(fm, pvo, pdao);
        ControladorModificarEliminar cms = new ControladorModificarEliminar(vs, pvo, pdao);
        
        m.setVisible(true);
        m.setLocationRelativeTo(null);
        
    }
    
}
