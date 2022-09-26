package co.gov.misiontic.qualitysoft.appwebingresoegreso.controladores;

import co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades.Empresa;
import co.gov.misiontic.qualitysoft.appwebingresoegreso.servicios.IEmpresaServicio;
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
public class EmpresaController {


    @Autowired
    private IEmpresaServicio empresaServicio;

    //Apartir de aqui, se crean los controladores que direccionan a las vistas
    
    @GetMapping ("/VerEmpresas")
    public String viewEmpresas(Model model, @ModelAttribute("mensaje") String mensaje){
        List<Empresa> listaEmpresas=empresaServicio.BuscarTodo();
        model.addAttribute("emplist",listaEmpresas);
        model.addAttribute("mensaje",mensaje);
        return "Empresa/verEmpresa"; //Llamamos al HTML
    }

    @GetMapping("/AgregarEmpresa")
    public String nuevaEmpresa(Model model, @ModelAttribute("mensaje") String mensaje){
        Empresa emp= new Empresa();
        model.addAttribute("emp",emp);
        model.addAttribute("mensaje",mensaje);
        return "Empresa/agregarEmpresa";
    }

    @PostMapping("/GuardarEmpresa")
    public String guardarEmpresa(Empresa empresa1, RedirectAttributes redirectAttributes){
        if(empresaServicio.saveOrUpdateEmpresa(empresa1)==true){
            redirectAttributes.addFlashAttribute("mensaje","saveOK");
            return "redirect:/VerEmpresas";
        }
        redirectAttributes.addFlashAttribute("mensaje","saveError");
        return "redirect:/AgregarEmpresa";
    }

    @GetMapping("/EditarEmpresa/{idEmpresa}")
    public String editarEmpresa(Model model, @PathVariable Long idEmpresa, @ModelAttribute("mensaje") String mensaje){
        Empresa emp= empresaServicio.getEmpresaById(idEmpresa).get();
        //Creamos un atributo para el modelo, que se llame igualmente user y es el que ira al html para llenar o alimentar campos
        model.addAttribute("emp",emp);
        model.addAttribute("mensaje", mensaje);
        //List<Empresa> listaEmpresas=empresaServicio.getAllEmpresas //confirmar con nicolas
        //model.addAttribute("empresaslist", listaEmpresas);
        return "Empresa/editarEmpresa";
    }

    @PostMapping("/ActualizarEmpresa")
    public String updateEmpresa(@ModelAttribute("emp") Empresa emp, RedirectAttributes redirectAttributes){
        if(empresaServicio.saveOrUpdateEmpresa(emp)){
            redirectAttributes.addFlashAttribute("mensaje","updateOK");
            return "redirect:/VerEmpresas";
        }
        redirectAttributes.addFlashAttribute("mensaje","updateError");
        return "redirect:/EditarEmpresa"+emp.getIdEmpresa();

    }

    @GetMapping("/EliminarEmpresa/{idEmpresa}")
    public String eliminarEmpresa(@PathVariable Long idEmpresa, RedirectAttributes redirectAttributes){
        if (empresaServicio.deleteEmpresa(idEmpresa)==true){
            redirectAttributes.addFlashAttribute("mensaje","deleteOK");
            return "redirect:/VerEmpresas";
        }
        redirectAttributes.addFlashAttribute("mensaje", "deleteError");
        return "redirect:/VerEmpresas";
    }
/*
    @PostMapping("/GuardarEmpresa")
    public String guardarEmpresa(Empresa emp, RedirectAttributes redirectAttributes){
        if(empresaServicio.saveOrUpdateEmpresa(emp)==true){
            redirectAttributes.addFlashAttribute("mensaje","saveOK");
            return "redirect:Empresa/VerEmpresa";
        }
        redirectAttributes.addFlashAttribute("mensaje","saveError");
        return "redirect:Empresa/agregarEmpresa";
    }

 */

/*
    @Autowired
    private IUsarioService usarioService;

    @Autowired
    private IMovimientoService movimientoService;

    private final Logger LOG = Logger.getLogger(""+EmpresaController.class);
    private Validator validator;
*/


}
