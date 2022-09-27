package co.gov.misiontic.qualitysoft.appwebingresoegreso.controladores;

import co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades.*;
import co.gov.misiontic.qualitysoft.appwebingresoegreso.servicios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Controller
//@RequestMapping("/movimiento")
//@RequestMapping("/empresas/{idEmpresa}")
public class MovimientoController {
    @Autowired
    private IMovimientoService movimientoService;
    @Autowired
    private IUsarioService usuarioService;

    @Autowired
    private IEmpresaServicio empresaServicio;

    @Autowired
    private IArticuloService articuloService;

    @Autowired
    private IClienteProveedorService clienteProveedorService;

    Map<String, Object> usuarioLogueado;

    public MovimientoController(MovimientoService movimientoService) {
        this.movimientoService = movimientoService;
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/movements")
    public List<MovimientoDinero> movimientoDineroList(){
        return this.movimientoService.getMovimientoDineroList();
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/enterprises/{idEmpresa}/movements")
    public List<MovimientoDinero> movimientoDineroListByEmpresa(@PathVariable("idEmpresa") Long idEmpresa){
        return this.movimientoService.getMovimientoDineroListByEmpresa(idEmpresa);
    }
    @GetMapping("/enterprises/{idEmpresa}/movements/{idMovimiento}")
    public ResponseEntity<MovimientoDinero> movimientoDineroById(@PathVariable("idEmpresa") Long idEmpresa, @PathVariable("idMovimiento") Long idMovimiento){
        MovimientoDinero movimientoDinero = this.movimientoService.getMovimientoById(idMovimiento);
        if(movimientoDinero == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(movimientoDinero,HttpStatus.OK);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/enterprises/{idEmpresa}/movements")
    public MovimientoDinero createMovimientoDinero(@PathVariable("idEmpresa") Long idEmpresa,@RequestBody MovimientoDinero movimientoDinero){
        return this.movimientoService.createMovimiento(idEmpresa, movimientoDinero);
    }
//
//    @ResponseStatus(HttpStatus.OK)
//    @PatchMapping("/enterprises/{idEmpresa}/movements/{idMovimiento}")
//    public MovimientoDinero updateMovimientoDinero(@PathVariable("idEmpresa") Long idEmpresa,@PathVariable("idMovimiento") Long idMovimiento,@RequestBody MovimientoDinero movimientoDinero){
//        return this.movimientoService.updateMovimiento(movimientoDinero);
//    }
//

    // BORRA MOVIMIENTO POR ID
    @DeleteMapping("/VerMovimientos/{id}")
    public RedirectView deleteMovimiento(@PathVariable("id") Long id){
        this.movimientoService.deleteMovimiento(id);
        return new RedirectView("/VerMovimientos");
    }


    @GetMapping("/users/{idUsuario}/movements")
    public List<MovimientoDinero> getMovimientoListByUsuario(@PathVariable("idUsuario") Long idUsuario){
        return this.movimientoService.getMovimientoListByUsuario(idUsuario);
    }

    // CIRREGIR DESDE AQUI
        @GetMapping("/AgregarMovimiento")
    public String nuevoMovimiento(Model model, @ModelAttribute("mensaje") String mensaje, @AuthenticationPrincipal OidcUser principal){
        MovimientoDinero mov = new MovimientoDinero();
        mov.setFecha(LocalDate.now());
        usuarioLogueado = principal.getClaims();
        List <Usuario> users = usuarioService.getAllUsuario();
        List <Empresa> empresas = empresaServicio.BuscarTodo();
        List<Articulo> articulos = articuloService.getAllArticulos();
        List<ClienteProveedor> clientes = clienteProveedorService.getAllClientesProveedores();
        model.addAttribute("users", users);
        model.addAttribute("empresas", empresas);
        model.addAttribute("articulos", articulos);
        model.addAttribute("clientes", clientes);
        model.addAttribute("user", usuarioLogueado);
        model.addAttribute("mov",mov);
        model.addAttribute("mensaje",mensaje);
           System.out.println("HA INGRESADO A ****  @GetMapping(AgregarMovimiento)");
        return "MovimientoDinero/agregarMovimiento";
    }

    @PostMapping("/GuardarMovimiento")
    public String guardarMovimiento(MovimientoDinero movimiento, RedirectAttributes redirectAttributes){
        if (movimiento.getMonto()>0)            movimiento.setConcepto("VENTA");
        else if (movimiento.getMonto()<0)       movimiento.setConcepto("COMPRA");

        if(movimientoService.saveOrUpdateMovimiento(movimiento)==true){
            redirectAttributes.addFlashAttribute("mensaje","saveOK");
            System.out.println("HA INGRESADO A GUARDAR movimiento");
            return "redirect:/VerMovimientos";
        }
        redirectAttributes.addFlashAttribute("mensaje","saveError");
        System.out.println("HA INGRESADO A GUARDAR movimiento ERROR");

        return "redirect:/AgregarMovimiento";
    }

    @GetMapping("/EditarMovimiento/{idMovimiento}")
    public String editarMovimiento(Model model, @PathVariable Long idMovimiento, @ModelAttribute("mensaje") String mensaje){
        MovimientoDinero mov= movimientoService.getMovimientoById(idMovimiento);
        List <Usuario> users = usuarioService.getAllUsuario();
        List <Empresa> empresas = empresaServicio.BuscarTodo();
        List<Articulo> articulos = articuloService.getAllArticulos();
        //Creamos un atributo para el modelo, que se llame igualmente user y es el que ira al html para llenar o alimentar campos
        model.addAttribute("mov",mov);
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("users", users);
        model.addAttribute("empresas", empresas);
        model.addAttribute("articulos", articulos);
        model.addAttribute("user", usuarioLogueado);
        System.out.println("HA INGRESADO A EDITAR  movimiento");

        return "MovimientoDinero/editarMovimiento";
    }

    @PostMapping("/ActualizarMovimiento")
    public String updateMovimiento(@ModelAttribute("emp") @DateTimeFormat(pattern="YYYY-MM-DD") MovimientoDinero mov, RedirectAttributes redirectAttributes){
        if(movimientoService.saveOrUpdateMovimiento(mov)){
            redirectAttributes.addFlashAttribute("mensaje","updateOK");
            System.out.println("HA INGRESADO A ACTUALIZAR movimiento");

            return "redirect:/VerMovimientos";

        }
        redirectAttributes.addFlashAttribute("mensaje","updateError");
        System.out.println("HA INGRESADO A ACTUALIZAR movimiento ERROR");

        return "redirect:/EditarMovimiento"+ mov.getIdMovimiento();

    }

}
