package co.gov.misiontic.qualitysoft.appwebingresoegreso.servicios;

import co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades.Empresa;
import co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades.MovimientoDinero;
import co.gov.misiontic.qualitysoft.appwebingresoegreso.repositorios.EmpresaRepository;
import co.gov.misiontic.qualitysoft.appwebingresoegreso.repositorios.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovimientoService implements IMovimientoService {
    @Autowired
    private MovimientoRepository movimientoRepository;
    @Autowired
    private EmpresaRepository empresaRepository;
    @Autowired
    private EmpresaServicio empresaServicio;

    public MovimientoService(MovimientoRepository movimientoRepository) {
        this.movimientoRepository = movimientoRepository;
    }

    // RETORNA TODOS LOS MOVIMIENTOS
    @Override
    public List<MovimientoDinero> getMovimientoDineroList() {
        return movimientoRepository.findAll();
    }

    // RETORNA TODOS LOS MOVIMIENTOS POR EMPRESA
    @Override
    public List<MovimientoDinero> getMovimientoDineroListByEmpresa(Long idEmpresa) {
        Empresa empresa = empresaServicio.EncontrarId(idEmpresa);
        List<MovimientoDinero> movimientos = new ArrayList<>();
        for (MovimientoDinero movimiento : getMovimientoDineroList()) {
            if (movimiento.getUsuario().getEmpresa().equals(empresa)) {
                movimientos.add(movimiento);
            }
        }
        return movimientos;
    }
    @Override
    public MovimientoDinero getMovimientoById(Long idEmpresa, Long idMovimiento) {
        return movimientoRepository.findById(idMovimiento).get();
    }

    @Override
    public MovimientoDinero createMovimiento(Long idEmpresa, MovimientoDinero nuevoMovimiento) {
        return movimientoRepository.save(nuevoMovimiento);
    }

    @Override
    public MovimientoDinero updateMovimiento(Long idEmpresa, Long idMovimiento, MovimientoDinero movimiento) {
        return movimientoRepository.save(movimiento);
    }

    @Override
    public Boolean deleteMovimiento(Long idEmpresa, Long idMovimiento) {
        if (movimientoRepository.findById(idMovimiento).isPresent()) {
            movimientoRepository.deleteById(idMovimiento);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
