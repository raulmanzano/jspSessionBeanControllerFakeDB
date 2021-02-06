package es.manzano.ejemplo.jspjdbc.model;

public class Primaria {	
	private Integer id;	
	private String campo1;
	private String campo2;
	private String campo3;
	
	public Primaria(Integer id,String campo1, String campo2, String campo3) {
		super();
		this.id= id;
		this.campo1 = campo1;
		this.campo2 = campo2;
		this.campo3 = campo3;
	}
	public Primaria(String parameter, String parameter2, String parameter3) {
		super();
		this.id=null; 
		this.campo1 = parameter;
		this.campo2 = parameter2;
		this.campo3 = parameter3;
	}
	public Primaria() {
		super();
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
	
}
