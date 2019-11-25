package edu.cecar.controladores;

import edu.cecar.componentes.singletons.SingletonConexionBD;
import edu.cecar.modelos.Amigo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Clase: ControladorAmigo
 *
 * @version: 0.1
 *
 * @since: Nov 23, 2019
 *
 * Fecha de Modificación:
 *
 * @author: Vincenzo Angelone
 *
 * Copyrigth: CECAR
 */
public class ControladorAmigo {

    public ArrayList<Amigo> buscarAmigos(int idUsuario) throws SQLException {
        ArrayList<Amigo> resultado = new ArrayList<Amigo>();
        PreparedStatement preparedStatement = SingletonConexionBD.getinstance().prepareStatement("call gestionarAmigos(?,?,?,?)");
        preparedStatement.setInt(1, idUsuario);
        preparedStatement.setInt(2, idUsuario);
        preparedStatement.setString(3, "Activo");
        preparedStatement.setString(4, "buscar");
        ResultSet result = preparedStatement.executeQuery();
        while (result.next()) {
            Amigo amigo = new Amigo(idUsuario, result.getInt(2), result.getString(3));
            resultado.add(amigo);
        }
        return resultado;
    }

    public void actualizarEstado(Amigo amigo, String operacion) throws SQLException {
        PreparedStatement preparedStatement = SingletonConexionBD.getinstance().prepareStatement("call gestionarAmigos(?,?,?,?)");
        preparedStatement.setInt(1, amigo.getIdperfil());
        preparedStatement.setInt(2, amigo.getIdperfilAmigo());
        preparedStatement.setString(3, amigo.getEstado());
        preparedStatement.setString(4, operacion);
        preparedStatement.execute();
    }

    public void agregarAmigo(Amigo amigo, String operacion) throws SQLException {
        PreparedStatement preparedStatement = SingletonConexionBD.getinstance().prepareStatement("call gestionarAmigos(?,?,?,?)");
        preparedStatement.setInt(1, amigo.getIdperfil());
        preparedStatement.setInt(2, amigo.getIdperfilAmigo());
        preparedStatement.setString(3, amigo.getEstado());
        preparedStatement.setString(4, "agregar");
        preparedStatement.execute();
    }

}
