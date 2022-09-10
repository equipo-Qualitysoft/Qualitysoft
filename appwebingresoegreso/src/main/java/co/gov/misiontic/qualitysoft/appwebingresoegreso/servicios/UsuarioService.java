package co.gov.misiontic.qualitysoft.appwebingresoegreso.servicios;

import co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades.Usuario;
import co.gov.misiontic.qualitysoft.appwebingresoegreso.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

    public Usuario getUsuarioById(Long idUsuario){
        return usuarioRepository.findById(idUsuario).get();
    }

    public ArrayList<Usuario> consultarPorEmpresa(Long idEmpresa){
        return usuarioRepository.findByusuario(idEmpresa);
    }

    public Usuario saveOrUpdateUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public boolean deleteUsuario(Long idUsuario){
        usuarioRepository.deleteById(idUsuario);
        if (this.usuarioRepository.findById(idUsuario).isPresent()){
            return false;
        }
        return true;
    }

}
