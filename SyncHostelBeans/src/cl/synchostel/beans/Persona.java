package cl.synchostel.beans;

import java.util.HashMap;

public class Persona {
	private String rut;
	private String nombre;
	private Boolean admin;
	private String direccion;
	private String email;
	private String fechaIngresoHostal;
	private String fechaNacimiento;
	private String password;
	private int telefono;
	private int telefono2;

	/*
	 * Constructor
	 */
	
	public Persona(){
	}
	
	/*
	 * Getters y Setters
	 */
	
	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFechaIngresoHostal() {
		return fechaIngresoHostal;
	}

	public void setFechaIngresoHostal(String fechaIngresoHostal) {
		this.fechaIngresoHostal = fechaIngresoHostal;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public int getTelefono2() {
		return telefono2;
	}

	public void setTelefono2(int telefono2) {
		this.telefono2 = telefono2;
	}
	
	/*
	 * Métodos de la clase
	 */

	public void cargarDatos(HashMap<String, Object> datosPersona){
		this.rut = (String) datosPersona.get("run");
		this.nombre = (String) datosPersona.get("nombre");
		this.admin = ((Boolean) datosPersona.get("admin")).booleanValue();
		this.direccion = (String) datosPersona.get("direccion");
		this.email = (String) datosPersona.get("email");
		this.fechaIngresoHostal = (String) datosPersona.get("fechaIngresoHostal");
		this.fechaNacimiento = (String) datosPersona.get("fechaNacimiento");
		this.password = (String) datosPersona.get("password");
		this.telefono = Integer.parseInt((String)datosPersona.get("telefono"));
		this.telefono2 = Integer.parseInt((String)datosPersona.get("telefono2"));
	}
	
}