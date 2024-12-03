package sansuy.com.br.siagi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sansuy.com.br.siagi.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}
