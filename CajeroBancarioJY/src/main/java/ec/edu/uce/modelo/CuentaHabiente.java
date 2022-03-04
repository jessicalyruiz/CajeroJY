package ec.edu.uce.modelo;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cuenta_habiente")
public class CuentaHabiente {

	@Id
	@Column(name = "cuha_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cuenta_habiente")
	@SequenceGenerator(name = "seq_cuenta_habiente", sequenceName = "seq_cuenta_habiente", allocationSize = 1)
	private Integer id;
	

	
	@Column(name = "cuha_apellido")
	private String apellido;
	
	@Column(name = "cuha_nombre")
	private String nombre;
	
	@Column(name = "cuha_cedula")
	private String cedula;
	
	@OneToMany(mappedBy = "cuentaHabiente")
	private List<CuentaBancaria> cuentas;
	
	
	@OneToMany(mappedBy = "cuentaHabienteR", cascade = CascadeType.ALL)
	private List<HistoricoRetiros> retiros;
	
//	get y set
	
	public List<HistoricoRetiros> getRetiros() {
		return retiros;
	}

	public void setRetiros(List<HistoricoRetiros> retiros) {
		this.retiros = retiros;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public List<CuentaBancaria> getCuentas() {
		return cuentas;
	}

	public void setCuentas(List<CuentaBancaria> cuentas) {
		this.cuentas = cuentas;
	}

	@Override
	public String toString() {
		return "CuentaHabiente [id=" + id + ", apellido=" + apellido + ", nombre=" + nombre + ", cedula=" + cedula
				+ ", retiros=" + retiros + "]";
	}



	

}
