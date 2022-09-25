package co.gov.misiontic.qualitysoft.appwebingresoegreso.controladores;

import co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades.Usuario;
import co.gov.misiontic.qualitysoft.appwebingresoegreso.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    UsuarioService usuarioService;
    Usuario usuarioLogueado;
    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal OidcUser principal) {
        if (principal != null) {
            //usuarioLogueado = this.usuarioService.getOrCreateUser(principal.getClaims());
            //model.addAttribute("user", user);
            //usuarioLogueado = (Usuario) principal.getClaims();
            model.addAttribute("profile",  principal.getClaims());
        }
        return "index";
    }

    @GetMapping("/tablero")
    public String tablero(Model model, @AuthenticationPrincipal OidcUser principal) {
        model.addAttribute("profile",  principal.getClaims());
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
