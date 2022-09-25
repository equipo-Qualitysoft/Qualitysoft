package co.gov.misiontic.qualitysoft.appwebingresoegreso.repositorios;

import co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades.ClienteProveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteProveedorRepository extends JpaRepository<ClienteProveedor, Long> {

}
