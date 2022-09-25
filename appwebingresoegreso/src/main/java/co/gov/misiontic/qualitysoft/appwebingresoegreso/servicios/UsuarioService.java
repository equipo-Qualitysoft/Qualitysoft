package co.gov.misiontic.qualitysoft.appwebingresoegreso.servicios;

import co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades.Usuario;
import co.gov.misiontic.qualitysoft.appwebingresoegreso.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UsuarioService implements IUsarioService{

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<Usuario> getAllUsuario(){
        List<Usuario> usuarioList = new ArrayList<>();
        usuarioRepository.findAll().forEach(usuario -> usuarioList.add(usuario));
        return usuarioList;
    }

    public Optional<Usuario> getUsuarioById(Long idUsuario){
        return usuarioRepository.findById(idUsuario);
    }

    public ArrayList<Usuario> consultarPorEmpresa(Long idEmpresa){
        return usuarioRepository.findByusuario(idEmpresa);
    }

    public boolean saveOrUpdateUsuario(Usuario usuario1){
        Usuario user=usuarioRepository.save(usuario1);
        if (usuarioRepository.findById(user.getIdUsuario())!=null){
            return true;
        }
        return false;
    }

    public Usuario  createUser(Usuario newUser){
        return usuarioRepository.save(newUser);
    }

    public boolean deleteUsuario(Long idUsuario){
        usuarioRepository.deleteById(idUsuario);
        if (this.usuarioRepository.findById(idUsuario).isPresent()){
            return false;
        }
        return true;
    }

    public Usuario getOrCreateUser(Map<String, Object> userData){
        String email = (String) userData.get("email");
        Usuario usuario = usuarioRepository.findByCorreo(email);
        if(usuario == null){
            String name = (String) userData.get("name");
            String image = (String) userData.get("image");
            String auth0id = (String) userData.get("sub");

            Usuario newUser = new Usuario(email=email, image=image, auth0id= auth0id);
            return createUser(newUser);
        }
        System.out.println(usuario.getCorreo());
        return usuario;
    }
}
