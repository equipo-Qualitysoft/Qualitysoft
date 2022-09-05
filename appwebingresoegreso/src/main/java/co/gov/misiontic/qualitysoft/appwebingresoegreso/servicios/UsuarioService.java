package co.gov.misiontic.qualitysoft.appwebingresoegreso.servicios;

import co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades.Usuario;
import co.gov.misiontic.qualitysoft.appwebingresoegreso.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario getUsuariosById(Long id){
        return usuarioRepository.findById(id).get();
    }
}
