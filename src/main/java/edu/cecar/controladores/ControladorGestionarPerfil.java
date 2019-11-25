package edu.cecar.controladores;

import edu.cecar.componentes.singletons.SingletonConexionBD;
import edu.cecar.modelos.Perfil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Clase: ControladorGestionarPerfil
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
public class ControladorGestionarPerfil {

    public void eliminarPerfil(Perfil perfil) {

    }

    public void actualizarPerfil(Perfil perfil) throws SQLException {
        PreparedStatement preparedStatement = SingletonConexionBD.getinstance().prepareStatement("call gestionarPerfil(?,?,?,?,?,?,?,?,?,?)");
        preparedStatement.setInt(1, perfil.getIdusario());
        preparedStatement.setString(2, perfil.getPassword());
        preparedStatement.setString(3, perfil.getNombres());
        preparedStatement.setString(4, perfil.getApellidos());
        preparedStatement.setString(5, perfil.getSexo());
        preparedStatement.setDate(6, perfil.getFechanacimiento());
        preparedStatement.setString(7, perfil.getDescripcion());
        preparedStatement.setString(8, perfil.getDepartamento());
        preparedStatement.setLong(9, perfil.getCelular());
        preparedStatement.setString(10, "actualizar");
        preparedStatement.execute();
        
    }

    public void crearPerfil(Perfil perfil) throws SQLException {
        PreparedStatement preparedStatement = SingletonConexionBD.getinstance().prepareStatement("call gestionarPerfil(?,?,?,?,?,?,?,?,?,?)");
        preparedStatement.setInt(1, perfil.getIdusario());
        preparedStatement.setString(2, perfil.getPassword());
        preparedStatement.setString(3, perfil.getNombres());
        preparedStatement.setString(4, perfil.getApellidos());
        preparedStatement.setString(5, perfil.getSexo());
        preparedStatement.setDate(6, perfil.getFechanacimiento());
        preparedStatement.setString(7, perfil.getDescripcion());
        preparedStatement.setString(8, perfil.getDepartamento());
        preparedStatement.setLong(9, perfil.getCelular());
        preparedStatement.setString(10, "crear");
        preparedStatement.execute();
    }

    public Perfil buscarPerfil(int idusuario) throws SQLException {
        Perfil perfil_result = null;
        PreparedStatement preparedStatement = SingletonConexionBD.getinstance().prepareStatement("call buscarPerfil(?)");
        preparedStatement.setInt(1, idusuario);
        ResultSet result = preparedStatement.executeQuery();
        if (result.next()) {
            perfil_result = new Perfil(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getDate(6), result.getString(7), result.getString(8), result.getLong(9));
        }
        return perfil_result;
    }

}
