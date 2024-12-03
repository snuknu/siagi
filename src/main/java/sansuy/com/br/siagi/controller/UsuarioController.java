package sansuy.com.br.siagi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sansuy.com.br.siagi.dto.DTOUsuario;
import sansuy.com.br.siagi.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

  @Autowired
  private UsuarioRepository repository;

  @GetMapping
  public ResponseEntity<List<DTOUsuario>> buscar() {
    return ResponseEntity.ok(DTOUsuario.converter(repository.findAll()));
  }

}
