package co.gov.misiontic.qualitysoft.appwebingresoegreso.controladores;

import co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades.MovimientoDinero;
import co.gov.misiontic.qualitysoft.appwebingresoegreso.servicios.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/empresas/{idEmpresa}")
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
//
//    @PostMapping("/movimientos")
//    public MovimientoDinero createMovimientoDinero(@RequestBody MovimientoDinero movimientoDinero){
//        return this.movimientoService.createMovimientoDinero(movimientoDinero);
//    }
//
//    @GetMapping("/")
//    public List<MovimientoDinero> getMovimientoDineroListByEmpresa(@PathVariable Long idEmpresa){
//        return this.movimientoService.getMovimientoDineroListByEmpresa(idEmpresa);
//    }
//    @PostMapping("{idEmpresa}/movimientos")
//    public MovimientoDinero createMovimientoDinero(@PathVariable Long idEmpresa, @RequestBody MovimientoDinero movimientoDinero){
//        return this.movimientoService.createMovimientoDinero(idEmpresa, movimientoDinero);
//    }



}
