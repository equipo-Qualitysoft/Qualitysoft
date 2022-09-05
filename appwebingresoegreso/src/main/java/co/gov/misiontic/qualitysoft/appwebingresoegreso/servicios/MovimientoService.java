package co.gov.misiontic.qualitysoft.appwebingresoegreso.servicios;

import co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades.MovimientoDinero;
import co.gov.misiontic.qualitysoft.appwebingresoegreso.repositorios.EmpresaRepository;
import co.gov.misiontic.qualitysoft.appwebingresoegreso.repositorios.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovimientoService {

    @Autowired
    private MovimientoRepository movimientoRepository;
    public List<MovimientoDinero> getAllMovimientos(){
        return movimientoRepository.findAll();
    }

    @Autowired
    private EmpresaRepository empresaRepository;

    public List<MovimientoDinero> getMovimientosByIdEmpresa(Long idEmpresa){
        List<MovimientoDinero> movimientos = new ArrayList<>();
        if (empresaRepository.existsById(idEmpresa)) {
            System.out.println("La empresa con id " + idEmpresa + " tiene los siguientes movimientos: ");
            getAllMovimientos().forEach(movimiento -> {
                if (movimiento.getUsuario().getEmpresa().getIdEmpresa() == idEmpresa) {
                    movimientos.add(movimiento);
                    System.out.println("Movimiento: " + movimiento.getIdMovimiento() + " Valor: " + movimiento.getUsuario().getNombre());
                }
            });
        }
        else {
            System.out.println("La empresa con id " + idEmpresa + " no tiene movimientos registrados.");

        }
        return movimientos;
    }

}


