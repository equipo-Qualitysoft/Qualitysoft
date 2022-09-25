package co.gov.misiontic.qualitysoft.appwebingresoegreso.controladores;

import co.gov.misiontic.qualitysoft.appwebingresoegreso.servicios.UsuarioService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class HomeController {
    UsuarioService usuarioService;
    Map<String, Object> usuarioLogueado;
    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal OidcUser principal) {
        if (principal != null) {
            //usuarioLogueado = this.usuarioService.getOrCreateUser(principal.getClaims());
            usuarioLogueado = principal.getClaims();
            model.addAttribute("user", usuarioLogueado);
            //model.addAttribute("profile",  principal.getClaims());
        }
        return "index.1html";
    }

    @GetMapping("/tablero")
    public String tablero(Model model, @AuthenticationPrincipal OidcUser principal) {
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
    @GetMapping("/movimiento")
    public String movimiento(){
        return "movimiento";
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
