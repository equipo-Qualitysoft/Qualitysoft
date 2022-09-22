package co.gov.misiontic.qualitysoft.appwebingresoegreso.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "index";
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
