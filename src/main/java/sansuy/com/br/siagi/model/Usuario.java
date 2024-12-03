package sansuy.com.br.siagi.model;

import java.time.LocalDate;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sansuy.com.br.siagi.enumerations.UsuarioStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(catalog = "dbSIAGI", schema = "dbo")
public class Usuario {

  @Id
  @Column(name = "usuario_cod")
  private Long codigo;

  @Column(name = "usuario_nome")
  private String nome;

  @Column(name = "usuario_sobrenome")
  private String sobrenome;

  @Column(name = "usuario_ccusto")
  private String centroDeCusto;

  @Column(name = "usuario_username")
  private String username;

  @Lob
  @Column(name = "usuario_senha", columnDefinition = "BLOB")
  private byte[] senha;

  @Lob
  @Column(name = "usuario_senha_dev", columnDefinition = "BLOB")
  private byte[] senhaDev;

  @Column(name = "usuario_ordem")
  private Integer ordem;

  @Enumerated(EnumType.ORDINAL)
  @Column(name = "usuario_status")
  private UsuarioStatus status;

  @Column(name = "log_datacad")
  private LocalDate dataCadastro;

  @Column(name = "log_usercad")
  private String usuarioCadastro;

  @Column(name = "log_dataalt")
  private LocalDate dataAlteracao;

  @Column(name = "log_useralt")
  private String usuarioAlteracao;

  @Column(name = "usuario_pin")
  private Integer pin;

  @Column(name = "usuario_dev")
  private Integer dev;

  @Basic(fetch = FetchType.LAZY)
  @Column(name = "usuario_tipo")
  private String tipo;

  @Basic(fetch = FetchType.LAZY)
  @Column(name = "usuario_obs")
  private String observacao;

  @Basic(fetch = FetchType.LAZY)
  @Column(name = "usuario_password")
  private String password;
}
