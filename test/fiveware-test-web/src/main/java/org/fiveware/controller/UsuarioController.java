package org.fiveware.controller;

import org.fiveware.model.Usuario;
import org.fiveware.service.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by wallace on 11/01/17.
 */
@Controller
public class UsuarioController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UsuarioService usuarioService;


    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
    public ResponseEntity<Usuario> cadastrar(@ModelAttribute("user") Usuario usuario, Model model) {
        logger.info("UsuarioController.cadastrar");
        Usuario u;
        try {
             u = this.usuarioService.create(usuario);
            logger.info(u.toString());
        } catch (DataIntegrityViolationException e) {
            logger.error(e.getMessage());
            return new ResponseEntity<Usuario>(HttpStatus.CONFLICT);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ResponseEntity<Usuario>(HttpStatus.EXPECTATION_FAILED);
        }

        //model.addAttribute("user", u);

        return new ResponseEntity<Usuario>(u, HttpStatus.CREATED);
    }

}