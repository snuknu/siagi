package sansuy.com.br.siagi.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sansuy.com.br.siagi.enumerations.UsuarioStatus;
import sansuy.com.br.siagi.model.Usuario;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DTOUsuario {

  private Long codigo;
  private String nome;
  private String sobrenome;
  private String centroDeCusto;
  private String username;
  private byte[] senha;
  private byte[] senhaDev;
  private Integer ordem;
  private UsuarioStatus status;
  private LocalDate dataCadastro;
  private String usuarioCadastro;
  private LocalDate dataAlteracao;
  private String usuarioAlteracao;
  private Integer pin;
  private Integer dev;

  public DTOUsuario(Long codigo, String nome, String sobrenome) {

    this.codigo = codigo;
    this.nome = nome;
    this.sobrenome = sobrenome;
  }

  public DTOUsuario(Usuario usuario) {

    this(usuario.getCodigo(), usuario.getNome(), usuario.getSobrenome(), usuario.getCentroDeCusto(),
        usuario.getUsername(), usuario.getSenha(), usuario.getSenhaDev(), usuario.getOrdem(),
        usuario.getStatus(), usuario.getDataCadastro(), usuario.getUsuarioCadastro(),
        usuario.getDataAlteracao(), usuario.getUsuarioAlteracao(), usuario.getPin(),
        usuario.getDev());
  }

  public static List<DTOUsuario> converter(List<Usuario> entityList) {
    return entityList.stream().map(DTOUsuario::new).collect(Collectors.toList());
  }
}
