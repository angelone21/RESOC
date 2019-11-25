package edu.cecar.modelos;

import java.io.Serializable;
import java.sql.Date;

/**
 * Clase: SolicitudAmistad
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
public class SolicitudAmistad implements Serializable {

    private int idUsuarioEmisor;
    private int idUsuarioReceptor;
    private Date fecha;
    private String estado;

    public SolicitudAmistad() {
    }

    public SolicitudAmistad(int idUsuarioEmisor, int idUsuarioReceptor, Date fecha, String estado) {
        this.idUsuarioEmisor = idUsuarioEmisor;
        this.idUsuarioReceptor = idUsuarioReceptor;
        this.fecha = fecha;
        this.estado = estado;
    }

    public int getIdUsuarioEmisor() {
        return idUsuarioEmisor;
    }

    public int getIdUsuarioReceptor() {
        return idUsuarioReceptor;
    }

    public void setIdUsuarioEmisor(int idUsuarioEmisor) {
        this.idUsuarioEmisor = idUsuarioEmisor;
    }

    public void setIdUsuarioReceptor(int idUsuarioReceptor) {
        this.idUsuarioReceptor = idUsuarioReceptor;
    }
    
    
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
