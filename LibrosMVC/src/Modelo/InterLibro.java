/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author mario
 */
public interface InterLibro {
    
     public boolean insertar(tbl_libro p);
    public boolean actualizar(tbl_libro p);
    public boolean eliminar(String n);
    public ArrayList<tbl_libro> consultarTabla();
    
}
