/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Jonathan Pimentel
 */
public interface ConsultasDAO {
    public void insertar(PaisVO p);
    public boolean actualizar(PaisVO p);
    public boolean eliminar(String p);
    public ArrayList<PaisVO> consultarTabla();
}
