package edu.cecar.controladores;

import edu.cecar.componentes.singletons.SingletonConexionBD;
import edu.cecar.modelos.Publicacion;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Clase: ControladorGestionarPublicacion
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
public class ControladorGestionarPublicacion {

    public void crearPublicacion(Publicacion publicacion) throws SQLException {
        PreparedStatement preparedStatement = SingletonConexionBD.getinstance().prepareStatement("call gestionarPublicacion(?,?,?,?,?,?,?,?,?)");
        preparedStatement.setInt(1, publicacion.getIdPublicacion());
        preparedStatement.setInt(2, publicacion.getIdUsuario());
        preparedStatement.setString(3, publicacion.getTexto());
        preparedStatement.setBytes(4, publicacion.getMultimedia());
        preparedStatement.setDate(5, publicacion.getFechapublicacion());
        preparedStatement.setString(6, publicacion.getTipopublicacion());
        preparedStatement.setInt(7, publicacion.getMegusta());
        preparedStatement.setInt(8, publicacion.getNomegusta());
        preparedStatement.setString(9, "crear");
        preparedStatement.execute();
    }

    public void eliminarPublicacion(Publicacion publicacion) {

    }

    public ArrayList<Publicacion> consultarPublicacion(int idUsuario,String operacion) throws SQLException {
        ArrayList<Publicacion> publicaciones = new ArrayList<Publicacion>();
        PreparedStatement preparedStatement = SingletonConexionBD.getinstance().prepareStatement("call buscarPublicacion(?,?)");
        preparedStatement.setInt(1, idUsuario);
        preparedStatement.setString(2, operacion);
        ResultSet result = preparedStatement.executeQuery();
        while (result.next()) {
            Publicacion publicacion = new Publicacion(result.getInt(2), result.getString(3), result.getBytes(4), result.getDate(5), result.getString(6), result.getInt(7), result.getInt(8));
            publicacion.setIdPublicacion(result.getInt(1));
            publicaciones.add(publicacion);
        }
        return publicaciones;
    }

    public void actualizarTipoPublicacion(Publicacion publicacion) throws SQLException {
        PreparedStatement preparedStatement = SingletonConexionBD.getinstance().prepareStatement("call gestionarPublicacion(?,?,?,?,?,?,?,?,?)");
        preparedStatement.setInt(1, publicacion.getIdPublicacion());
        preparedStatement.setInt(2, publicacion.getIdUsuario());
        preparedStatement.setString(3, publicacion.getTexto());
        preparedStatement.setBytes(4, publicacion.getMultimedia());
        preparedStatement.setDate(5, publicacion.getFechapublicacion());
        preparedStatement.setString(6, publicacion.getTipopublicacion());
        preparedStatement.setInt(7, publicacion.getMegusta());
        preparedStatement.setInt(8, publicacion.getNomegusta());
        preparedStatement.setString(9, "tipoPublicacion");
        preparedStatement.execute();
    }

    public void actualizarMegustasPublicacion(Publicacion publicacion) throws SQLException {
        PreparedStatement preparedStatement = SingletonConexionBD.getinstance().prepareStatement("call gestionarPublicacion(?,?,?,?,?,?,?,?,?)");
        preparedStatement.setInt(1, publicacion.getIdPublicacion());
        preparedStatement.setInt(2, publicacion.getIdUsuario());
        preparedStatement.setString(3, publicacion.getTexto());
        preparedStatement.setBytes(4, publicacion.getMultimedia());
        preparedStatement.setDate(5, publicacion.getFechapublicacion());
        preparedStatement.setString(6, publicacion.getTipopublicacion());
        preparedStatement.setInt(7, publicacion.getMegusta());
        preparedStatement.setInt(8, publicacion.getNomegusta());
        preparedStatement.setString(9, "meGustas");
        preparedStatement.execute();
    }
}
