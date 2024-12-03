package sansuy.com.br.siagi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sansuy.com.br.siagi.dto.DTOEmpresa;
import sansuy.com.br.siagi.repository.EmpresaRepository;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

  @Autowired
  private EmpresaRepository repository;

  @GetMapping
  public ResponseEntity<List<DTOEmpresa>> buscar() {
    return ResponseEntity.ok(DTOEmpresa.converter(repository.findAll()));
  }

}
