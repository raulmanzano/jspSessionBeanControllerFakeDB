package es.manzano.ejemplo.jspjdbc.business;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.manzano.ejemplo.jspjdbc.model.Primaria;

public class BusinessDelegate {	
	private static final Logger logger = LoggerFactory.getLogger(BusinessDelegate.class);
	
	private TreeMap<Integer,Primaria> almacen= null;
	private int contador=0;
	public BusinessDelegate() {
		super();
		this.almacen = new TreeMap<Integer,Primaria>();		
		this.almacen.put(1,(new Primaria(1,"unoC1","unoC2","unoC3")));
		this.almacen.put(2,(new Primaria(2,"dosC1","dosC2","dosC3")));
		this.almacen.put(3,(new Primaria(3,"tresC1","tresC2","tresC3")));
		contador=3;
	}
	
	/* propiedades del managed bean*/
	private String id = null;
	private String operacion = null;
	private String mensaje = null;
	private Primaria primaria = null;
	private String campo1 = null;
	private String campo2 = null;
	private String campo3 = null;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOperacion() {
		return operacion;
	}
	public void setOperacion(String operacion) throws Exception {
		this.operacion= operacion;
		logger.info("setOperacion");
		 try {
			 switch (operacion) {
                case "Edit":
                	logger.info("Operacion Edit");
                	primaria=getById(this.id);
                    break;
                case "Delete":
                	logger.info("Operacion Delete");
                	delete(this.id);
                	this.mensaje="Eliminado";
                    break;
                case "Nuevo":
                	logger.info("Operacion Nuevo");
                    break;
                case "Editar":
                	logger.info("Operacion Editar");
                	this.primaria.setId(Integer.valueOf(this.id));
                	this.primaria.setCampo1(this.campo1);
                	this.primaria.setCampo2(this.campo2);
                	this.primaria.setCampo3(this.campo3);
                	updatePrimaria(this.primaria);
                	this.mensaje="Actualizado";
                	break;
                case "Crear":
                	logger.info("Operacion Crear");
                	this.primaria.setCampo1(this.campo1);
                	this.primaria.setCampo2(this.campo2);
                	this.primaria.setCampo3(this.campo3);
                	insertarPrimaria(this.primaria);
                	this.mensaje="Creado";
                    break;
                default:
                	logger.info("Operacion Default!!!!!");
	            }
	        } catch (Exception ex) {
	        	throw new Exception("Problemas cn la opercion",ex);
	        }
	}
	
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public Primaria getPrimaria() {
		return primaria;
	}
	public void setPrimaria(Primaria primaria) {
		this.primaria = primaria;
	}
	
	
	public String getCampo1() {
		return campo1;
	}
	public void setCampo1(String campo1) {
		this.campo1 = campo1;
	}
	public String getCampo2() {
		return campo2;
	}
	public void setCampo2(String campo2) {
		this.campo2 = campo2;
	}
	public String getCampo3() {
		return campo3;
	}
	public void setCampo3(String campo3) {
		this.campo3 = campo3;
	}
	public String getReset()
	{
		logger.info("Reset!!!");
		this.id = null;
		this.operacion = null;
		this.mensaje = null;
		this.primaria=new Primaria();
		this.campo1=null;
		this.campo2=null;
		this.campo3=null;
		return "";
	}
	
	
	
	/*Operciones basicas*/
	public List<Primaria> getAllPrimaria() {
		//logger.info("getAllPrimaria()");		
		return new ArrayList<Primaria>(almacen.values());
	}
	public void insertarPrimaria(Primaria parametro) {
		//logger.info("insertarPrimaria()");
		contador++;
		parametro.setId(contador);
		almacen.put(parametro.getId(),parametro);
	}

	public Primaria getById(String parameter) {
		return almacen.get(Integer.valueOf(parameter));
	}

	public void delete(String parameter) {
		almacen.remove(Integer.valueOf(parameter));		
	}

	public void updatePrimaria(Primaria primaria) {
		
		
		
		almacen.remove(primaria.getId());
		almacen.put(primaria.getId(),primaria);

	}

}
