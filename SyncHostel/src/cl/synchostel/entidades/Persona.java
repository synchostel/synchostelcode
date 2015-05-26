package cl.synchostel.entidades;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ejb.EJB;

import cl.synchostel.ejb.interfaces.PersonaEJBRemote;

public class Persona {
	
	private String rut;
	private String nombre="";
	private String email;
	private String password;
	private String telefono;
	private String telefono2;
	private String direccion;
	private boolean admin;
	private String fechaNacimiento;
	private String fechaIngresoHostal;
	private ArrayList<Integer> bloqueHorario;
	private ArrayList<Integer> tareas;
	private int perfil;
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getTelefono2() {
		return telefono2;
	}
	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getFechaIngresoHostal() {
		return fechaIngresoHostal;
	}
	public void setFechaIngresoHostal(String fechaIngresoHostal) {
		this.fechaIngresoHostal = fechaIngresoHostal;
	}
	public ArrayList<Integer> getBloqueHorario() {
		return bloqueHorario;
	}
	public void setBloqueHorario(ArrayList<Integer> bloqueHorario) {
		this.bloqueHorario = bloqueHorario;
	}
	public ArrayList<Integer> getTareas() {
		return tareas;
	}
	public void setTareas(ArrayList<Integer> tareas) {
		this.tareas = tareas;
	}
	public int getPerfil() {
		return perfil;
	}
	public void setPerfil(int perfil) {
		this.perfil = perfil;
	}
	
	
	public void cargarDatos(HashMap<String, Object> datosPersona){
		this.rut = (String) datosPersona.get("run");
		this.nombre = (String) datosPersona.get("nombre");
		this.admin = ((Boolean) datosPersona.get("admin")).booleanValue();
		this.direccion = (String) datosPersona.get("direccion");
		this.email = (String) datosPersona.get("email");
		this.fechaIngresoHostal = (String) datosPersona.get("fechaIngresoHostal");
		this.fechaNacimiento = (String) datosPersona.get("fechaNacimiento");
		this.password = (String) datosPersona.get("password");
		this.telefono = (String) datosPersona.get("telefono");
		this.telefono2 = (String) datosPersona.get("telefono2");
	}

}
