package co.gov.misiontic.qualitysoft.appwebingresoegreso.controladores;

import co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades.MovimientoDinero;
import co.gov.misiontic.qualitysoft.appwebingresoegreso.servicios.IMovimientoService;
import co.gov.misiontic.qualitysoft.appwebingresoegreso.servicios.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/empresas/{idEmpresa}")
public class MovimientoController {
    @Autowired
    private IMovimientoService movimientoService;

    public MovimientoController(MovimientoService movimientoService) {
        this.movimientoService = movimientoService;
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/movements")
    public List<MovimientoDinero> movimientoDineroList(){
        return this.movimientoService.getMovimientoDineroList();
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/enterprises/{idEmpresa}/movements")
    public List<MovimientoDinero> movimientoDineroListByEmpresa(@PathVariable("idEmpresa") Long idEmpresa){
        return this.movimientoService.getMovimientoDineroListByEmpresa(idEmpresa);
    }
    @GetMapping("/enterprises/{idEmpresa}/movements/{idMovimiento}")
    public ResponseEntity<MovimientoDinero> movimientoDineroById(@PathVariable("idEmpresa") Long idEmpresa, @PathVariable("idMovimiento") Long idMovimiento){
        MovimientoDinero movimientoDinero = this.movimientoService.getMovimientoById(idEmpresa,idMovimiento);
        if(movimientoDinero == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(movimientoDinero,HttpStatus.OK);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/enterprises/{idEmpresa}/movements")
    public MovimientoDinero createMovimientoDinero(@PathVariable("idEmpresa") Long idEmpresa,@RequestBody MovimientoDinero movimientoDinero){
        return this.movimientoService.createMovimiento(idEmpresa, movimientoDinero);
    }
    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/enterprises/{idEmpresa}/movements/{idMovimiento}")
    public MovimientoDinero updateMovimientoDinero(@PathVariable("idEmpresa") Long idEmpresa,@PathVariable("idMovimiento") Long idMovimiento,@RequestBody MovimientoDinero movimientoDinero){
        return this.movimientoService.updateMovimiento(idEmpresa, idMovimiento, movimientoDinero);
    }
    @DeleteMapping("/enterprises/{idEmpresa}/movements/{idMovimiento}")
    public ResponseEntity<Boolean> deleteMovimientoDinero(@PathVariable("idEmpresa") Long idEmpresa, @PathVariable("idMovimiento") Long idMovimiento){
        return new ResponseEntity<Boolean>(this.movimientoService.deleteMovimiento(idEmpresa, idMovimiento), HttpStatus.OK);
    }
}
