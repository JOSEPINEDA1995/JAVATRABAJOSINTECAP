/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author mario
 */
public class AccionesLibro implements InterLibro{
Conexion c= new Conexion();
    @Override
    public boolean insertar(tbl_libro p) {
              boolean respuesta = false;
        try {
            c.conectar();
         String consulta = "INSERT INTO tbl_libro(id_autor,nombre,fecha_Lansamineto,contenido,paginas) VALUES("+p.getId_autor()+",'"+p.getNombre()+"','"+p.getFecha()+"','"+p.getContenido()+"',"+p.getPaginas()+");";
        respuesta= c.Insertarconsultar(consulta);
         respuesta= true;   
        } catch (Exception e) {
            System.err.println("Mensaje Insertar "+e.getMessage());
        }
        c.desconectar();
  return respuesta; 
     }

    @Override
    public boolean actualizar(tbl_libro p) {
        boolean respuesta=false;
               try {
            c.conectar();
            String consulta="UPDATE tbl_libro SET id_autor="+p.getId_autor()+",nombre ='"+p.getNombre()+"', "
                    + "fecha_Lansamineto='"+p.getFecha()+"', contenido='"+p.getContenido()+"' ,paginas="+p.getPaginas()+" WHERE id_libro ="+p.getIdlibro()+"";
            respuesta = c.Insertarconsultar(consulta);
        } catch (Exception e) {
                   System.out.println(e);
        }
    return respuesta;
            }

    @Override
    public boolean eliminar(String n) {
      boolean respuesta=false;
               try {
            c.conectar();
            String consulta="delete from tbl_libro where id_libro="+n+"";
            respuesta = c.Insertarconsultar(consulta);
        } catch (Exception e) {
                   System.out.println(e);
        }
    return respuesta;
    }

    @Override
    public ArrayList<tbl_libro> consultarTabla() {
        
        ArrayList<tbl_libro> info = new ArrayList<tbl_libro>();
        try {
            c.conectar();
            String consulta = "select * from tbl_Libro;";
            ResultSet rs = c.consulta_datos(consulta);
            while(rs.next()){
                tbl_libro pvo = new tbl_libro();
                
                pvo.setLibro(rs.getInt(1));
                pvo.setId_autor(rs.getInt(2));
                pvo.setNombre(rs.getString(3));
                pvo.setFecha(rs.getString(4));
                pvo.setContenido(rs.getString(5));
                pvo.setPaginas(rs.getInt(6));   
                info.add(pvo);
            }
            c.desconectar();
        } catch (Exception e) {
            System.err.println("Mensaje Mostrar Datos "+e.getMessage());
        }
        return info;
        
     }
    
}
