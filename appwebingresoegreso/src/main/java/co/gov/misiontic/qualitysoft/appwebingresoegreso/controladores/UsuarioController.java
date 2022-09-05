package co.gov.misiontic.qualitysoft.appwebingresoegreso.controladores;

import co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades.Usuario;
import co.gov.misiontic.qualitysoft.appwebingresoegreso.servicios.EmpresaService;
import co.gov.misiontic.qualitysoft.appwebingresoegreso.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @GetMapping(path = "/usuarios/{idUsuario}", produces = "application/json")
    public Usuario listaUsuariosById(@PathVariable Long idUsuario){
        return this.usuarioService.getUsuariosById(idUsuario);
    }


}
