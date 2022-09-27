package co.gov.misiontic.qualitysoft.appwebingresoegreso.controladores;

import co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades.Articulo;
import co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades.ClienteProveedor;
import co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades.MovimientoDinero;
import co.gov.misiontic.qualitysoft.appwebingresoegreso.repositorios.ClienteProveedorRepository;
import co.gov.misiontic.qualitysoft.appwebingresoegreso.servicios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    IMovimientoService movimientoService;
    @Autowired
    IArticuloService articuloService;
    @Autowired
    IClienteProveedorService clienteProveedorService;
    Map<String, Object> usuarioLogueado;

    @Autowired
    ClienteProveedorRepository clienteRepository;


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


    @GetMapping("/VerMovimientos")
    public String viewMovimiento(Model model,@ModelAttribute("mensaje") String mensaje) {
        List<MovimientoDinero> movimientos = this.movimientoService.getMovimientoDineroList();
        model.addAttribute("movimientos",  movimientos);
        model.addAttribute("mensaje",  mensaje);
        return "MovimientoDinero/verMovimiento";
    }

    @GetMapping("/VerArticulos")
    public String verArticulos(Model model) {
        List<Articulo> articulos = this.articuloService.getAllArticulos();
        model.addAttribute("articulos",  articulos);
        return "Articulos/verArticulos";
    }


    @GetMapping("/VerClientesProveedores")
    public String verClienteProveedor(Model model) {
        //List<ClienteProveedor> clientesProveedores = this.clienteProveedorService.getAllClientesProveedores();
        List<ClienteProveedor> clientesProveedores = clienteRepository.findAll();
        if (clientesProveedores.isEmpty()) {
            System.out.println("No hay clientes o proveedores registrados");
        }
        model.addAttribute("clientesProveedores",  clientesProveedores);
        return "ClientesProveedores/verClientesProveedores";
    }


}
