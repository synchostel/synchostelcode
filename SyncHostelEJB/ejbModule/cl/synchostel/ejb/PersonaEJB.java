package cl.synchostel.ejb;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;

import cl.synchostel.beans.Persona;
import cl.synchostel.ejb.interfaces.PersonaEJBLocal;
import cl.synchostel.ejb.interfaces.PersonaEJBRemote;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

/**
 * Session Bean implementation class PersonaEJB
 */
@Stateless(mappedName = "SyncHostel/PersonaEJB")
public class PersonaEJB implements PersonaEJBRemote, PersonaEJBLocal {

	@Resource(mappedName = "java:/SyncHostelDes")
	private DataSource syncHostelDS;
	private Connection dbConeccion;
	
	
    /**
     * Default constructor. 
     */
    public PersonaEJB() {
        
    }
    
    public Persona login(Persona persona){
    	CallableStatement cStmt = null;
    	
    	try {
			dbConeccion = syncHostelDS.getConnection();
			cStmt = dbConeccion.prepareCall("{ call login(?,?,?,?,?)}");
			cStmt.setString(1, persona.getRut());
			cStmt.setString(2, persona.getPassword());
			cStmt.registerOutParameter(3, Types.OTHER);
			cStmt.registerOutParameter(4, Types.VARCHAR);
			cStmt.registerOutParameter(5, Types.VARCHAR);
			
			//Ejecuta al procedimiento almacenado
			cStmt.execute();
			
			//Guardamos los valores de lo retornado por el procedimiento
			ResultSet rs = (ResultSet) cStmt.getObject(3);
			
			if(rs != null){
				while (rs.next()){
					persona.setRut(rs.getString("rut"));
					persona.setNombre(rs.getString("nombre"));
					persona.setEmail(rs.getString("email"));
					persona.setPassword(rs.getString("password"));
					persona.setTelefono(rs.getInt("telefono"));
					persona.setTelefono2(rs.getInt("telefono_2"));
					persona.setDireccion(rs.getString("direccion"));
					persona.setAdmin(rs.getBoolean("admin"));
					persona.setFechaNacimiento((rs.getTimestamp("fecha_nacimiento")).toString());
					persona.setFechaIngresoHostal((rs.getTimestamp("fecha_ingreso_hostal")).toString());
				}
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return persona;
    }
    
    public HashMap<String,Persona> login(HashMap<String,Persona> p){
    	CallableStatement cStmt = null;
    	Persona persona = p.get("persona");
    	try {
			dbConeccion = syncHostelDS.getConnection();
			cStmt = dbConeccion.prepareCall("{ call login(?,?,?,?,?)}");
			cStmt.setString(1, persona.getRut());
			cStmt.setString(2, persona.getPassword());
			cStmt.registerOutParameter(3, Types.OTHER);
			cStmt.registerOutParameter(4, Types.VARCHAR);
			cStmt.registerOutParameter(5, Types.VARCHAR);
			
			//Ejecuta al procedimiento almacenado
			cStmt.execute();
			
			//Guardamos los valores de lo retornado por el procedimiento
			ResultSet rs = (ResultSet) cStmt.getObject(3);
			
			if(rs != null){
				while (rs.next()){
					persona.setRut(rs.getString("rut"));
					persona.setNombre(rs.getString("nombre"));
					persona.setEmail(rs.getString("email"));
					persona.setPassword(rs.getString("password"));
					persona.setTelefono(rs.getInt("telefono"));
					persona.setTelefono2(rs.getInt("telefono_2"));
					persona.setDireccion(rs.getString("direccion"));
					persona.setAdmin(rs.getBoolean("admin"));
					persona.setFechaNacimiento((rs.getTimestamp("fecha_nacimiento")).toString());
					persona.setFechaIngresoHostal((rs.getTimestamp("fecha_ingreso_hostal")).toString());
				}
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	HashMap<String, Persona> mapaSalida = new HashMap<String, Persona>();
		mapaSalida.put("persona", persona);
		return mapaSalida;
    }
}
