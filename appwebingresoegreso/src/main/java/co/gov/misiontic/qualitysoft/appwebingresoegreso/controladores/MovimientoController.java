package co.gov.misiontic.qualitysoft.appwebingresoegreso.controladores;

import co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades.MovimientoDinero;
import co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades.Usuario;
import co.gov.misiontic.qualitysoft.appwebingresoegreso.servicios.IMovimientoService;
import co.gov.misiontic.qualitysoft.appwebingresoegreso.servicios.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

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
        MovimientoDinero movimientoDinero = this.movimientoService.getMovimientoById(idMovimiento);
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
        return this.movimientoService.updateMovimiento(movimientoDinero);
    }

    // ACTUALIZAR MOVIMIENTO POR ID *terminar *****************************************
    @PatchMapping("/verMovimientos/{id}")
    public RedirectView updateMovimiento(@PathVariable("id") Long id, @RequestBody MovimientoDinero movimientoDinero, RedirectAttributes attributes){
        //this.movimientoService.(id, );
        return new RedirectView("/tasks");
    }


    // BORRA MOVIMIENTO POR ID
    @DeleteMapping("/verMovimiento/{id}")
    public RedirectView deleteMovimiento(@PathVariable("id") Long id){
        this.movimientoService.deleteMovimiento(id);
        return new RedirectView("/verMovimiento");
    }


    @GetMapping("/users/{idUsuario}/movements")
    public List<MovimientoDinero> getMovimientoListByUsuario(@PathVariable("idUsuario") Long idUsuario){
        return this.movimientoService.getMovimientoListByUsuario(idUsuario);
    }

//    @GetMapping("/agregarMovimiento")
//    public String nuevoMovimiento(Model model, @ModelAttribute("mensaje") String mensaje){
//        MovimientoDinero movimiento = new MovimientoDinero();
//        model.addAttribute("movimiento",movimiento);
//        model.addAttribute("mensaje",mensaje);
//        //List<Empresa> listaEmpresas=empresaServicio.getAllEmpresas //confirmar con nicolas
//        //model.addAttribute("empresaslist", listaEmpresas);
//        return "MovimientoDinero/agregarMovimiento";
//    }
}
