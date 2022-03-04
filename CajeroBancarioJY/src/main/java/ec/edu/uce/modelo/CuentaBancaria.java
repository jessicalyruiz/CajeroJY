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

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "cuenta_bancaria")
public class CuentaBancaria {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cuba")
	@SequenceGenerator(sequenceName = "seq_cuba", name = "seq_cuba",allocationSize = 1)
	@Column(name = "cuba_id")
	private Integer id;
	
	@Column(name = "cuba_numero")
	private String numero;
	
	@Column(name = "cuba_saldo")
	private BigDecimal saldo;
	
	@Column(name = "cuba_tipo")
	private String tipo;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cuba_fk_cuanta_habiente")
	private CuentaHabiente cuentaHabiente;

	@OneToMany(mappedBy = "cuenta", cascade = CascadeType.ALL)
	private List<HistoricoRetiros> retiros;
	
	
	
	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getNumero() {
		return numero;
	}



	public void setNumero(String numero) {
		this.numero = numero;
	}



	public BigDecimal getSaldo() {
		return saldo;
	}



	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}



	public String getTipo() {
		return tipo;
	}



	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



	public CuentaHabiente getCuentaHabiente() {
		return cuentaHabiente;
	}



	public void setCuentaHabiente(CuentaHabiente cuentaHabiente) {
		this.cuentaHabiente = cuentaHabiente;
	}



	public List<HistoricoRetiros> getRetiros() {
		return retiros;
	}



	public void setRetiros(List<HistoricoRetiros> retiros) {
		this.retiros = retiros;
	}



	@Override
	public String toString() {
		return "CuentaBancaria [id=" + id + ", numero=" + numero + ", saldo=" + saldo + ", tipo=" + tipo
				+  "]";
	}
	
	
}
