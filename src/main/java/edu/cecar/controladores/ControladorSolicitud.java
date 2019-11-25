package edu.cecar.controladores;

import edu.cecar.componentes.singletons.SingletonConexionBD;
import edu.cecar.modelos.Publicacion;
import edu.cecar.modelos.SolicitudAmistad;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Clase: ControladorSolicitud
 *
 * @version: 0.1
 *
 * @since: Nov 24, 2019
 *
 * Fecha de Modificación:
 *
 * @author: Vincenzo Angelone
 *
 * Copyrigth: CECAR
 */
public class ControladorSolicitud {

    public ArrayList<SolicitudAmistad> listarSolicitudes(int idUsuario) throws SQLException {
        ArrayList<SolicitudAmistad> solicitudes = new ArrayList<SolicitudAmistad>();
        PreparedStatement preparedStatement = SingletonConexionBD.getinstance().prepareStatement("call listarSolicitudes(?)");
        preparedStatement.setInt(1, idUsuario);
        ResultSet result = preparedStatement.executeQuery();
        while (result.next()) {
            SolicitudAmistad solicitud = new SolicitudAmistad(result.getInt(1), result.getInt(2), result.getDate(3), result.getString(4));
            solicitudes.add(solicitud);
        }
        return solicitudes;
    }

    public void actualizarEstadoSolicitud(SolicitudAmistad solicitud) throws SQLException {
        PreparedStatement preparedStatement = SingletonConexionBD.getinstance().prepareStatement("call gestionarSolicitudes(?,?,?,?,?)");
        preparedStatement.setInt(1, solicitud.getIdUsuarioEmisor());
        preparedStatement.setInt(2, solicitud.getIdUsuarioReceptor());
        preparedStatement.setDate(3, solicitud.getFecha());
        preparedStatement.setString(4, solicitud.getEstado());
        preparedStatement.setString(5, "estado");
        preparedStatement.execute();
    }

    public void enviarSolicitud(SolicitudAmistad solicitud) throws SQLException {
        PreparedStatement preparedStatement = SingletonConexionBD.getinstance().prepareStatement("call gestionarSolicitudes(?,?,?,?,?)");
        preparedStatement.setInt(1, solicitud.getIdUsuarioEmisor());
        preparedStatement.setInt(2, solicitud.getIdUsuarioReceptor());
        preparedStatement.setDate(3, solicitud.getFecha());
        preparedStatement.setString(4, solicitud.getEstado());
        preparedStatement.setString(5, "enviar");
        preparedStatement.execute();

    }

}
