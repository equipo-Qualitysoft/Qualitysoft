package co.gov.misiontic.qualitysoft.appwebingresoegreso.servicios;

import co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades.ClienteProveedor;
import co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades.MovimientoDinero;

import java.util.List;

public interface IClienteProveedorService {
    List<ClienteProveedor> getAllClientesProveedores();
}
