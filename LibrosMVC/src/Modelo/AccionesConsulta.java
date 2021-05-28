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
public class AccionesConsulta {
   Conexion c = new Conexion();
    public AccionesConsulta() {
    }

    
    
    public ArrayList<LibroBd> consultarTabla() {
    
        ArrayList<LibroBd> info = new ArrayList<>();
        try {
            c.conectar();
            String consulta = "SELECT tbl_libro.nombre ,tbl_libro.fecha_Lansamineto ,tbl_libro.contenido ,tbl_libro.paginas ,tbl_autor.nombre ,tbl_autor.apellido  "
                    + " FROM  tbl_libro INNER JOIN tbl_autor ON tbl_autor.id_autor = tbl_libro.id_autor;";
            ResultSet rs = c.consulta_datos(consulta);
            while(rs.next()){
                
                LibroBd pvo = new LibroBd( );
                pvo.setNombreli(rs.getString(1));
                pvo.setFecha(rs.getString(2));
                pvo.setContenido(rs.getString(3));
                pvo.setPag(rs.getInt(4));
                pvo.setNombreautor(rs.getString(5));
                pvo.setAplliedoau(rs.getString(6));
                info.add(pvo);
            }
            c.desconectar();
        } catch (Exception e) {
            System.err.println("Mensaje Mostrar Datos "+e.getMessage());
        }
        return info;
    }
}
