package co.gov.misiontic.qualitysoft.appwebingresoegreso;

import co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades.Empresa;
import co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades.Empleado;
import co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades.MovimientoDinero;
import co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades.Rol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppwebingresoegresoApplication {

	public static void main(String[] args) 	{
		SpringApplication.run(AppwebingresoegresoApplication.class, args);

		//************* Definition of Done de Clase Empresa ****************
		
		//Definition of Done *** Es posible crear una nueva instancia de la clase Empresa
		Empresa qualitysoft = new Empresa("Qualitysoft","Carrera 14 NO. 16-23",7280863, 900854025);
		Empresa amazon = new Empresa("Amazon","Carrera 29 NO. 44-21",207119, 800298922);
		
		//Definition of Done *** Es posible leer el nombre de la empresa
		System.out.println(qualitysoft.getNombre());

		//Definition of Done *** Es posible modificar el nombre de la empresa
		qualitysoft.setNombre("Equipo Qualitysoft");

		//Definition of Done *** Es posible leer la direccion de la empresa
		System.out.println(qualitysoft.getDireccion());

		//Definition of Done *** Es posible modificar la direccion de la empresa
		qualitysoft.setDireccion("carrera 10 N0.20-24");

		//Definition of Done *** Es posible leer el telefono de la empresa
		System.out.println(qualitysoft.getTelefono());

		//Definition of Done *** Es posible modificar el telefono de la empresa
		qualitysoft.setTelefono(7803426);

		//Definition of Done *** Es posible leer el nit de la empresa
		System.out.println(qualitysoft.getNit());

		//Definition of Done *** Es posible modificar el nit de la empresa
		qualitysoft.setNit(1023432134);

		//*************** FIN CLASE EMPRESA *********************************

		//************* Definition of Done de Clase Empleado ****************
		
		//Definition of Done *** Es posible crear una nueva instancia de la clase Empleado
		Empleado empleado1 = new Empleado("Euler Basante","euler206@gmail.com", qualitysoft, Rol.ADMINISTRADOR);
		Empleado empleado2 = new Empleado("Viktor Grajales","viagramo2011@gmail.com", qualitysoft, Rol.ADMINISTRADOR);
		
    		//Definition of Done *** Es posible leer el nombre de un empleado
		System.out.println(empleado1.getNombre());
		
		//Definition of Done *** modificar el nombre de un empleado
		empleado1.setNombre("Luis Perea");
		
    		//Definition of Done *** Es posible leer el correo de un empleado
		System.out.println(empleado1.getCorreo());
		
		//Definition of Done *** Es posible modificar el correo de un empleado
		empleado1.setCorreo("luisperea2022@gmail.com");
		
    		//Definition of Done *** Es posible leer la empresa a la que el empleado pertenece
		System.out.println(empleado1.getEmpresa());
		
		//Definition of Done *** Es posible modificar la empresa a la que el empleado pertenece
		empleado1.setEmpresa(amazon);
		
    		//Definition of Done *** Es posible leer la empresa a la que el empleado pertenece
		System.out.println(empleado1.getRol());
		
		//Definition of Done *** Es posible modificar la empresa a la que el empleado pertenece
		empleado1.setRol(Rol.EMPLEADO);

		//****************** Fin Clase Empleado *************************************

		//************* Definition of Done de Clase MovimientoDinero ****************
		//Definition of Done *** Es posible crear una nueva instancia de la clase MovimeintoDinero
		MovimientoDinero transaccion1 = new MovimientoDinero(1000000, "consignacion", empleado1); 

		// Definition of Done *** Es posible leer el monto del movimiento
		System.out.println(transaccion1.getMonto());

		// Definition of Done ***  Es posible modificar el monto del movimiento
		transaccion1.setMonto(5000000);

		// Definition of Done *** Es posible crear montos positivos
		transaccion1.crearMonto(25000,false);  // INGRESO

		// Definition of Done *** Es posible crear montos negativos
		transaccion1.crearMonto(350000,true);  // EGRESO

		// Definition of Done *** Es posible leer el concepto del movimiento
		System.out.println(transaccion1.getConcepto());

		// Definition of Done *** Es posible modificar el concepto del movimiento
		transaccion1.setConcepto("transferencia electronica");

		// Definition of Done *** Es posible definir que usuario(empleado) fue encargado del registro el movimiento
		System.out.println(transaccion1.getUsuario());

		// -------------- leer clase MovimientoDinero ---------------------------
		System.out.println(transaccion1);
		
		// **************** fin clase MovimientoDinero *******************************************

	}

}
