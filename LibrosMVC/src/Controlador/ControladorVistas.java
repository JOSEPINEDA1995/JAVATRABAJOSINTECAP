/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.Frm_Autor;
import Vista.Frm_ConsultaLibros;
import Vista.Frm_Menu;
import Vista.Frm_libro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author mario
 */
public class ControladorVistas implements ActionListener{

    Frm_libro vslibro = new Frm_libro();
    Frm_Autor vsAutor = new Frm_Autor();
    Frm_Menu vsMenu = new Frm_Menu();
    Frm_ConsultaLibros vsCon = new Frm_ConsultaLibros();

    public ControladorVistas(Frm_libro vslibro,Frm_Autor vsAutor, Frm_Menu vsMenu,Frm_ConsultaLibros vsCon) {
       this.vsAutor = vsAutor;
       this.vslibro= vslibro;
       this.vsMenu = vsMenu;
       this.vsCon = vsCon;
       vsMenu.btnLConsutla.addActionListener(this);
       vsMenu.btnLibro1.addActionListener(this);
       vsMenu.btnLAutor1.addActionListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
    if(e.getSource()== vsMenu.btnLAutor1){
    vsAutor.setVisible(true);
    vsAutor.setLocationRelativeTo(null);
    }
    if(e.getSource()== vsMenu.btnLibro1){
    vslibro.setVisible(true);
    vslibro.setLocationRelativeTo(null);
    }
    if(e.getSource()== vsMenu.btnLConsutla){
    vsCon.setVisible(true);
    vsCon.setLocationRelativeTo(null);
    }
    
    }
    
}
