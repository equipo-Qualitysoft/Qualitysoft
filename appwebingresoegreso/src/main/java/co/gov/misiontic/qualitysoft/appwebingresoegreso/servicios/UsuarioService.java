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

    //Metodo para ver todos los usuarios registrados
    public List<Usuario> getAllUsuario() {
        List<Usuario> usuarioList=new ArrayList<>();
        usuarioRepository.findAll().forEach(usuario -> usuarioList.add(usuario));
        return usuarioList;
    }
    //Metodo pata buscar usuario por id
    public Optional<Usuario> getUsuarioById(Long idUsuario) {
        return usuarioRepository.findById(idUsuario);
    }
    //Metodo para buscar usuario por empresa
    public ArrayList<Usuario> obtenerPorEmpresa(Long idEmpresa) {
        return usuarioRepository.findByEmpresa(idEmpresa );
    }
    //Metodo para guardar o actualizar usuario
    public boolean saveOrUpdateUsuario(Usuario usua) {
        Usuario usu=usuarioRepository.save(usua);
        if (usuarioRepository.findById(usu.getIdUsuario())!=null){
            return true;
        }
        return false;
    }

    //Metodo pata eliminar registro de usuario por id
    public boolean deleteUsuario(Long idUsuario) {
        usuarioRepository.deleteById(idUsuario);
        if (this.usuarioRepository.findById(idUsuario).isPresent()){
            return false;
        }
        return true;
    }

}



