package co.gov.misiontic.qualitysoft.appwebingresoegreso.servicios;

import co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades.Empresa;
import co.gov.misiontic.qualitysoft.appwebingresoegreso.repositorios.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class EmpresaService {
    @Autowired
    private EmpresaRepository empresaRepository;

    public Empresa getEmpresaById(Long idEmpresa){
        return empresaRepository.findById(idEmpresa).get();
    }
}
