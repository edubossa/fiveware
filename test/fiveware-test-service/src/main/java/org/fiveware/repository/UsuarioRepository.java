package org.fiveware.repository;

import org.fiveware.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by wallace on 11/01/17.
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {


}
