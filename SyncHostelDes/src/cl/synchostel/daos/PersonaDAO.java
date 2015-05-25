package cl.synchostel.daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;

import javax.sql.DataSource;

public class PersonaDAO {
	
	private DataSource synchostelDS;
	private Connection dbConeccion;
	
	
	public HashMap<String, Object> login(String run, String password){
	
    	CallableStatement cStmt = null;
    	HashMap<String, Object> datosLogin = new HashMap<String,Object>();
    	
    	try {
			dbConeccion = synchostelDS.getConnection();
			
			//Prepara el Procedimiento Almacenado para ser llamado
			cStmt = dbConeccion.prepareCall("{ call login(?,?,?,?,?)}");
			cStmt.setString(1, run);
			cStmt.setString(2, password);
			cStmt.registerOutParameter(3, Types.OTHER);
			cStmt.registerOutParameter(4, Types.VARCHAR);
			cStmt.registerOutParameter(5, Types.VARCHAR);
			
			//Ejecuta al procedimiento almacenado
			cStmt.execute();
			
			//Guardamos los valores de lo retornado por el procedimiento
			ResultSet rs = (ResultSet) cStmt.getObject(3);
			
			if(rs != null){
				while (rs.next()){
					datosLogin.put("run", rs.getString("rut"));
					datosLogin.put("nombre", rs.getString("nombre"));
					datosLogin.put("email", rs.getString("email"));
					datosLogin.put("password", rs.getString("password"));
					datosLogin.put("telefono", rs.getInt("telefono"));
					datosLogin.put("telefono2", rs.getInt("telefono_2"));
					datosLogin.put("direccion", rs.getString("direccion"));
					datosLogin.put("admin", rs.getBoolean("admin"));
					datosLogin.put("fechaNacimiento", rs.getTimestamp("fecha_nacimiento"));
					datosLogin.put("fechaIngresoHostal", rs.getTimestamp("fecha_ingreso_hostal"));
					
				}
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	return datosLogin;
    }

}
