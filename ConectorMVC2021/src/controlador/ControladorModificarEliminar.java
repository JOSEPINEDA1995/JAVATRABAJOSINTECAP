
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import modelo.PaisDAO;
import modelo.PaisVO;
import vista.Frm_BorrarModificar;
import vista.Frm_Mostrar;


public class ControladorModificarEliminar implements WindowListener,ActionListener,MouseListener {
    
    Frm_BorrarModificar vista = new Frm_BorrarModificar();
    PaisVO pvo = new PaisVO();
    PaisDAO pdao = new PaisDAO();

    public ControladorModificarEliminar(Frm_BorrarModificar vista, PaisVO pvo, PaisDAO pdao) {
        this.vista = vista;
        this.pvo = pvo;
        this.pdao = pdao;
       this.vista.BtnBorrar.addActionListener(this);
       this.vista.BtnModificar.addActionListener(this);
       this.vista.MOSTRAR.addActionListener(this);
       this.vista.addMouseListener(this);
       this.vista.tbleElim.addMouseListener(this);
       this.vista.addWindowListener(this);
    }
    
    private void seleccionar(){
    vista.TxtCod.setText(vista.tbleElim.getValueAt(vista.tbleElim.getSelectedRow(),0).toString());
    vista.TxtNombre.setText(vista.tbleElim.getValueAt(vista.tbleElim.getSelectedRow(),1).toString());
    vista.TxtCapital.setText(vista.tbleElim.getValueAt(vista.tbleElim.getSelectedRow(),2).toString());
    vista.TxtPoblacion.setText(vista.tbleElim.getValueAt(vista.tbleElim.getSelectedRow(),3).toString());
    }
    private void mostrar(){
        DefaultTableModel m = new DefaultTableModel();
        m.setColumnCount(0);
        m.addColumn("Id");
        m.addColumn("Nombre del País");
        m.addColumn("Capital del País");
        m.addColumn("Población");
        
        for (PaisVO pvo : pdao.consultarTabla()) {
            m.addRow(new Object[]{pvo.getId_pais(),pvo.getNombre_pais(),
                pvo.getCapital_pais(),pvo.getPoblacion_pais()});
        }
        vista.tbleElim.setModel(m);
    }
    
    private boolean eliminar(){
    boolean respuesta = false;
        try {
            respuesta = pdao.eliminar(vista.TxtCod.getText());
        } catch (Exception e) {
        }
    return  respuesta;      
    }
    
    private  void llenar(){
      this.pvo.setId_pais(Integer.parseInt(this.vista.TxtCod.getText()));
      this.pvo.setNombre_pais(this.vista.TxtNombre.getText());
      this.pvo.setCapital_pais(this.vista.TxtCapital.getText());
      this.pvo.setPoblacion_pais(Integer.parseInt(this.vista.TxtPoblacion.getText()));    
        
    }

      private boolean Modificar( PaisVO p ){
    boolean respuesta = false;
          
          p.setId_pais( Integer.parseInt(vista.TxtCod.getText()));
          p.setNombre_pais(vista.TxtNombre.getText());
          p.setCapital_pais(vista.TxtCapital.getText());
          p.setPoblacion_pais(Integer.parseInt(vista.TxtPoblacion.getText()));
        try {
            respuesta = pdao.actualizar(p);
        } catch (Exception e) {
        }
    return  respuesta;      
    }
      
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== vista.MOSTRAR){
        mostrar();
        }
        if (e.getSource()== vista.BtnBorrar){
        boolean a;
        a = eliminar();
        if(a==false){
        JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente");
        mostrar();
        }
        }
        if (e.getSource()== vista.BtnModificar){
        boolean a;
        llenar();
        a = Modificar(this.pvo);
        if(a==false){
        JOptionPane.showMessageDialog(null, "Se ha Modificado correctamente");
        mostrar();
        }
        }
        
        
        
    }

    
    
    
    //windows----------------------------------------------------------------------------
    @Override
    public void windowOpened(WindowEvent e) {
      this.mostrar();
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
    this.mostrar();
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

   //Mouse----------------------------------------------------------------------------------------------------------
   
    @Override
    public void mouseClicked(MouseEvent e) {
     seleccionar();
     llenar();
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
