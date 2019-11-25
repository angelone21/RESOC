/**
 * Clase: Cliente.java
 *
 * Version: 1.0
 *
 * Fecha creaci�n: 26/09/2018
 *
 * Ultima Fecha  Modificacion:
 *
 * Autor: Ing. Jhon Jaime Mendez Alandete
 *
 * Copyright: CECAR
 */
package edu.cecar.controladores;

/**
 * Clase cliente que permite la subida y descarga de archivo hacia y desde el
 * servidor
 *
 */
import edu.cecar.componentes.comunicaciones.SocketObjeto;
import edu.cecar.modelos.Amigo;
import edu.cecar.modelos.Perfil;
import edu.cecar.modelos.Publicacion;
import edu.cecar.modelos.SolicitudAmistad;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public final class ControladorCliente {

    static SocketObjeto socketObjeto;

    /*public ControladorCliente(String IPServidor, int puerto) {
        socketObjeto = new SocketObjeto(IPServidor, puerto);
    }*/
    public boolean conectarClienteServidor(String IPServidor, int puerto) {
        socketObjeto = new SocketObjeto(IPServidor, puerto);
        return socketObjeto.getSocket() != null;

    }

    public boolean PeticionClientePerfil(String operacion, Perfil perfil) {
        boolean respuesta = false;
        try {
            if (operacion.equals("login")) {
                socketObjeto.getSalida().writeObject(operacion);
                Object object;
                socketObjeto.getSalida().writeObject(perfil);
                object = socketObjeto.getEntrada().readObject();
                respuesta = (boolean) object;
                return respuesta;
            }
            if (operacion.equals("registro")) {
                socketObjeto.getSalida().writeObject(operacion);
                Object object;
                socketObjeto.getSalida().writeObject(perfil);
                object = socketObjeto.getEntrada().readObject();
                respuesta = (boolean) object;
                return respuesta;
            }
            if (operacion.equals("actualizarPerfil")) {
                socketObjeto.getSalida().writeObject(operacion);
                Object object;
                socketObjeto.getSalida().writeObject(perfil);
                object = socketObjeto.getEntrada().readObject();
                respuesta = (boolean) object;
                return respuesta;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            JOptionPane.showMessageDialog(null, "Se perdió la conexion con el servidor, intente nuevamente");
            System.exit(0);
        }

        return respuesta;
    }

    public boolean PeticionClienteAmigo(String operacion, Amigo amigo) {
        boolean respuesta = false;
        if (operacion.equals("estadoAmigo")) {
            try {
                socketObjeto.getSalida().writeObject(operacion);
                Object object;
                socketObjeto.getSalida().writeObject(amigo);
                object = socketObjeto.getEntrada().readObject();
                respuesta = (boolean) object;
                return respuesta;
            } catch (Exception ex) {
                Logger.getLogger(ControladorCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (operacion.equals("agregar")) {
            try {
                socketObjeto.getSalida().writeObject(operacion);
                Object object;
                socketObjeto.getSalida().writeObject(amigo);
                object = socketObjeto.getEntrada().readObject();
                respuesta = (boolean) object;
                return respuesta;
            } catch (Exception ex) {
                Logger.getLogger(ControladorCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return respuesta;
    }

    public boolean PeticionClientePublicacion(String operacion, Publicacion publicacion) {
        boolean respuesta = false;
        if (operacion.equals("tipoPublicacion")) {
            try {
                socketObjeto.getSalida().writeObject(operacion);
                Object object;
                socketObjeto.getSalida().writeObject(publicacion);
                object = socketObjeto.getEntrada().readObject();
                respuesta = (boolean) object;
                return respuesta;
            } catch (Exception ex) {
                Logger.getLogger(ControladorCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (operacion.equals("meGustas")) {
            try {
                socketObjeto.getSalida().writeObject(operacion);
                Object object;
                socketObjeto.getSalida().writeObject(publicacion);
                object = socketObjeto.getEntrada().readObject();
                respuesta = (boolean) object;
                return respuesta;
            } catch (Exception ex) {
                Logger.getLogger(ControladorCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (operacion.equals("crearPublicacion")) {
            try {
                socketObjeto.getSalida().writeObject(operacion);
                Object object;
                socketObjeto.getSalida().writeObject(publicacion);
                object = socketObjeto.getEntrada().readObject();
                respuesta = (boolean) object;
                return respuesta;
            } catch (Exception ex) {
                Logger.getLogger(ControladorCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return respuesta;
    }

    public boolean PeticionClienteSolicitud(String operacion, SolicitudAmistad solicitud) {
        boolean respuesta = false;
        if (operacion.equals("estadoSolicitud")) {
            try {
                socketObjeto.getSalida().writeObject(operacion);
                Object object;
                socketObjeto.getSalida().writeObject(solicitud);
                object = socketObjeto.getEntrada().readObject();
                respuesta = (boolean) object;
                return respuesta;
            } catch (Exception ex) {
                Logger.getLogger(ControladorCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (operacion.equals("enviarSolicitud")) {
            try {
                socketObjeto.getSalida().writeObject(operacion);
                Object object;
                socketObjeto.getSalida().writeObject(solicitud);
                object = socketObjeto.getEntrada().readObject();
                respuesta = (boolean) object;
                return respuesta;
            } catch (Exception ex) {
                Logger.getLogger(ControladorCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return respuesta;
    }

    public Perfil obtenerPerfil(int idUsuario) {
        Perfil perfil = null;
        try {
            socketObjeto.getSalida().writeObject("buscarPerfil");
            socketObjeto.getSalida().writeObject(idUsuario);
            Object object;
            object = socketObjeto.getEntrada().readObject();
            perfil = (Perfil) object;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Se perdió la conexion con el servidor, intente nuevamente");
            System.exit(0);
        }
        return perfil;
    }

    public ArrayList<Amigo> obtenerAmigos(int idUsuario) {
        ArrayList<Amigo> amigos = new ArrayList<Amigo>();
        try {
            socketObjeto.getSalida().writeObject("buscarAmigos");
            socketObjeto.getSalida().writeObject(idUsuario);
            Object object;
            object = socketObjeto.getEntrada().readObject();
            amigos = (ArrayList<Amigo>) object;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Se perdió la conexion con el servidor, intente nuevamente");
            System.exit(0);
        }

        return amigos;
    }

    public ArrayList<Publicacion> obtenerPublicaciones(int idUsuario) {
        ArrayList<Publicacion> publicaciones = new ArrayList<Publicacion>();
        try {
            socketObjeto.getSalida().writeObject("buscarPublicacionUsuario");
            socketObjeto.getSalida().writeObject(idUsuario);
            Object object;
            object = socketObjeto.getEntrada().readObject();
            publicaciones = (ArrayList<Publicacion>) object;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Se perdió la conexion con el servidor, intente nuevamente");
            System.exit(0);
        }
        return publicaciones;
    }

    public ArrayList<Publicacion> obtenerPublicacionesAmigos(int idUsuario) {
        ArrayList<Publicacion> publicaciones = new ArrayList<Publicacion>();
        try {
            socketObjeto.getSalida().writeObject("buscarPublicacionAmigos");
            socketObjeto.getSalida().writeObject(idUsuario);
            Object object;
            object = socketObjeto.getEntrada().readObject();
            publicaciones = (ArrayList<Publicacion>) object;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Se perdió la conexion con el servidor, intente nuevamente");
            System.exit(0);
        }
        return publicaciones;
    }

    public ArrayList<SolicitudAmistad> obtenerSolicitudes(int idUsuario) {
        ArrayList<SolicitudAmistad> solicitudes = new ArrayList<SolicitudAmistad>();
        try {
            socketObjeto.getSalida().writeObject("listarSolicitudes");
            socketObjeto.getSalida().writeObject(idUsuario);
            Object object;
            object = socketObjeto.getEntrada().readObject();
            solicitudes = (ArrayList<SolicitudAmistad>) object;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Se perdió la conexion con el servidor, intente nuevamente");
            System.exit(0);
        }
        return solicitudes;
    }

}
