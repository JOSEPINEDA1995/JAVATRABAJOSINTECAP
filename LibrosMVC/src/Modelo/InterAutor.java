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
public interface InterAutor {
    
     public boolean insertar(tbl_autor p);
    public boolean actualizar(tbl_autor p);
    public boolean eliminar(String n);
    public ArrayList<tbl_autor> consultarTabla();
    
}
