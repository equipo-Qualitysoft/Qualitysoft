package co.gov.misiontic.qualitysoft.appwebingresoegreso.servicios;

import co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades.Empresa;
import co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades.Usuario;
import co.gov.misiontic.qualitysoft.appwebingresoegreso.repositorios.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaServicio implements IEmpresaServicio {


    @Autowired
    private EmpresaRepository empresaRepository;
    @Override
    public List<Empresa> BuscarTodo() {
        List<Empresa> Empresas = (List<Empresa>) empresaRepository.findAll();
        return Empresas;
    }
/*
    @Override
    public Empresa crearEmpresa(Empresa empresa) {
        Empresa newEmpresa = empresaRepository.save(empresa);
        return newEmpresa;
    }


 */
   /* @Override
    public Empresa EncontrarId(Long idEmpresa) {
        Optional<Empresa> empresa = empresaRepository.findById(idEmpresa);
        return empresa.get();
    }

    */

    /*
    @Override
    public Empresa UpdateEmpresa(Long id, Empresa empresa) {

        Empresa emp= EncontrarId(id);
        emp.setNombre(empresa.getNombre());
        emp.setNit(empresa.getNit());
        emp.setTelefono(empresa.getTelefono());
        emp.setDireccion(empresa.getDireccion());
        emp.setFecha(empresa.getFecha());

        return empresaRepository.save(emp);

    }

     */
/*
    @Override
    public void deleteEmpresa(Long id) {
        empresaRepository.deleteById(id);

    }


 */
    @Override
    public boolean saveOrUpdateEmpresa(Empresa empresa1) {
        Empresa emp=empresaRepository.save(empresa1);
        if (empresaRepository.findById(emp.getIdEmpresa())!=null){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteEmpresa(Long idEmpresa) {
        empresaRepository.deleteById(idEmpresa);
        if (this.empresaRepository.findById(idEmpresa).isPresent()){
            return false;
        }
        return true;
    }

    @Override
    public Optional<Empresa> getEmpresaById(Long idEmpresa) {
        return empresaRepository.findById(idEmpresa);
    }
}
/*
e

 */