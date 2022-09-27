package co.gov.misiontic.qualitysoft.appwebingresoegreso.servicios;

import co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades.Empresa;
import co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades.MovimientoDinero;
import co.gov.misiontic.qualitysoft.appwebingresoegreso.repositorios.EmpresaRepository;
import co.gov.misiontic.qualitysoft.appwebingresoegreso.repositorios.MovimientoRepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        Empresa empresa = empresaServicio.getEmpresaById(idEmpresa).get();
        List<MovimientoDinero> movimientos = new ArrayList<>();
        for (MovimientoDinero movimiento : getMovimientoDineroList()) {
            if (movimiento.getUsuario().getEmpresa().equals(empresa)) {
                movimientos.add(movimiento);
            }
        }
        return movimientos;
    }

    @Override
    public MovimientoDinero getMovimientoById(Long idMovimiento) {
        return movimientoRepository.findById(idMovimiento).get();
    }

    @Override
    public MovimientoDinero createMovimiento(Long idEmpresa, MovimientoDinero nuevoMovimiento) {
        nuevoMovimiento.setEmpresa(empresaServicio.getEmpresaById(idEmpresa).get());
        return movimientoRepository.save(nuevoMovimiento);
    }

//
//    @Override
//    public MovimientoDinero updateMovimiento(MovimientoDinero movimiento) {
//        return movimientoRepository.save(movimiento);
//    }
//

    // TERMINAR DE IMPELMENTAR
    public MovimientoDinero updateMovimientoById(Long idMovimiento, MovimientoDinero movimiento) {
        //MovimientoDinero movimiento = getMovimientoById(idMovimiento);
        return movimientoRepository.save(movimiento);
    }


    @Override
    public Boolean deleteMovimiento(Long idMovimiento) {
        if (movimientoRepository.findById(idMovimiento).isPresent()) {
            movimientoRepository.deleteById(idMovimiento);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
    @Override
    public List<MovimientoDinero> getMovimientoListByUsuario(Long idUsuario) {
        System.out.println("idUsuario: " + idUsuario);
        return movimientoRepository.findByUsuario(idUsuario);
    }

    @Override
    public boolean saveOrUpdateMovimiento(MovimientoDinero movimiento) {
        if (movimiento.getMonto() > 0) {
            movimiento.setConcepto("VENTA");
        }  else if (movimiento.getMonto() < 0) {
            movimiento.setConcepto("COMPRA");

        }
        MovimientoDinero mov= movimientoRepository.save(movimiento);
        if (movimientoRepository.findById(mov.getIdMovimiento())!=null){
            return true;
        }
        return false;
    }
}
