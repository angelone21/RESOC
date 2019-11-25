package edu.cecar.modelos;

import java.io.Serializable;
import java.sql.Date;

/**
 * Clase: Chat
 *
 * @version: 0.1
 *
 * @since: Oct 30, 2019
 *
 * Fecha de Modificación:
 *
 * @author: Vincenzo Angelone
 *
 * Copyrigth: CECAR
 */
public class Chat implements Serializable {

    private String texto;
    private String idUsuarioEmisor;
    private String idUsuarioReceptor;
    private Date fechaChat;

    public Chat() {
    }

    public Chat(String texto, String idPerfilEmisor, String idPerfilReceptor, Date fechaChat) {
        this.texto = texto;
        this.idUsuarioEmisor = idPerfilEmisor;
        this.idUsuarioReceptor = idPerfilReceptor;
        this.fechaChat = fechaChat;
    }

    public Date getFechaChat() {
        return fechaChat;
    }

    public void setFechaChat(Date fechaChat) {
        this.fechaChat = fechaChat;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getIdPerfilEmisor() {
        return idUsuarioEmisor;
    }

    public void setIdPerfilEmisor(String idPerfilEmisor) {
        this.idUsuarioEmisor = idPerfilEmisor;
    }

    public String getIdPerfilReceptor() {
        return idUsuarioReceptor;
    }

    public void setIdPerfilReceptor(String idPerfilReceptor) {
        this.idUsuarioReceptor = idPerfilReceptor;
    }

}
