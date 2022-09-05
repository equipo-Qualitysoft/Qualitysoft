package co.gov.misiontic.qualitysoft.appwebingresoegreso.controladores;

import co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades.Empresa;
import co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades.MovimientoDinero;
import co.gov.misiontic.qualitysoft.appwebingresoegreso.servicios.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpresaController {
    @Autowired
    EmpresaService empresaService;
    @GetMapping(path = "/empresas/{idEmpresa}", produces = "application/json")
    public Empresa listaEmpresaById(@PathVariable Long idEmpresa){
        return this.empresaService.getEmpresaById(idEmpresa);
    }


}
