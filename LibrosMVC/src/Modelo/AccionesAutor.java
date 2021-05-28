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
public class AccionesAutor implements InterAutor{
Conexion c = new Conexion();
    @Override
    public boolean  insertar(tbl_autor p) {
      boolean respuesta = false;
        try {
            c.conectar();
            String consulta = "INSERT INTO tbl_autor (nombre, apellido) "
            + "VALUES ( '"+p.getNombre()+"','"+p.getApellido()+"')";
         c.consultas_multiples(consulta);
         respuesta= true;   
        } catch (Exception e) {
            System.err.println("Mensaje Insertar "+e.getMessage());
        }
        c.desconectar();
  return respuesta; 
    }

    @Override
    public boolean actualizar(tbl_autor p) {
         boolean respuesta=false;
               try {
            c.conectar();
            String consulta="UPDATE tbl_autor SET nombre='"+p.getNombre()+"',apellido='"+p.getApellido()+"' WHERE id_autor="+p.getId_autor()+" ";
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
            String consulta="delete from tbl_autor where id_autor="+n+"";
            respuesta = c.Insertarconsultar(consulta);
        } catch (Exception e) {
                   System.out.println(e);
        }
    return respuesta;

    }

    @Override
    public ArrayList<tbl_autor> consultarTabla() {
    
        ArrayList<tbl_autor> info = new ArrayList<>();
        try {
            c.conectar();
            String consulta = "SELECT * FROM tbl_autor;";
            ResultSet rs = c.consulta_datos(consulta);
            while(rs.next()){
                tbl_autor pvo = new tbl_autor( rs.getInt(1),rs.getString(2), rs.getString(3));
                info.add(pvo);
            }
            c.desconectar();
        } catch (Exception e) {
            System.err.println("Mensaje Mostrar Datos "+e.getMessage());
        }
        return info;
    }
    
}
