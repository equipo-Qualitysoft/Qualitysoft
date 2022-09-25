package co.gov.misiontic.qualitysoft.appwebingresoegreso.controladores;

import co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades.MovimientoDinero;
import co.gov.misiontic.qualitysoft.appwebingresoegreso.servicios.IMovimientoService;
import co.gov.misiontic.qualitysoft.appwebingresoegreso.servicios.MovimientoService;
import co.gov.misiontic.qualitysoft.appwebingresoegreso.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    IMovimientoService movimientoService;
    Map<String, Object> usuarioLogueado;


    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal OidcUser principal) {
        if (principal != null) {
            //usuarioLogueado = this.usuarioService.getOrCreateUser(principal.getClaims());
            usuarioLogueado = principal.getClaims();
            model.addAttribute("user", usuarioLogueado);
            //model.addAttribute("profile",  principal.getClaims());
        }
        return "index";
    }

    @GetMapping("/tablero")
    public String tablero(Model model) {
        model.addAttribute("user",  usuarioLogueado);
        return "tablero";
    }

    @GetMapping("/empresa")
    public String empresa(){
        return "empresa";
    }

    @GetMapping("/usuario")
    public String usuario(){
        return "usuario";
    }


    @GetMapping("/verMovimiento")
    public String viewMovimiento(Model model,@ModelAttribute("mensaje") String mensaje) {
        List<MovimientoDinero> movimientos = this.movimientoService.getMovimientoDineroList();
        model.addAttribute("movimientos",  movimientos);
        model.addAttribute("mensaje",  mensaje);
        return "MovimientoDinero/verMovimiento";
    }



    @GetMapping("/cliente-proveedor")
    public String clienteProveedor(){
        return "cliente-proveedor";
    }
    @GetMapping("/articulo")
    public String articulo(){
        return "articulo";
    }


}
