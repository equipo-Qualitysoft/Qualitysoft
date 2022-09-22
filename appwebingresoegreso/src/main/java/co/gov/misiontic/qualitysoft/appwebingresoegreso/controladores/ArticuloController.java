package co.gov.misiontic.qualitysoft.appwebingresoegreso.controladores;

import co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades.Articulo;
import co.gov.misiontic.qualitysoft.appwebingresoegreso.servicios.IArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticuloController {
    @Autowired
    IArticuloService articuloService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/articulos")
    public List<Articulo> verArticulos(){
        return articuloService.getAllArticulos();
    }
}
