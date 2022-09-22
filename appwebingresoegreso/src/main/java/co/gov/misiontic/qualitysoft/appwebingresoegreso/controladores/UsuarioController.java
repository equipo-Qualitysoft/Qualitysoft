package co.gov.misiontic.qualitysoft.appwebingresoegreso.controladores;

import co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades.Empresa;
import co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades.Usuario;
import co.gov.misiontic.qualitysoft.appwebingresoegreso.servicios.IUsarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;

@Controller
public class UsuarioController {
    @Autowired
    private IUsarioService usuarioService;
    @GetMapping("/VerUsuarios")
    public String viewUsuarios(Model model, @ModelAttribute("mensaje") String mensaje){
        List<Usuario> listaUsuarios=usuarioService.getAllUsuario();
        model.addAttribute("usuarioslist",listaUsuarios);
        model.addAttribute("mensaje",mensaje);
        return "verUsuarios";
    }

    @GetMapping("/AgregarUsuario")
    public String nuevoUsuario(Model model, @ModelAttribute("mensaje") String mensaje){
        Usuario user= new Usuario();
        model.addAttribute("user",user);
        model.addAttribute("mensaje",mensaje);
        //List<Empresa> listaEmpresas=empresaServicio.getAllEmpresas //confirmar con nicolas
        //model.addAttribute("empresaslist", listaEmpresas);
        return "agregarUsuarios";
    }
    @PostMapping("/GuardarUsuario")
    public String guardarUsuario(Usuario usuario1, RedirectAttributes redirectAttributes){
        if(usuarioService.saveOrUpdateUsuario(usuario1)==true){
            redirectAttributes.addFlashAttribute("mensaje","saveOK");
            return "redirect:/VerUsuarios";
        }
        redirectAttributes.addFlashAttribute("mensaje","saveError");
        return "redirect:/AgregarUsuario";
    }
    @GetMapping("/EditarUsuario/{idUsuario}")
    public String editarUsuario(Model model, @PathVariable Long idUsuario, @ModelAttribute("mensaje") String mensaje){
        Usuario user=usuarioService.getUsuarioById(idUsuario).get();
        //Creamos un atributo para el modelo, que se llame igualmente user y es el que ira al html para llenar o alimentar campos
        model.addAttribute("user",user);
        model.addAttribute("mensaje", mensaje);
        //List<Empresa> listaEmpresas=empresaServicio.getAllEmpresas //confirmar con nicolas
        //model.addAttribute("empresaslist", listaEmpresas);
        return "editarUsuarios";
    }

    @PostMapping("/ActualizarUsuario")
    public String updateEmpleado(@ModelAttribute("user") Usuario user, RedirectAttributes redirectAttributes){
        if(usuarioService.saveOrUpdateUsuario(user)){
            redirectAttributes.addFlashAttribute("mensaje","updateOK");
            return "redirect:/VerUsuarios";
        }
        redirectAttributes.addFlashAttribute("mensaje","updateError");
        return "redirect:/EditarUsuario"+user.getIdUsuario();

    }
    @GetMapping("/EliminarUsuario/{idUsuario}")
    public String eliminarUsuario(@PathVariable Long idUsuario, RedirectAttributes redirectAttributes){
        if (usuarioService.deleteUsuario(idUsuario)==true){
            redirectAttributes.addFlashAttribute("mensaje","deleteOK");
            return "redirect:/VerUsuarioS";
        }
        redirectAttributes.addFlashAttribute("mensaje", "deleteError");
        return "redirect:/VerUsuarios";
    }
    //Pendiente que nicolas cree el boton de ver los usuarios de una empresa
    @GetMapping("/Empresas/{idEmpresa}/Usuarios") //para filtrar empleados por empresa
    public String verUsuariosPorEmpresa(@PathVariable("idEmpresa") Long idEmpresa, Model model){
        List<Usuario> listaUsuarios=usuarioService.consultarPorEmpresa(idEmpresa);
        model.addAttribute("usuarioslist",listaUsuarios);
        return "verUsuarios";
    }
}
