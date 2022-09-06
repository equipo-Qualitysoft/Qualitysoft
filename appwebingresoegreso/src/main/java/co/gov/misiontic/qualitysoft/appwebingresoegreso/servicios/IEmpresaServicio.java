package co.gov.misiontic.qualitysoft.appwebingresoegreso.servicios;

import co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades.Empresa;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IEmpresaServicio {

    //para los metodos de la primera parte del sprint 3

    public List<Empresa> BuscarTodo ();

    public Empresa crearEmpresa  (Empresa empresa);




    //para los metodos de la segunda parte del sprint 3

    public Empresa EncontrarId(int id);

    public Empresa UpdateEmpresa (int id, Empresa empresa);

    public void deleteEmpresa ( int id);





}
