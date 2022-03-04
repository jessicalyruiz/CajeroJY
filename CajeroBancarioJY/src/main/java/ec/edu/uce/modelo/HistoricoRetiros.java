package ec.edu.uce.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "historico_retiros")
public class HistoricoRetiros {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_retiros")
	@SequenceGenerator(sequenceName = "seq_retiros", name = "seq_retiros",allocationSize = 1)
	@Column(name = "hire_id")
	private Integer id;
	
	@Column(name = "hire_fecha",columnDefinition = "TIMESTAMP")
	private LocalDateTime fecha;
	
	@Column(name = "hire_monto")
	private BigDecimal monto;
	
	@ManyToOne
	@JoinColumn(name = "hire_fk_cuenta_habiente")
	private CuentaHabiente cuentaHabienteR;
	
	
	@ManyToOne
	@JoinColumn(name = "hire_fk_cuenta_bancaria")
	private CuentaBancaria cuenta;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public LocalDateTime getFecha() {
		return fecha;
	}


	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}


	public BigDecimal getMonto() {
		return monto;
	}


	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}


	public CuentaHabiente getCuentaHabienteR() {
		return cuentaHabienteR;
	}


	public void setCuentaHabienteR(CuentaHabiente cuentaHabienteR) {
		this.cuentaHabienteR = cuentaHabienteR;
	}


	public CuentaBancaria getCuenta() {
		return cuenta;
	}


	public void setCuenta(CuentaBancaria cuenta) {
		this.cuenta = cuenta;
	}


	@Override
	public String toString() {
		return "HistoricoRetiros [id=" + id + ", fecha=" + fecha + ", monto=" + monto + ", cuentaHabienteR="
				+ cuentaHabienteR + ", cuenta=" + cuenta + "]";
	}
	
	
	
}
