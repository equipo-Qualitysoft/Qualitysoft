package co.gov.misiontic.qualitysoft.appwebingresoegreso.servicios;

import co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface IUsarioService {

    public List<Usuario> getAllUsuario();

    public Optional<Usuario> getUsuarioById(Long idUsuario);

    public ArrayList<Usuario> consultarPorEmpresa(Long idUsuario);

    public boolean saveOrUpdateUsuario(Usuario usuario1);

    public boolean deleteUsuario(Long idUsuario);

}
