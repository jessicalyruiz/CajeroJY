package ec.edu.uce.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.CuentaBancaria;
import ec.edu.uce.modelo.HistoricoRetiros;
import ec.edu.uce.repository.ICuentaBancariaRepo;



@Service
public class CuentaBancariaService implements ICuentaBancariaService{

	@Autowired
	private ICuentaBancariaRepo cuentaRepo;
	
	@Autowired
	private IHistoricoRetitoService historicoService;

	@Override
	public void create(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		this.cuentaRepo.create(cuentaBancaria);
	}

	@Override
	public CuentaBancaria read(Integer id) {
		// TODO Auto-generated method stub
		return this.cuentaRepo.read(id);
	}

	@Override
	public void update(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		this.cuentaRepo.update(cuentaBancaria);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		this.cuentaRepo.delete(id);
	}

	@Override
	public List<CuentaBancaria> buscarCuentaCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.cuentaRepo.buscarCuentaCedula(cedula);
	}

	@Override
	public CuentaBancaria buscarNumeroCuenta(String numero) {
		// TODO Auto-generated method stub
		return this.cuentaRepo.buscarNumeroCuenta(numero);
	}

	@Override
	public BigDecimal consultarSaldo(String numero) {
		CuentaBancaria cuenta=this.buscarNumeroCuenta(numero);
		return cuenta.getSaldo();
	}

	@Override
	@Transactional
	public void retirarDinero(String numeroCuenta, BigDecimal valorRetirar) {
		CuentaBancaria cuenta=this.buscarNumeroCuenta(numeroCuenta);
		cuenta.setSaldo(cuenta.getSaldo().subtract(valorRetirar));
		cuentaRepo.update(cuenta);
		
		HistoricoRetiros retiro=new HistoricoRetiros();
		retiro.setCuenta(cuenta);
		retiro.setCuentaHabienteR(cuenta.getCuentaHabiente());
		retiro.setFecha(LocalDateTime.now());
		retiro.setMonto(valorRetirar);
		historicoService.create(retiro);
		
	}
}
