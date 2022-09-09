package co.gov.misiontic.qualitysoft.appwebingresoegreso.controladores;

import co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades.Usuario;
import co.gov.misiontic.qualitysoft.appwebingresoegreso.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")

public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/users")
    public List<Usuario> verUsuario(){
        return usuarioService.getAllUsuario();
    }

    @PostMapping("/users")
    public Usuario guardarUsuario(@RequestBody Usuario user){
        return this.usuarioService.saveOrUpdateUsuario(user);
    }

    @GetMapping(path = "users/{id}")
    public Usuario usuarioPorID(@PathVariable("id") Long id){
        return this.usuarioService.getUsuarioById(id);
    }

    @GetMapping("enterprises/{id}/users")
    public ArrayList<Usuario> verUsuarioPorEmpresa(@PathVariable("id") Long id){
        return this.usuarioService.consultarPorEmpresa(id);
    }

    @PatchMapping("/users/{id}")
    public Usuario actualizarUsuario(@PathVariable("id") Long id,@RequestBody Usuario usuario){
        Usuario user=usuarioService.getUsuarioById(id);
        user.setNombre(usuario.getNombre());
        user.setCorreo(usuario.getCorreo());
        user.setEmpresa(usuario.getEmpresa());
        user.setImagen(usuario.getImagen());
        user.setTelefono(usuario.getTelefono());
        user.setRol(usuario.getRol());
        return usuarioService.saveOrUpdateUsuario(user);
    }

    @DeleteMapping("/users/{id}")
    public String DeleteUsuario(@PathVariable("id") Long id){
        boolean respuesta=usuarioService.deleteUsuario(id);
        if (respuesta){
            return "Se pudo eliminar correctamente el empleado con id "+id;
        }
        return "No se puedo eliminar correctamente el empleado con id "+id;
    }

}
