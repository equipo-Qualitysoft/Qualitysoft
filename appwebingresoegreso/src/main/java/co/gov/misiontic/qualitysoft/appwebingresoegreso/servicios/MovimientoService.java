package co.gov.misiontic.qualitysoft.appwebingresoegreso.servicios;

import co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades.MovimientoDinero;
import co.gov.misiontic.qualitysoft.appwebingresoegreso.repositorios.MovimientoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimientoService {
    private MovimientoRepository movimientoRepository;
    public MovimientoService(MovimientoRepository movimientoRepository) {
        this.movimientoRepository= movimientoRepository;
    }
    public List<MovimientoDinero> getMovimientoDineroList(){
        return movimientoRepository.findAll();
    }
public MovimientoDinero createMovimientoDinero(MovimientoDinero movimientoDinero){
        return movimientoRepository.save(movimientoDinero);
    }
}
