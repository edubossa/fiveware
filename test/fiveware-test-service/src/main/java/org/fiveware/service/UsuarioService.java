package org.fiveware.service;

import org.fiveware.model.Usuario;
import org.fiveware.repository.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wallace on 11/01/17.
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UsuarioService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public Usuario create(Usuario usuario) {
        logger.info("UsuarioService.create");
        Usuario u = this.usuarioRepository.save(usuario);
        logger.info("Usuario cadastrado com sucesso!");
        return u;
    }

}
