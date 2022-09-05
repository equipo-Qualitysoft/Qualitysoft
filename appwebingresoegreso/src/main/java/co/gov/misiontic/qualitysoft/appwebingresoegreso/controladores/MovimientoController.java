package co.gov.misiontic.qualitysoft.appwebingresoegreso.controladores;

import co.gov.misiontic.qualitysoft.appwebingresoegreso.Util.UtilidadesComunes;
import co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades.Empresa;
import co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades.MovimientoDinero;
import co.gov.misiontic.qualitysoft.appwebingresoegreso.servicios.EmpresaService;
import co.gov.misiontic.qualitysoft.appwebingresoegreso.servicios.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/empresas/{idEmpresa}")
public class MovimientoController {
    @Autowired
    MovimientoService movimientoService;
        @Autowired
    UtilidadesComunes utilidadesComunes;
    @GetMapping(path = "/movimientos", produces = "application/json")
    public List<MovimientoDinero> listaMovimientos(){
        utilidadesComunes.mensaje();
        return this.movimientoService.getAllMovimientos();
    }

    @Autowired
    EmpresaService empresaService;
    @GetMapping(path = "/empresas/{idEmpresa}/movimientos", produces = "application/json")
    public List <MovimientoDinero> listaMovimientosByIdEmpresa(@PathVariable Long idEmpresa){
        return this.movimientoService.getMovimientosByIdEmpresa(idEmpresa);
    }


}
