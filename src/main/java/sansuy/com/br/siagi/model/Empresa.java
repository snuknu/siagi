package sansuy.com.br.siagi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(catalog = "dbSIAGI", schema = "dbo")
public class Empresa {

  @Id
  @Column(name = "cod_empresa")
  private Long codigo;

  @Column(name = "nome_empresa")
  private String nome;

  @Column(name = "cnpj_empresa")
  private String cnpj;

  @Column(name = "nomeresumo_empresa")
  private String nomeResumido;

}
