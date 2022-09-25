package co.gov.misiontic.qualitysoft.appwebingresoegreso.servicios;

import co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades.Empresa;
import co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades.Usuario;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface IEmpresaServicio {

    //para los metodos de la primera parte del sprint 3

    public List<Empresa> BuscarTodo ();

/*  public Empresa crearEmpresa  (Empresa empresa);


 */


    //para los metodos de la segunda parte del sprint 3

    /*
    public Empresa EncontrarId(Long id);

     */
/*
    public Empresa UpdateEmpresa (Long id, Empresa empresa);

    public void deleteEmpresa ( Long id);
 */

    public boolean saveOrUpdateEmpresa(Empresa empresa1);

    public boolean deleteEmpresa(Long idEmpresa);

    public Optional<Empresa> getEmpresaById(Long idEmpresa);





}
