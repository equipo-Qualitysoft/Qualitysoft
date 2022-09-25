package co.gov.misiontic.qualitysoft.appwebingresoegreso.controladores;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal OidcUser principal) {
        if (principal != null) {
            model.addAttribute("profile", principal.getClaims());
            System.out.println(principal.getClaims());
        }
        return "index";
    }

    @GetMapping("/home")
    public String home(){
        return "pagina2";
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
