package edu.cecar.modelos;

import java.io.Serializable;
import java.sql.Date;

/**
 * Clase: Publicacion
 *
 * @version: 0.1
 *
 * @since: 24/10/2019
 *
 * Fecha de Modificación:
 *
 * @author: Vincenzo Angelone
 *
 * Copyrigth: CECAR
 */
public class Publicacion implements Serializable {

    private int idPublicacion;
    private int idUsuario;
    private String texto;
    private byte[] multimedia;
    private Date fechapublicacion;
    private String tipopublicacion;
    private int megusta;
    private int nomegusta;

    public Publicacion() {
    }

    public Publicacion(int idperfil, String texto, byte[] multimedia, Date fechapublicacion, String tipopublicacion, int megusta, int nomegusta) {
        this.idUsuario = idperfil;
        this.texto = texto;
        this.multimedia = multimedia;
        this.fechapublicacion = fechapublicacion;
        this.tipopublicacion = tipopublicacion;
        this.megusta = megusta;
        this.nomegusta = nomegusta;
    }

    public void setIdPublicacion(int idPublicacion) {
        this.idPublicacion = idPublicacion;
    }

    public int getIdPublicacion() {
        return idPublicacion;
    }
    
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public byte[] getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(byte[] multimedia) {
        this.multimedia = multimedia;
    }

    public Date getFechapublicacion() {
        return fechapublicacion;
    }

    public void setFechapublicacion(Date fechapublicacion) {
        this.fechapublicacion = fechapublicacion;
    }

    public String getTipopublicacion() {
        return tipopublicacion;
    }

    public void setTipopublicacion(String tipopublicacion) {
        this.tipopublicacion = tipopublicacion;
    }

    public int getMegusta() {
        return megusta;
    }

    public void setMegusta(int megusta) {
        this.megusta = megusta;
    }

    public int getNomegusta() {
        return nomegusta;
    }

    public void setNomegusta(int nomegusta) {
        this.nomegusta = nomegusta;
    }

}
