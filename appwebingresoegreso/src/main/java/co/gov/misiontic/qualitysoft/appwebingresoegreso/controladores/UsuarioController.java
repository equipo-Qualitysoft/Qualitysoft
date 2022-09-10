package co.gov.misiontic.qualitysoft.appwebingresoegreso.controladores;

import co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades.Usuario;
import co.gov.misiontic.qualitysoft.appwebingresoegreso.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")

public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    //@ResponseStatus(HttpStatus.OK)
    @GetMapping("/users")
    public List<Usuario> verUsuario(){
        return usuarioService.getAllUsuario();
    }

    @PostMapping("/users")
    public Usuario guardarUsuario(@RequestBody Usuario user){
        return this.usuarioService.saveOrUpdateUsuario(user);
    }

    @GetMapping(path = "users/{idUsuario}")
    public Usuario usuarioPorID(@PathVariable("idUsuario") Long idUsuario){
        return this.usuarioService.getUsuarioById(idUsuario);
    }

    @GetMapping("enterprises/{idEmpresa}/users")
    public ArrayList<Usuario> verUsuarioPorEmpresa(@PathVariable("idEmpresa") Long idEmpresa){
        return this.usuarioService.consultarPorEmpresa(idEmpresa);
    }

    @PatchMapping("/users/{idUsuario}")
    public Usuario actualizarUsuario(@PathVariable("idUsuario") Long idUsuario,@RequestBody Usuario usuario){
        Usuario user=usuarioService.getUsuarioById(idUsuario);
        user.setNombre(usuario.getNombre());
        user.setCorreo(usuario.getCorreo());
        user.setEmpresa(usuario.getEmpresa());
        user.setImagen(usuario.getImagen());
        user.setTelefono(usuario.getTelefono());
        user.setRol(usuario.getRol());
        return usuarioService.saveOrUpdateUsuario(user);
    }

    @DeleteMapping("/users/{idUsuario}")
    public String DeleteUsuario(@PathVariable("idUsuario") Long idUsuario){
        boolean respuesta=usuarioService.deleteUsuario(idUsuario);
        if (respuesta){
            return "Se pudo eliminar correctamente el Usuario con id "+idUsuario;
        }
        return "No se puedo eliminar correctamente el Usuario con id "+idUsuario;
    }

}
