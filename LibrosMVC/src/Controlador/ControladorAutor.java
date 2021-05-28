/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.AccionesAutor;
import Modelo.tbl_autor;
import Vista.Frm_Autor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mario
 */
public class ControladorAutor implements WindowListener,ActionListener,MouseListener{

    Frm_Autor vista = new Frm_Autor();
    tbl_autor pvo = new tbl_autor();
    AccionesAutor pdao = new AccionesAutor();

    public ControladorAutor(Frm_Autor vista,  tbl_autor pvo, AccionesAutor pdao) {
       this.vista = vista;
       this.pvo = pvo;
       this.pdao = pdao;
       this.vista.BtnIncertar.addActionListener(this);
       this.vista.BtnModificar.addActionListener(this);
       this.vista.BtnBorrar.addActionListener(this);
       this.vista.addMouseListener(this);
       this.vista.tbleElim.addMouseListener(this);
       this.vista.addWindowListener(this);
    }
    
    private void seleccionar(){
    //vista.TxtCod.setText();
    vista.TxtNombre.setText(vista.tbleElim.getValueAt(vista.tbleElim.getSelectedRow(),1).toString());
    vista.Txtapellido.setText(vista.tbleElim.getValueAt(vista.tbleElim.getSelectedRow(),2).toString());
    }
    
    
    private void mostrar(){
        DefaultTableModel m = new DefaultTableModel();
        m.setColumnCount(0);
        m.addColumn("Id");
        m.addColumn("Nombre ");
        m.addColumn("Apellido");
        
        for (tbl_autor pvo : pdao.consultarTabla()) {
            m.addRow(new Object[]{pvo.getId_autor(),pvo.getNombre(),
                pvo.getApellido()});
        }
        vista.tbleElim.setModel(m);
    }
    
    private boolean eliminar(){
    boolean respuesta = false;
        try {
            respuesta = pdao.eliminar(vista.tbleElim.getValueAt(vista.tbleElim.getSelectedRow(),0).toString());
        } catch (Exception e) {
        }
    return  respuesta;      
    }
    
    private  void llenar(){
    //  this.pvo.setId_autor(Integer.parseInt(vista.tbleElim.getValueAt(vista.tbleElim.getSelectedRow(),0).toString()));
      this.pvo.setNombre(this.vista.TxtNombre.getText());
      this.pvo.setApellido(this.vista.Txtapellido.getText()); 
        
    }

      private boolean Modificar( tbl_autor p ){
    boolean respuesta = false;
          
          p.setId_autor(Integer.parseInt(vista.tbleElim.getValueAt(vista.tbleElim.getSelectedRow(),0).toString()));
          p.setNombre(vista.TxtNombre.getText());
          p.setApellido(vista.Txtapellido.getText());
        try {
            respuesta = pdao.actualizar(p);
        } catch (Exception e) {
            System.out.println(e);
        }
    return  respuesta;      
    }
      
    
    
    
    
    //windows-----------------------------------------------------------------
    
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
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
//acciones de botones----------------------------------------------------- 
    @Override
    public void actionPerformed(ActionEvent e) {
         boolean a; 
        if (e.getSource() == vista.BtnIncertar) {
          
           llenar();
           a = pdao.insertar(this.pvo);
            if (a = false) {
                vista.TxtNombre.setText("");
                vista.Txtapellido.setText("");
                 JOptionPane.showMessageDialog(null, "Se ha incertado correctamente");
            }
            
            mostrar();
 
        }
        
        if (e.getSource()==vista.BtnBorrar) {
            
             a = eliminar();
            if (a == false) {
                vista.TxtNombre.setText("");
                vista.Txtapellido.setText("");
                 JOptionPane.showMessageDialog(null, "Se ha se elimiado  correctamente");
            }
            
            mostrar();
        }
        
        if (e.getSource()==vista.BtnModificar) {
            
             a = Modificar(pvo) ;
            if (a == true) {
                vista.TxtNombre.setText("");
                vista.Txtapellido.setText("");
                 JOptionPane.showMessageDialog(null, "Se ha se elimiado  correctamente");
            }
            
            mostrar();
        }
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        seleccionar();
     }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
