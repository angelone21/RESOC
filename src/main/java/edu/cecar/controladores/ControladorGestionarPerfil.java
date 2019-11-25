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
        PreparedStatement preparedStatement = SingletonConexionBD.getinstance().prepareStatement("call gestionarPerfil(?,?,?,?,?,?,?,?,?,?,?)");
        preparedStatement.setInt(1, perfil.getIdusario());
        preparedStatement.setBytes(2, perfil.getFotoPerfil());
        preparedStatement.setString(3, perfil.getPassword());
        preparedStatement.setString(4, perfil.getNombres());
        preparedStatement.setString(5, perfil.getApellidos());
        preparedStatement.setString(6, perfil.getSexo());
        preparedStatement.setDate(7, perfil.getFechanacimiento());
        preparedStatement.setString(8, perfil.getDescripcion());
        preparedStatement.setString(9, perfil.getDepartamento());
        preparedStatement.setLong(10, perfil.getCelular());
        preparedStatement.setString(11, "actualizar");
        preparedStatement.execute();

    }

    public void crearPerfil(Perfil perfil) throws SQLException {
        PreparedStatement preparedStatement = SingletonConexionBD.getinstance().prepareStatement("call gestionarPerfil(?,?,?,?,?,?,?,?,?,?,?)");
        preparedStatement.setInt(1, perfil.getIdusario());
        preparedStatement.setBytes(2, perfil.getFotoPerfil());
        preparedStatement.setString(3, perfil.getPassword());
        preparedStatement.setString(4, perfil.getNombres());
        preparedStatement.setString(5, perfil.getApellidos());
        preparedStatement.setString(6, perfil.getSexo());
        preparedStatement.setDate(7, perfil.getFechanacimiento());
        preparedStatement.setString(8, perfil.getDescripcion());
        preparedStatement.setString(9, perfil.getDepartamento());
        preparedStatement.setLong(10, perfil.getCelular());
        preparedStatement.setString(11, "crear");
        preparedStatement.execute();
    }

    public Perfil buscarPerfil(int idusuario) throws SQLException {
        Perfil perfil_result = null;
        PreparedStatement preparedStatement = SingletonConexionBD.getinstance().prepareStatement("call buscarPerfil(?)");
        preparedStatement.setInt(1, idusuario);
        ResultSet result = preparedStatement.executeQuery();
        if (result.next()) {
            perfil_result = new Perfil(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getDate(6), result.getString(7), result.getString(8), result.getLong(9));
            perfil_result.setFotoPerfil(result.getBytes(10));
        }
        return perfil_result;
    }

}
