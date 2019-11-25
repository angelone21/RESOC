/**
 * Clase: ServidorArchivo.java
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
 * Servidor que permite la subida y descarga de archivos desde y hacia los
 * clientes
 */
import java.io.IOException;

import edu.cecar.componentes.comunicaciones.ServerSocketObjeto;
import edu.cecar.modelos.Amigo;
import edu.cecar.modelos.Perfil;
import edu.cecar.modelos.Publicacion;
import edu.cecar.modelos.SolicitudAmistad;
import java.sql.SQLException;
import java.util.ArrayList;

public final class ControladorServidor {

    private String ruta = "ArchivosCompartidos/";

    public ControladorServidor(int puerto) {

        ControladorLogin controladorLogin = new ControladorLogin();
        ControladorGestionarPerfil controladorPerfil = new ControladorGestionarPerfil();
        ControladorAmigo controladorAmigo = new ControladorAmigo();
        ControladorGestionarPublicacion controladorGestionarPublicacion = new ControladorGestionarPublicacion();
        ControladorSolicitud controladorSolicitud = new ControladorSolicitud();
        Perfil perfil;
        String operacion;
        System.out.println("Servidor Montado");
        ServerSocketObjeto serverSocket = new ServerSocketObjeto(puerto);
        boolean sw = true;
        while (sw) {
            try {
                Object objeto = serverSocket.getEntrada().readObject();
                operacion = (String) objeto;
                if (operacion.equals("login")) {
                    Object object = serverSocket.getEntrada().readObject();
                    perfil = (Perfil) object;
                    if (controladorLogin.autenticarEntradaSistema(perfil.getIdusario(), perfil.getPassword()) == 1) {
                        Object prueba = true;
                        serverSocket.getSalida().writeObject(prueba);
                    } else {
                        Object prueba = false;
                        serverSocket.getSalida().writeObject(prueba);
                    }
                }
                if (operacion.equals("registro")) {
                    Object object = serverSocket.getEntrada().readObject();
                    perfil = (Perfil) object;
                    try {
                        controladorPerfil.crearPerfil(perfil);
                        Object prueba = true;
                        serverSocket.getSalida().writeObject(prueba);
                    } catch (SQLException e) {
                        e.printStackTrace();
                        Object prueba = false;
                        serverSocket.getSalida().writeObject(prueba);
                    }
                }
                if (operacion.equals("buscarPerfil")) {
                    Perfil perfil_resultado;
                    Object object = serverSocket.getEntrada().readObject();
                    int idUsuario = (int) object;
                    perfil_resultado = controladorPerfil.buscarPerfil(idUsuario);
                    serverSocket.getSalida().writeObject(perfil_resultado);
                }
                if (operacion.equals("actualizarPerfil")) {
                    Perfil perfil_actualizar;
                    Object object = serverSocket.getEntrada().readObject();
                    perfil_actualizar = (Perfil) object;
                    try {
                        controladorPerfil.actualizarPerfil(perfil_actualizar);
                        Object prueba = true;
                        serverSocket.getSalida().writeObject(prueba);
                    } catch (SQLException e) {
                        e.printStackTrace();
                        Object prueba = false;
                        serverSocket.getSalida().writeObject(prueba);
                    }
                }
                if (operacion.equals("buscarAmigos")) {
                    ArrayList<Amigo> amigos = new ArrayList<Amigo>();
                    Object object = serverSocket.getEntrada().readObject();
                    int idUsuario = (int) object;
                    amigos = controladorAmigo.buscarAmigos(idUsuario);
                    serverSocket.getSalida().writeObject(amigos);
                }
                if (operacion.equals("estadoAmigo")) {
                    Amigo amigo_actualizar;
                    Object object = serverSocket.getEntrada().readObject();
                    amigo_actualizar = (Amigo) object;
                    controladorAmigo.actualizarEstado(amigo_actualizar, "estado");
                    Object prueba = true;
                    serverSocket.getSalida().writeObject(prueba);
                }
                if (operacion.equals("buscarPublicacionUsuario")) {
                    ArrayList<Publicacion> publicaciones = new ArrayList<Publicacion>();
                    Object object = serverSocket.getEntrada().readObject();
                    int idUsuario = (int) object;
                    publicaciones = controladorGestionarPublicacion.consultarPublicacion(idUsuario, "usuario");
                    serverSocket.getSalida().writeObject(publicaciones);
                }
                if (operacion.equals("buscarPublicacionAmigos")) {
                    ArrayList<Publicacion> publicaciones = new ArrayList<Publicacion>();
                    Object object = serverSocket.getEntrada().readObject();
                    int idUsuario = (int) object;
                    publicaciones = controladorGestionarPublicacion.consultarPublicacion(idUsuario, "amigo");
                    serverSocket.getSalida().writeObject(publicaciones);
                }
                if (operacion.equals("tipoPublicacion")) {
                    Publicacion publicacion_actualizar;
                    Object object = serverSocket.getEntrada().readObject();
                    publicacion_actualizar = (Publicacion) object;
                    controladorGestionarPublicacion.actualizarTipoPublicacion(publicacion_actualizar);
                    Object prueba = true;
                    serverSocket.getSalida().writeObject(prueba);
                }
                if (operacion.equals("meGustas")) {
                    Publicacion publicacion_actualizar;
                    Object object = serverSocket.getEntrada().readObject();
                    publicacion_actualizar = (Publicacion) object;
                    controladorGestionarPublicacion.actualizarMegustasPublicacion(publicacion_actualizar);
                    Object prueba = true;
                    serverSocket.getSalida().writeObject(prueba);
                }
                if (operacion.equals("crearPublicacion")) {
                    Object object = serverSocket.getEntrada().readObject();
                    Publicacion publicacion;
                    publicacion = (Publicacion) object;
                    try {
                        controladorGestionarPublicacion.crearPublicacion(publicacion);
                        Object prueba = true;
                        serverSocket.getSalida().writeObject(prueba);
                    } catch (SQLException e) {
                        e.printStackTrace();
                        Object prueba = false;
                        serverSocket.getSalida().writeObject(prueba);
                    }
                }
                if (operacion.equals("listarSolicitudes")) {
                    ArrayList<SolicitudAmistad> solicitudes = new ArrayList<SolicitudAmistad>();
                    Object object = serverSocket.getEntrada().readObject();
                    int idUsuario = (int) object;
                    solicitudes = controladorSolicitud.listarSolicitudes(idUsuario);
                    serverSocket.getSalida().writeObject(solicitudes);
                }
                if (operacion.equals("estadoSolicitud")) {
                    SolicitudAmistad solicitud_actualizar;
                    Object object = serverSocket.getEntrada().readObject();
                    solicitud_actualizar = (SolicitudAmistad) object;
                    if (solicitud_actualizar.getEstado().equals("Aceptada")) {
                        controladorSolicitud.actualizarEstadoSolicitud(solicitud_actualizar);
                        Amigo amigo = new Amigo(solicitud_actualizar.getIdUsuarioEmisor(), solicitud_actualizar.getIdUsuarioReceptor(), "Activo");
                        controladorAmigo.agregarAmigo(amigo, "agregar");
                        Object prueba = true;
                        serverSocket.getSalida().writeObject(prueba);
                    } else {
                        controladorSolicitud.actualizarEstadoSolicitud(solicitud_actualizar);
                        Object prueba = false;
                        serverSocket.getSalida().writeObject(prueba);
                    }
                }
                if (operacion.equals("enviarSolicitud")) {
                    SolicitudAmistad solicitud;
                    Object object = serverSocket.getEntrada().readObject();
                    solicitud = (SolicitudAmistad) object;
                    controladorSolicitud.enviarSolicitud(solicitud);
                    Object prueba = true;
                    serverSocket.getSalida().writeObject(prueba);
                }
                if (operacion.equals("eliminarPublicacion")) {
                    Object object = serverSocket.getEntrada().readObject();
                    Publicacion publicacion;
                    publicacion = (Publicacion) object;
                    try {
                        controladorGestionarPublicacion.eliminarPublicacion(publicacion);
                        Object prueba = true;
                        serverSocket.getSalida().writeObject(prueba);
                    } catch (SQLException e) {
                        e.printStackTrace();
                        Object prueba = false;
                        serverSocket.getSalida().writeObject(prueba);
                    }
                }
            } catch (IOException e) {

                System.out.println("Conexi�n cerrada de manera inesperada. " + e);
                sw = false;

            } catch (ClassNotFoundException e) {

                e.printStackTrace();

            } catch (Exception e) {

                e.printStackTrace();
            }

        }

    }

}
