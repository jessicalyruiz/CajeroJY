package ec.edu.uce.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.CuentaBancaria;
import ec.edu.uce.modelo.CuentaHabiente;
import ec.edu.uce.modelo.CuentaHabienteVIP;
import ec.edu.uce.repository.ICuentaHabienteRepo;



@Service
public class CuentaHabienteService implements ICuentaHabienteService{

	@Autowired
	private ICuentaHabienteRepo cuentaHabienteRepo;
	
	@Autowired
	private ICuentaBancariaService cuentaService;

	@Override
	public void create(CuentaHabiente cuentaHabiente) {
		// TODO Auto-generated method stub
		this.cuentaHabienteRepo.create(cuentaHabiente);
	}

	@Override
	public CuentaHabiente read(Integer id) {
		// TODO Auto-generated method stub
		return this.cuentaHabienteRepo.read(id);
	}

	@Override
	public void update(CuentaHabiente cuentaHabiente) {
		// TODO Auto-generated method stub
		this.cuentaHabienteRepo.update(cuentaHabiente);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		this.cuentaHabienteRepo.delete(id);
	}

	@Override
	public List<CuentaHabiente> listaClientes() {
		// TODO Auto-generated method stub
		return this.cuentaHabienteRepo.listaClientes();
	}
	@Override
	public Stream<CuentaHabienteVIP> reporteClientesVIP(BigDecimal saldo) {
		//obtengo todas las cuentas
		List<CuentaBancaria> listaCuentas=this.cuentaService.listaCuentas();
		//listaCuentas.forEach(c->System.out.println(c+"cuentaHabiente" +c.getCuentaHabiente()+"Retiros"+c.getRetiros()));
		//aplico un filtro por saldo
		Stream<CuentaBancaria> filter = listaCuentas.stream().filter(c->c.getSaldo().compareTo(saldo)==1);
		//convierto a VIP
		Stream<CuentaHabienteVIP>listaVIP=  filter.map(c->this.convertirVIP(c));
		//listaVIP.forEach(c->System.out.println(c));
		return listaVIP;
	}
	
	public  CuentaHabienteVIP convertirVIP(CuentaBancaria cuenta) {
		CuentaHabienteVIP clienteVIP=new CuentaHabienteVIP();
		clienteVIP.setApellido(cuenta.getCuentaHabiente().getApellido());
		clienteVIP.setCedula(cuenta.getCuentaHabiente().getCedula());
		clienteVIP.setNombre(cuenta.getCuentaHabiente().getNombre());
		clienteVIP.setNumeroCuenta(cuenta.getNumero());
		clienteVIP.setSaldo(cuenta.getSaldo());
		clienteVIP.setTipoCuenta(cuenta.getTipo());
		return clienteVIP;
		
	}
	
}
