/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.AccionesAutor;
import Modelo.AccionesLibro;
import Modelo.tbl_autor;
import Modelo.tbl_libro;
import Vista.Frm_libro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mario
 */
public class ControladorLibro implements WindowListener,ActionListener,MouseListener{
    ArrayList<tbl_autor> lista = new ArrayList<>();
    Frm_libro vista = new Frm_libro();
    tbl_libro pvo = new tbl_libro();
    AccionesLibro pdao = new AccionesLibro();
    

    public ControladorLibro(Frm_libro vista,  tbl_libro pvo, AccionesLibro pdao) {
       this.vista = vista;
       this.pvo = pvo;
       this.pdao = pdao;
       this.vista.BtnIncertar.addActionListener(this);
       this.vista.BtnModificar.addActionListener(this);
       this.vista.BtnBorrar.addActionListener(this);
       this.vista.addMouseListener(this);
       this.vista.tbleLibro.addMouseListener(this);
       this.vista.addWindowListener(this);
    }


private void llenarconbo(){
  
    AccionesAutor ac = new AccionesAutor();
    lista = ac.consultarTabla();
    for (int i = 0; i < lista.size(); i++) {
          vista.jComboBox1.addItem(lista.get(i).getNombre()+" "+lista.get(i).getApellido());
    }
}

public int obtenerindice(String id)
{int ids = Integer.parseInt(id);
int respuesta=0;
    for (int i = 0; i < lista.size(); i++) {
     int  pruba = lista.get(i).getId_autor();
        if(pruba==ids){
        respuesta = i;
        }
            
    }

    return respuesta;
}

private boolean insertarDatos(){
boolean respuesta;
pvo.setId_autor(0);
int a =vista.jComboBox1.getSelectedIndex();
pvo.setId_autor(lista.get(a).getId_autor());
pvo.setNombre(vista.TxtNombre.getText());
  Date  fecha=vista.jDateChooser1.getDate();
        DateFormat f =new SimpleDateFormat("yyyy-MM-dd");
        String fecha2=f.format(fecha);
pvo.setFecha(fecha2);
pvo.setContenido(vista.TxtContenido.getText());
pvo.setPaginas(Integer.parseInt(vista.TxtPag.getText()));
respuesta = pdao.insertar(pvo);

return respuesta;
}
    private void seleccionar() throws ParseException{
    String fecha;
    vista.TxtNombre.setText(vista.tbleLibro.getValueAt(vista.tbleLibro.getSelectedRow(),2).toString());
    vista.TxtContenido.setText(vista.tbleLibro.getValueAt(vista.tbleLibro.getSelectedRow(),4).toString());
    vista.jComboBox1.setSelectedIndex(obtenerindice(vista.tbleLibro.getValueAt(vista.tbleLibro.getSelectedRow(),1).toString()));
    vista.TxtPag.setText(vista.tbleLibro.getValueAt(vista.tbleLibro.getSelectedRow(),5).toString());
   SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaDate = null;
           fecha = vista.tbleLibro.getValueAt(vista.tbleLibro.getSelectedRow(),3).toString();
        try {
    
            fechaDate = formato.parse(fecha);
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }
    vista.jDateChooser1.setDate(fechaDate);
    
    }
    
    
    private void mostrar(){
        DefaultTableModel m = new DefaultTableModel();
        m.setColumnCount(0);
        m.addColumn("Id_libro");
        m.addColumn("Id_autor");
        m.addColumn("Nombre");
        m.addColumn("fecha lanzamineto");
        m.addColumn("Contenido");
        m.addColumn("No. Pag.");
        
        for (tbl_libro pvo1 : pdao.consultarTabla()) {
            m.addRow(new Object[]{pvo1.getIdlibro(),pvo1.getId_autor(),pvo1.getNombre(),pvo1.getFecha(),pvo1.getContenido(),
                pvo1.getPaginas()});
        }
        vista.tbleLibro.setModel(m);
    }
    
    private boolean eliminar(){
    boolean respuesta = false;
        try {
            respuesta = pdao.eliminar(vista.tbleLibro.getValueAt(vista.tbleLibro.getSelectedRow(),0).toString());
        } catch (Exception e) {
        }
    return  respuesta;      
    }
    
    private  void llenar(){
       pvo.setLibro(Integer.parseInt(vista.tbleLibro.getValueAt(vista.tbleLibro.getSelectedRow(),0).toString()));
       pvo.setId_autor(0);
       int a =vista.jComboBox1.getSelectedIndex();
       pvo.setId_autor(lista.get(a).getId_autor());
       pvo.setNombre(vista.TxtNombre.getText());
  Date  fecha=vista.jDateChooser1.getDate();
        DateFormat f =new SimpleDateFormat("yyyy-MM-dd");
        String fecha2=f.format(fecha);
        pvo.setFecha(fecha2);
        pvo.setContenido(vista.TxtContenido.getText());
        pvo.setPaginas(Integer.parseInt(vista.TxtPag.getText()));
        
    }

      private boolean Modificar( tbl_libro p ){
    boolean respuesta = false;
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
    llenarconbo();
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
          
           a = insertarDatos();
            if (a = false) {
                vista.TxtNombre.setText("");
                vista.TxtContenido.setText("");
                 JOptionPane.showMessageDialog(null, "Se ha incertado correctamente");
            }
            
            mostrar();
 
        }
        
        if (e.getSource()==vista.BtnBorrar) {
            
             a = eliminar();
            if (a == false) {
                vista.TxtNombre.setText("");
                vista.TxtContenido.setText("");
                 JOptionPane.showMessageDialog(null, "Se ha se elimiado  correctamente");
            }
            
            mostrar();
        }
        
        if (e.getSource()==vista.BtnModificar) {
            llenar();
            a = Modificar(pvo) ;
            if (a == true) {
                vista.TxtNombre.setText("");
                vista.TxtContenido.setText("");
                 JOptionPane.showMessageDialog(null, "Se ha se elimiado  correctamente");
            }
            
            mostrar();
        }
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        try {
            seleccionar();
        } catch (ParseException ex) {
            Logger.getLogger(ControladorLibro.class.getName()).log(Level.SEVERE, null, ex);
        }
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
