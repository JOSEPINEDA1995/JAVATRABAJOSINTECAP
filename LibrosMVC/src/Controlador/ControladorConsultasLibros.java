/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.AccionesConsulta;
import Modelo.LibroBd;
import Modelo.tbl_libro;
import Vista.Frm_ConsultaLibros;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mario
 */
public class ControladorConsultasLibros implements WindowListener{
   
    Frm_ConsultaLibros vista = new Frm_ConsultaLibros();
    AccionesConsulta pdao = new AccionesConsulta();

    public ControladorConsultasLibros( Frm_ConsultaLibros vista ,AccionesConsulta pdao) {
    this.vista = vista;
    this.pdao = pdao;
    this.vista.addWindowListener(this);
    }
    
    
    private void mostrar(){
        DefaultTableModel m = new DefaultTableModel();
        m.setColumnCount(0);
        m.addColumn("Nombre libro");
        m.addColumn("Fecha de lanzamiento");
        m.addColumn("Contenido");
        m.addColumn("Paginas");
        m.addColumn("Nombre autor");
        m.addColumn("Apellido Autor");
        
        for (LibroBd pvo1 : pdao.consultarTabla()) {
            m.addRow(new Object[]{pvo1.getNombreli(),pvo1.getFecha(),pvo1.getContenido(),pvo1.getPag(),pvo1.getNombreautor(),
                pvo1.getAplliedoau()});
        }
        vista.tbleLibro.setModel(m);
    }
  

    @Override
    public void windowOpened(WindowEvent e) {
    mostrar();
    }

    @Override
    public void windowClosing(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
     }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    mostrar(); 
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
    
}
