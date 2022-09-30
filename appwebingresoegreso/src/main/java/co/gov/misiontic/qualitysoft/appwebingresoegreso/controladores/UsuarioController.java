package co.gov.misiontic.qualitysoft.appwebingresoegreso.controladores;

import co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades.Empresa;
import co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades.Usuario;
import co.gov.misiontic.qualitysoft.appwebingresoegreso.servicios.IEmpresaServicio;
import co.gov.misiontic.qualitysoft.appwebingresoegreso.servicios.IUsarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;
import java.util.Map;

@Controller
public class UsuarioController {
    @Autowired
    private IUsarioService usuarioService;
    @Autowired
    private IEmpresaServicio empresaServicio;

    Map<String, Object> usuarioLogueado;
    @GetMapping("/VerUsuarios")
    public String viewUsuarios(Model model, @ModelAttribute("mensaje") String mensaje, @AuthenticationPrincipal OidcUser principal){
        List<Usuario> listaUsuarios=usuarioService.getAllUsuario();
        usuarioLogueado = principal.getClaims();
        model.addAttribute("usualist",listaUsuarios);
        model.addAttribute("mensaje",mensaje);
        model.addAttribute("user", usuarioLogueado);
        return "Usuarios/verUsuarios";
    }

    @GetMapping("/AgregarUsuario")
    public String nuevoUsuario(Model model, @ModelAttribute("mensaje") String mensaje){
        Usuario usua= new Usuario();
        model.addAttribute("usua",usua);
        model.addAttribute("mensaje",mensaje);
        List<Empresa> listaEmpresas=empresaServicio.getAllEmpresas(); //confirmar con nicolas
        model.addAttribute("emprelist", listaEmpresas);
        model.addAttribute("user", usuarioLogueado);
        return "Usuarios/agregarUsuarios";
    }


    @PostMapping("/GuardarUsuario")
    public String guardarUsuario(Usuario usua, RedirectAttributes redirectAttributes){
        if(usuarioService.saveOrUpdateUsuario(usua)==true){
            redirectAttributes.addFlashAttribute("mensaje","saveOK");
            return "redirect:/VerUsuarios";
        }
        redirectAttributes.addFlashAttribute("mensaje","saveError");
        return "redirect:/AgregarUsuario";
    }


    @GetMapping("/EditarUsuario/{idUsuario}")
    public String editarUsuario(Model model, @PathVariable Long idUsuario, @ModelAttribute("mensaje") String mensaje){
        Usuario usua=usuarioService.getUsuarioById(idUsuario).get();
        //Creamos un atributo para el modelo, que se llame igualmente user y es el que ira al html para llenar o alimentar campos
        model.addAttribute("usua",usua);
        model.addAttribute("mensaje", mensaje);
        List<Empresa> listaEmpresas=empresaServicio.getAllEmpresas(); //confirmar con nicolas
        model.addAttribute("emprelist", listaEmpresas);
        model.addAttribute("user", usuarioLogueado);
        return "Usuarios/editarUsuarios";
    }


    @PostMapping("/ActualizarUsuario")
    public String updateEmpleado(@ModelAttribute("usua") Usuario usua, RedirectAttributes redirectAttributes){
        if(usuarioService.saveOrUpdateUsuario(usua)){
            redirectAttributes.addFlashAttribute("mensaje","updateOK");
            return "redirect:/VerUsuarios";
        }
        redirectAttributes.addFlashAttribute("mensaje","updateError");
        return "redirect:/EditarUsuario"+usua.getIdUsuario();
    }


    @GetMapping("/EliminarUsuario/{idUsuario}")
    public String eliminarUsuario(@PathVariable Long idUsuario, RedirectAttributes redirectAttributes){
        if (usuarioService.deleteUsuario(idUsuario)==true){
            redirectAttributes.addFlashAttribute("mensaje","deleteOK");
            return "redirect:/VerUsuarios";
        }
        redirectAttributes.addFlashAttribute("mensaje", "deleteError");
        return "redirect:/VerUsuarios";
    }

    //Pendiente que nicolas cree el boton de ver los usuarios de una empresa
    @GetMapping("/Empresa/{idEmpresa}/Usuarios") //para filtrar usuarios por empresa
    public String verUsuariosPorEmpresa(@PathVariable("idEmpresa") Long idEmpresa, Model model){
        List<Usuario> listaUsuarios =usuarioService.obtenerPorEmpresa(idEmpresa);
        model.addAttribute("usualist",listaUsuarios);
        model.addAttribute("user", usuarioLogueado);
        return "Usuarios/verUsuarios";
    }
}
