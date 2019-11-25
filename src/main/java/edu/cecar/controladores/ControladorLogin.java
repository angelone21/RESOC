package edu.cecar.controladores;

import edu.cecar.componentes.singletons.SingletonConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Clase: ControladorLogin
 *
 * @version: 0.1
 *
 * @since: Nov 17, 2019
 *
 * Fecha de Modificación:
 *
 * @author: Vincenzo Angelone
 *
 * Copyrigth: CECAR
 */
public class ControladorLogin {

    public int autenticarEntradaSistema(int idUsuario, String password) throws SQLException {
        int respuesta = 0;
        PreparedStatement preparedStatement = SingletonConexionBD.getinstance().prepareStatement("call autenticarEntradaSistema(?,?)");
        preparedStatement.setInt(1, idUsuario);
        preparedStatement.setString(2, password);
        ResultSet result = preparedStatement.executeQuery();
        if (result.next()) {
            respuesta = result.getInt(1);
        }
        return respuesta;
    }

}
