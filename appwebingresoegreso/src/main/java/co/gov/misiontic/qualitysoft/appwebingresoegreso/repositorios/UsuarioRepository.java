package co.gov.misiontic.qualitysoft.appwebingresoegreso.repositorios;

import co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query(value="select * from usuarios e where empresa_id = :id", nativeQuery = true)
    public abstract ArrayList<Usuario> findByusuario(@Param("id") Long id);
}

