package co.gov.misiontic.qualitysoft.appwebingresoegreso.repositorios;

import co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticuloRepository extends JpaRepository <Articulo, Long> {

}
