package co.gov.misiontic.qualitysoft.appwebingresoegreso.repositorios;
import co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovimientoRepository extends JpaRepository<MovimientoDinero, Long> {

    //List<MovimientoDinero> findByEmpresaId(Long idEmpresa);
}