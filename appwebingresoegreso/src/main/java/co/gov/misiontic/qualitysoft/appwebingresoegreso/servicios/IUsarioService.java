package co.gov.misiontic.qualitysoft.appwebingresoegreso.servicios;

import co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades.Usuario;

import java.util.ArrayList;
import java.util.List;

public interface IUsarioService {

    public List<Usuario> getAllUsuario();

    public Usuario getUsuarioById(Long idUsuario);

    public ArrayList<Usuario> consultarPorEmpresa(Long idUsuario);

    public Usuario saveOrUpdateUsuario(Usuario usuario);

    public boolean deleteUsuario(Long idUsuario);

}
