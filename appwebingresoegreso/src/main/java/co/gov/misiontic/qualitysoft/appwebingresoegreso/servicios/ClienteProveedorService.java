package co.gov.misiontic.qualitysoft.appwebingresoegreso.servicios;

import co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades.Articulo;
import co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades.ClienteProveedor;
import co.gov.misiontic.qualitysoft.appwebingresoegreso.repositorios.ArticuloRepository;
import co.gov.misiontic.qualitysoft.appwebingresoegreso.repositorios.ClienteProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteProveedorService implements IClienteProveedorService {
    @Autowired
    private ClienteProveedorRepository clienteProveedorRepository;

    @Override
    public List<ClienteProveedor> getAllClientesProveedores() {
        return clienteProveedorRepository.findAll();
    }
}
