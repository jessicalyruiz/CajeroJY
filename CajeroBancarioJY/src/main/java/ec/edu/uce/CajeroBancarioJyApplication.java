package ec.edu.uce;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ec.edu.uce.modelo.CuentaBancaria;
import ec.edu.uce.modelo.CuentaHabiente;
import ec.edu.uce.modelo.CuentaHabienteVIP;
import ec.edu.uce.service.ICuentaBancariaService;
import ec.edu.uce.service.ICuentaHabienteService;
import ec.edu.uce.service.IHistoricoRetitoService;




@SpringBootApplication
public class CajeroBancarioJyApplication implements CommandLineRunner{
	private static final Logger LOG= (Logger) LoggerFactory.getLogger(CajeroBancarioJyApplication.class);
	
	
	@Autowired
	private ICuentaHabienteService cuantaHabienteService;
	
	@Autowired
	private ICuentaBancariaService cuentaService;
	
	@Autowired
	private IHistoricoRetitoService retiroService;
	
	public static void main(String[] args) {
		SpringApplication.run(CajeroBancarioJyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//Insertar desde la clase principal 2Cuenta Habientes con una CuentaBancaria cada uno
		/*		
		CuentaHabiente cliente=new CuentaHabiente();
				cliente.setApellido("Ruiz");
				cliente.setCedula("1708");
				cliente.setNombre("Jessica");
				
				CuentaHabiente cliente2=new CuentaHabiente();
				cliente2.setApellido("Lincango");
				cliente2.setCedula("17892");
				cliente2.setNombre("Andres");
				
				CuentaBancaria cuenta=new CuentaBancaria();
				cuenta.setNumero("78-96");
				cuenta.setSaldo(new BigDecimal(1000));
				cuenta.setTipo("Corriente");
				cuenta.setCuentaHabiente(cliente);
				
				CuentaBancaria cuenta2=new CuentaBancaria();
				cuenta2.setNumero("36-45");
				cuenta2.setSaldo(new BigDecimal(2000));
				cuenta2.setTipo("Ahorro");
				cuenta2.setCuentaHabiente(cliente2);
				
				List<CuentaBancaria> cuentasCliente=new ArrayList<>();
				cuentasCliente.add(cuenta);
				cliente.setCuentas(cuentasCliente);
				
				List<CuentaBancaria> cuentasCliente2=new ArrayList<>();
				cuentasCliente2.add(cuenta2);
				cliente2.setCuentas(cuentasCliente2);
				
//				cuantaHabienteService.create(cliente);
//				cuantaHabienteService.create(cliente2);
				
				//cuentaService.create(cuenta2);
				//cuentaService.create(cuenta);
				
				
				//Consultar cuentas
				List<CuentaBancaria> cuentasConsulta= this.cuentaService.buscarCuentaCedula("1708");
				for (CuentaBancaria c : cuentasConsulta) {
					LOG.info(c.toString());
					LOG.info("cliente "+c.getCuentaHabiente());
				}
				
				//Retirar dinero
				
				this.cuentaService.retirarDinero("78-96", new BigDecimal(100.5));
				
				//Consultar saldo
				
				LOG.info("el saldo es: "+cuentaService.consultarSaldo("36-45").toString());
				*/
		/*
		List<CuentaHabiente> listaClientes=this.cuantaHabienteService.listaClientes();
		listaClientes.forEach(c->System.out.println(c+"cuentas" +c.getCuentas()));
		System.out.println("hello");
		*/
		
		//*************************
		//inserto
		
		/*
		CuentaHabiente cliente=new CuentaHabiente();
		cliente.setApellido("Yanez");
		cliente.setCedula("2300");
		cliente.setNombre("Lorena");
		
		CuentaHabiente cliente2=new CuentaHabiente();
		cliente2.setApellido("Vivanco");
		cliente2.setCedula("1459");
		cliente2.setNombre("Pedro");
		
		CuentaBancaria cuenta=new CuentaBancaria();
		cuenta.setNumero("96-85");
		cuenta.setSaldo(new BigDecimal(800));
		cuenta.setTipo("Corriente");
		cuenta.setCuentaHabiente(cliente);
		
		CuentaBancaria cuenta2=new CuentaBancaria();
		cuenta2.setNumero("38-27");
		cuenta2.setSaldo(new BigDecimal(3000));
		cuenta2.setTipo("Ahorro");
		cuenta2.setCuentaHabiente(cliente2);
		
		List<CuentaBancaria> cuentasCliente=new ArrayList<>();
		cuentasCliente.add(cuenta);
		cliente.setCuentas(cuentasCliente);
		
		List<CuentaBancaria> cuentasCliente2=new ArrayList<>();
		cuentasCliente2.add(cuenta2);
		cliente2.setCuentas(cuentasCliente2);
		
		cuantaHabienteService.create(cliente);
		cuantaHabienteService.create(cliente2);
		*/
		
		//realizar 5retiros adicionales de dinero
		/*
		this.cuentaService.retirarDinero("36-45", new BigDecimal(500));
		this.cuentaService.retirarDinero("78-96", new BigDecimal(9.5));
		this.cuentaService.retirarDinero("96-85", new BigDecimal(100));
		this.cuentaService.retirarDinero("38-27", new BigDecimal(1200));
		this.cuentaService.retirarDinero("36-45", new BigDecimal(300));
		*/
		
		//Reporte de cuenta habientes
		System.out.println("**reporte Cuenta");
		Stream<CuentaHabienteVIP> listaVIP=cuantaHabienteService.reporteClientesVIP(new BigDecimal(1000));
		listaVIP.forEach(c->System.out.println(c));
		
		//Reporte de histórico de retiros
		System.out.println("**reporte retiros");
		Stream<String> reporteRetiros=this.retiroService.reporteRetiros(LocalDateTime.of(2022, 3, 10, 0, 0), new BigDecimal(100));
		reporteRetiros.forEach(c->System.out.println(c));
	}
	

}
