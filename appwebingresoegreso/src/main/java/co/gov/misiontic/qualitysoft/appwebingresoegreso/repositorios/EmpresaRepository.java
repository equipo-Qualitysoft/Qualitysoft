package co.gov.misiontic.qualitysoft.appwebingresoegreso.repositorios;

import co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}