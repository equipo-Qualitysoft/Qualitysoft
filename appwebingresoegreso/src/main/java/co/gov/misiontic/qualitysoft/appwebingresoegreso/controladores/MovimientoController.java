package co.gov.misiontic.qualitysoft.appwebingresoegreso.controladores;

import co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades.MovimientoDinero;
import co.gov.misiontic.qualitysoft.appwebingresoegreso.servicios.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovimientoController {
    @Autowired
    MovimientoService movimientoService;

    public MovimientoController(MovimientoService movimientoService) {
        this.movimientoService = movimientoService;
    }
    @GetMapping("/movimientos")
    public List<MovimientoDinero> movimientoDineroList(){
        return this.movimientoService.getMovimientoDineroList();
    }

    @PostMapping("/movimientos")
    public MovimientoDinero createMovimientoDinero(@RequestBody MovimientoDinero movimientoDinero){
        return this.movimientoService.createMovimientoDinero(movimientoDinero);
    }


}
