package co.gov.misiontic.qualitysoft.appwebingresoegreso.controladores;

import co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades.Articulo;
import co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades.ClienteProveedor;
import co.gov.misiontic.qualitysoft.appwebingresoegreso.servicios.IClienteProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClienteProveedorController {
    @Autowired
    IClienteProveedorService clienteProveedorService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/clientes")
    public List<ClienteProveedor> verClientesProveedores(){
        return clienteProveedorService.getAllClientesProveedores();
    }
}
