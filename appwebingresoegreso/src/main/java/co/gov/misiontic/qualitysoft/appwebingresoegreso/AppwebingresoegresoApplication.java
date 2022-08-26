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
		//Es posible crear una nueva instancia de la clase Empresa
		Empresa qualitysoft = new Empresa("Qualitysoft","Carrera 14 NO. 16-23",7280863, 900854025);















		//*************** FIN CLASE EMPRESA ********************************************

		//************* Definition of Done de Clase Empleado ****************
		//Es posible crear una nueva instancia de la clase Empleado
		Empleado empleado1 = new Empleado("Euler Basante","euler206@gmail.com", qualitysoft, Rol.ADMINISTRADOR);
















		//****************** Fin Clase Empleado *******************************************************

		//************* Definition of Done de Clase MovimientoDinero ****************
		//Es posible crear una nueva instancia de la clase MovimeintoDinero
		MovimientoDinero transaccion1 = new MovimientoDinero(1000000, "consignacion", empleado1); //para empleado 1 falta la implentacion de la clase empleado

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
