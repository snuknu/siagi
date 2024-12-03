package sansuy.com.br.siagi.config;

import java.util.Locale;
import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import sansuy.com.br.siagi.enumerations.BancoTipo;

@Configuration
@PropertySource("classpath:application.properties")
public class DynamicCustomNamingStrategy implements PhysicalNamingStrategy {


  @Autowired
  private Environment env;

  @Override
  public Identifier toPhysicalCatalogName(Identifier logicalName, JdbcEnvironment jdbcEnvironment) {
    if (logicalName != null) {
      String value = env.getProperty("aplicacao.teste");
      Integer aplicacaoTeste = (value != null) && !value.isBlank() ? Integer.parseInt(value) : 0;

      if (aplicacaoTeste.equals(EnvironmentMode.TEST.ordinal()))
        logicalName = getIdentifier(logicalName.getText().concat(BancoTipo.TESTE.getPrefixo()),
            logicalName.isQuoted(), jdbcEnvironment);
      else
        logicalName = apply(logicalName, jdbcEnvironment);
    }
    return logicalName;
  }

  @Override
  public Identifier toPhysicalSchemaName(Identifier logicalName, JdbcEnvironment jdbcEnvironment) {
    return apply(logicalName, jdbcEnvironment);
  }

  @Override
  public Identifier toPhysicalTableName(Identifier logicalName, JdbcEnvironment jdbcEnvironment) {
    return apply(logicalName, jdbcEnvironment);
  }

  @Override
  public Identifier toPhysicalSequenceName(Identifier logicalName,
      JdbcEnvironment jdbcEnvironment) {
    return apply(logicalName, jdbcEnvironment);
  }

  @Override
  public Identifier toPhysicalColumnName(Identifier logicalName, JdbcEnvironment jdbcEnvironment) {
    return apply(logicalName, jdbcEnvironment);
  }

  private Identifier apply(final Identifier name, final JdbcEnvironment jdbcEnvironment) {

    if (name == null) {
      return null;
    }
    StringBuilder builder = new StringBuilder(name.getText().replace('.', '_'));
    for (int i = 1; i < builder.length() - 1; i++) {
      if (isUnderscoreRequired(builder.charAt(i - 1), builder.charAt(i), builder.charAt(i + 1))) {
        builder.insert(i++, '_');
      }
    }
    return getIdentifier(builder.toString(), name.isQuoted(), jdbcEnvironment);
  }

  /**
   * Get an identifier for the specified details. By default this method will return an identifier
   * with the name adapted based on the result of {@link #isCaseInsensitive(JdbcEnvironment)}
   *
   * @param name the name of the identifier
   * @param quoted if the identifier is quoted
   * @param jdbcEnvironment the JDBC environment
   * @return an identifier instance
   */
  protected Identifier getIdentifier(String name, final boolean quoted,
      final JdbcEnvironment jdbcEnvironment) {
    if (isCaseInsensitive(jdbcEnvironment)) {
      name = name.toLowerCase(Locale.ROOT);
    }
    return new Identifier(name, quoted);
  }

  /**
   * Specify whether the database is case sensitive.
   *
   * @param jdbcEnvironment the JDBC environment which can be used to determine case
   * @return true if the database is case insensitive sensitivity
   */
  protected boolean isCaseInsensitive(JdbcEnvironment jdbcEnvironment) {
    return true;
  }

  private boolean isUnderscoreRequired(final char before, final char current, final char after) {
    return Character.isLowerCase(before) && Character.isUpperCase(current)
        && Character.isLowerCase(after);
  }

}
