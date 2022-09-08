package co.gov.misiontic.qualitysoft.appwebingresoegreso.servicios;

import co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades.Empresa;
import co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades.MovimientoDinero;
import co.gov.misiontic.qualitysoft.appwebingresoegreso.repositorios.EmpresaRepository;
import co.gov.misiontic.qualitysoft.appwebingresoegreso.repositorios.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovimientoService {
    @Autowired
    private MovimientoRepository movimientoRepository;
    @Autowired
    private EmpresaRepository empresaRepository;
    @Autowired
    private EmpresaServicio empresaServicio;
    public MovimientoService(MovimientoRepository movimientoRepository) {
        this.movimientoRepository= movimientoRepository;
    }
    // RETORNA TODOS LOS MOVIMIENTOS
    public List<MovimientoDinero> getMovimientoDineroList(){
        return movimientoRepository.findAll();
    }

    // RETORNA TODOS LOS MOVIMIENTOS POR EMPRESA
    public List<MovimientoDinero> getMovimientoDineroListByEmpresa(Long idEmpresa){
        Empresa empresa = empresaServicio.EncontrarId(idEmpresa);
        List<MovimientoDinero> movimientos = new ArrayList<>();
        for (MovimientoDinero movimiento:getMovimientoDineroList()) {
            if (movimiento.getUsuario().getEmpresa().equals(empresa)) {
                movimientos.add(movimiento);
            }
        }
        return movimientos;
    }
}

