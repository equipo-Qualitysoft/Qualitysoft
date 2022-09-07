package co.gov.misiontic.qualitysoft.appwebingresoegreso.controladores;


import co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades.Empresa;
import co.gov.misiontic.qualitysoft.appwebingresoegreso.servicios.IEmpresaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//etiquetas base para la creación de los controladores

@RestController
//@RequestMapping("/api")


public class EmpresaRestController {

    //el @Autowired me permite inyectar las interfaces
    //estamos inyectando la interfaz no la clase
    //en una clase se puede implementar cualquier numero de interfaces

    @Autowired
    private IEmpresaServicio empresaServicio;

    /*se crearan los controladores APIREST deacuerdo a los requisitos solicitados en el sprint 3 de la clase empresa
     */

    //Primera parte del primer Sprint 3
    //Se crea el Apirest Get

    @GetMapping("/enterprises")
    public List<Empresa> BuscarTodo () {

        return empresaServicio.BuscarTodo();

    }

    //Se crea el Apirest Post
    @PostMapping("/enterprises")
    public Empresa crearEmpresa  (@RequestBody Empresa empresa){

        return empresaServicio.crearEmpresa(empresa);

    }





    //Segunda parte del primer Sprint 3

    //Se crea el Apirest Get
    @GetMapping("/enterprises/{id}")

    public Empresa EncontrarId (@PathVariable int id){

        return empresaServicio.EncontrarId(id);

    }


    //se crea el Apirest Update
    @PutMapping("/enterprises/{id}")
    public Empresa UpdateEmpresa (@PathVariable int id, @RequestBody Empresa empresa){

        return empresaServicio.UpdateEmpresa(id, empresa);

    }

    //se crea el Apirest Delete
    @DeleteMapping("/enterprises/{id}")
    //el @Patchvariable me hace la busqueda
    public void deleteEmpresa (@PathVariable int id){

        empresaServicio.deleteEmpresa(id);

    }



}
