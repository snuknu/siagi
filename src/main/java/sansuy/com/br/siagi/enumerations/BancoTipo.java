package sansuy.com.br.siagi.enumerations;

public enum BancoTipo {

  PRODUCAO("Oficial", ""),
  TESTE("Teste", ""),
  TESTE_FINANCEIRO("Teste - Financeiro", "_teste"),
  TESTE_CUSTOS("Teste - Custos", ""),
  SIMULACAO_ORCAMENTO("Simulação - Orçamentos", ""),
  SIMULACAO_LABORATORIO("Simulação - Laboratório", ""),
  SIMULACAO_ESPALMADOS("Simulação - Espalmados", ""),
  SIMULACAO_CUSTOS("Simulação - Custos", ""),
  TESTE_COMERCIAL("Teste - Comercial", "");

  private final String descricao;
  private final String prefixo;

  private BancoTipo(String descricao, String prefixo) {
    this.descricao = descricao;
    this.prefixo = prefixo;
  }

  public String getDescricao() {
    return descricao;
  }

  public String getPrefixo() {
    return prefixo;
  }

}
