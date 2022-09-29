package co.gov.misiontic.qualitysoft.appwebingresoegreso.servicios;

import co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface IUsarioService {

    //Metodo para ver todos los Usuarios registrados
    public List<Usuario> getAllUsuario();


    //Metodo para buscar empleados por ID
    public Optional<Usuario> getUsuarioById(Long idUsuario);

    //Metodo para buscar empleados por empresa
    public ArrayList<Usuario> obtenerPorEmpresa(Long idEmpresa);

    //Metodo para guardar o actualizar registros en Empleados
    public boolean saveOrUpdateUsuario(Usuario usua);

    //Metodo para eliminar un registro de Empleado por Id
    public boolean deleteUsuario(Long idUsuario);
}
