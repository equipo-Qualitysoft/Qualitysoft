package co.gov.misiontic.qualitysoft.appwebingresoegreso.servicios;

import co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades.MovimientoDinero;

import java.util.List;

public interface IMovimientoService {
    public List<MovimientoDinero> getMovimientoDineroList();
    public List<MovimientoDinero> getMovimientoDineroListByEmpresa(Long idEmpresa);
    public MovimientoDinero getMovimientoById(Long idMovimiento);
    public MovimientoDinero createMovimiento(Long idEmpresa,MovimientoDinero nuevoMovimiento);
    public MovimientoDinero updateMovimiento(MovimientoDinero movimiento);
    public Boolean deleteMovimiento(Long idMovimiento);
}
