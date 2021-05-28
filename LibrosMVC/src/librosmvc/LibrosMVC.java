/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librosmvc;

import Controlador.ControladorAutor;
import Controlador.ControladorConsultasLibros;
import Controlador.ControladorVistas;
import Controlador.ControladorLibro;
import Modelo.AccionesAutor;
import Modelo.AccionesConsulta;
import Modelo.AccionesLibro;
import Modelo.tbl_autor;
import Modelo.tbl_libro;
import Vista.Frm_Autor;
import Vista.Frm_ConsultaLibros;
import Vista.Frm_Menu;
import Vista.Frm_libro;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.util.Locale;

/**
 *
 * @author mario
 */
public class LibrosMVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    tbl_autor pvo = new tbl_autor();
    tbl_libro Lvo = new tbl_libro();
   AccionesConsulta pdao12 = new AccionesConsulta();
    AccionesAutor pdao = new AccionesAutor();
    AccionesLibro ldap = new AccionesLibro();
    Frm_libro vslibro = new Frm_libro();
    Frm_Autor vsAutor = new Frm_Autor();
    Frm_Menu vsMenu = new Frm_Menu();
    Frm_ConsultaLibros vista = new Frm_ConsultaLibros();
    vsMenu.setVisible(true);
    vsMenu.setLocationRelativeTo(null);
    ControladorVistas cnVistas = new ControladorVistas(vslibro, vsAutor, vsMenu,vista);
    ControladorAutor cnAutor = new ControladorAutor(vsAutor, pvo, pdao);
    ControladorLibro cnLibro = new ControladorLibro(vslibro, Lvo, ldap);
    ControladorConsultasLibros csl = new ControladorConsultasLibros(vista,pdao12);
         
    }
    
}
