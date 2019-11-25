
package edu.cecar.modelos;

import java.io.Serializable;

/**
 * Clase: Amigo
 * 
 * @version: 0.1
 *  
 * @since: Nov 15, 2019
 * 
 * Fecha de Modificación:
 * 
 * @author: Vincenzo Angelone
 * 
 * Copyrigth: CECAR
 */
public class Amigo implements Serializable{

    private int idusuario;
    private int idusuarioamigo;
    private String estado;

    public Amigo() {
    }

    public Amigo(int idperfil, int idperfilAmigo, String estado) {
        this.idusuario = idperfil;
        this.idusuarioamigo = idperfilAmigo;
        this.estado = estado;
    }

    public int getIdperfil() {
        return idusuario;
    }

    public void setIdperfil(int idperfil) {
        this.idusuario = idperfil;
    }

    public int getIdperfilAmigo() {
        return idusuarioamigo;
    }

    public void setIdperfilAmigo(int idperfilAmigo) {
        this.idusuarioamigo = idperfilAmigo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}
