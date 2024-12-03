package sansuy.com.br.siagi.dto;

import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sansuy.com.br.siagi.model.Empresa;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DTOEmpresa {

  private Long codigo;
  private String nome;
  private String nomeResumido;
  private String cnpj;

  public DTOEmpresa(Empresa empresa) {
    this(
        empresa.getCodigo(),
        empresa.getNome(),
        empresa.getNomeResumido(),
        empresa.getCnpj());
  }

  public static List<DTOEmpresa> converter(List<Empresa> entityList) {
    return entityList
        .stream()
        .map(DTOEmpresa::new)
        .collect(Collectors.toList());
  }
}
