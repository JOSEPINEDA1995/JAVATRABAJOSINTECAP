/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author mario
 */
public class LibroBd {
   String nombreli,fecha,Contenido,nombreautor,aplliedoau;
   int pag;

    public LibroBd() {
    }

    public String getNombreli() {
        return nombreli;
    }

    public void setNombreli(String nombreli) {
        this.nombreli = nombreli;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getContenido() {
        return Contenido;
    }

    public void setContenido(String Contenido) {
        this.Contenido = Contenido;
    }

    public String getNombreautor() {
        return nombreautor;
    }

    public void setNombreautor(String nombreautor) {
        this.nombreautor = nombreautor;
    }

    public String getAplliedoau() {
        return aplliedoau;
    }

    public void setAplliedoau(String aplliedoau) {
        this.aplliedoau = aplliedoau;
    }

    public int getPag() {
        return pag;
    }

    public void setPag(int pag) {
        this.pag = pag;
    }
   
}
