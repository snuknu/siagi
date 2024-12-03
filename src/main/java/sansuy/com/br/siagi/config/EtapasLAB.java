package sansuy.com.br.siagi.config;

public enum EtapasLAB {


    LAB_000(null),
    LAB_001("Cadastrar regras de validade para materiais produzidos"),
    LAB_002("Cadastrar regras de validade para materiais adquiridos"),
    LAB_003("Consultar regras de validade para materiais produzidos"),
    LAB_004("Consultar regras de validade para materiais adquiridos"),
    LAB_005("Cadastrar classificação de materiais por fornecedor"),
    LAB_006("Cadastrar materiais críticos"),
    LAB_007("Consultar classificação de materiais por fornecedor"),
    LAB_008("Consultar materiais críticos"),
    LAB_009("Cadastrar EMP"),
    LAB_010("Consultar EMP"),
    LAB_011("Avaliar matéria-prima"),
    LAB_012("Consultar avaliação de matéria-prima"),
    LAB_013("Receber notificação de FLMP não-conforme/uso restrito"),
    LAB_014("Consultar FLMP não-conforme/uso restrito"),
    LAB_015("Revalidar matéria-prima"),
    LAB_016("Receber notificação de FLMP (revalidação) não-conforme/uso restrito"),
    LAB_017("Consultar revalidações de matéria-prima"),
    LAB_018("Consultar ocorrências de validação de matéria-prima"),
    LAB_019("Consultar recebimentos de matéria-prima"),
    LAB_020("Cadastrar permissões para avaliação de materiais"),
    LAB_021("Receber notificação de FLMP aprovada"),
    LAB_022("Receber notificação de FLMP (revalidação) aprovada"),
    LAB_023("Alterar indicador de uso automotivo do produto"),
    LAB_024("Cadastrar produtos para retirada de amostra na produção"),
    LAB_025("Cadastrar critérios para notificação de notas com certificado de análise"),
    LAB_026("Consultar indicador de uso automotivo do produto"),
    LAB_027("Cadastrar regras para produtos que permitem qualidade assegurada"),
    LAB_028("Consultar regras para produtos que permitem qualidade assegurada"),
    LAB_029("Consultar documentos de entrada(NF) com EMP, sem pedido de compra atrelado"),
    LAB_030("Cadastrar regra de transferência de produtos vencidos para revalidação"),
    LAB_031(null),
    LAB_032(null),
    LAB_033(null),
    LAB_034(null),
    LAB_035(null),
    LAB_036(null),
    LAB_037(null),
    LAB_038(null),
    LAB_039(null),
    LAB_040("Administrar o sistema");

    private final String descricao;

    EtapasLAB(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
