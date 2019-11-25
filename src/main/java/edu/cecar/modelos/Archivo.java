/**
 * Clase: Archivo.java
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
package edu.cecar.modelos;

import java.io.Serializable;

/**
 * Clase que especifica el objeto remoto que se utilizara para las actividades
 * de subida y descarga de archivos
 *
 */
public class Archivo implements Serializable {

    private static final long serialVersionUID = 1000L;
    private String nombre;
    private byte[] bytes;
    private String Operacion;

    public Archivo(String nombre, String operacion) {
        this.nombre = nombre;
        this.Operacion = operacion;
    }

    public Archivo(String nombre, byte[] bytes, String operacion) {

        this.nombre = nombre;
        this.bytes = bytes;
        Operacion = operacion;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public String getNombre() {
        return nombre;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public String getOperacion() {
        return Operacion;
    }

}
