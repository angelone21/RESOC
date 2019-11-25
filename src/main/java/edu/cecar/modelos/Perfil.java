package edu.cecar.modelos;

import java.io.Serializable;
import java.sql.Date;

/**
 * Clase: Perfil
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
public class Perfil implements Serializable{

    private int idUsuario;
    private String password;
    private String nombres;
    private String apellidos;
    private String sexo;
    private Date fechanacimiento;
    private String descripcion;
    private String departamento;
    private long celular;
    

    public Perfil() {
    }

    public Perfil(int idUsuario, String password, String nombres, String apellidos, String sexo, Date fechanacimiento, String descripcion, String departamento, long celular) {
        this.idUsuario = idUsuario;
        this.password = password;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.sexo = sexo;
        this.fechanacimiento = fechanacimiento;
        this.descripcion = descripcion;
        this.departamento = departamento;
        this.celular = celular;
    }

    public int getIdusario() {
        return idUsuario;
    }

    public void setIdusario(int idusario) {
        this.idUsuario = idusario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public long getCelular() {
        return celular;
    }

    public void setCelular(long celular) {
        this.celular = celular;
    }

    

    

}
