
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.Frm_BorrarModificar;

import vista.Frm_Insertar;
import vista.Frm_Menu;

import vista.Frm_Mostrar;


public class ControladorMenu implements ActionListener{

    Frm_Menu vMe = new Frm_Menu();
    Frm_Insertar vIn = new Frm_Insertar();
    Frm_Mostrar vMo = new Frm_Mostrar();
 Frm_BorrarModificar vs = new Frm_BorrarModificar();
    
    public ControladorMenu(Frm_Menu vMe, Frm_Insertar vIn, Frm_Mostrar vMo, Frm_BorrarModificar vs){
        this.vMe = vMe;
        this.vIn = vIn;
        this.vMo = vMo;
        this.vs = vs;
        
        vMe.btnInsertarM.addActionListener(this);
        vMe.btnMostrarM.addActionListener(this);
        vMe.btnEliminar.addActionListener(this);
       
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vMe.btnInsertarM){
            vIn.setVisible(true);
            vIn.setLocationRelativeTo(null);
        }
        if(e.getSource() == vMe.btnMostrarM){
            vMo.setVisible(true);
            vMo.setLocationRelativeTo(null);
        }
        if(e.getSource() == vMe.btnEliminar){
            vs.setVisible(true);
            vs.setLocationRelativeTo(null);
        }
       
    }
    
}
