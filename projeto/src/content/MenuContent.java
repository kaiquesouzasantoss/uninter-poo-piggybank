package content;

import java.util.List;
import java.util.Map;

public class MenuContent {
    // Implementa Singleton para ser única instância imutável da classe
    private static final MenuContent INSTANCE = new MenuContent();

    public static MenuContent getInstance() {
        // Retorna a instância única do conteúdo do menu
        return INSTANCE;
    }

    // Mapa imutável de labels (chave -> texto exibido)
    private final Map<String, String> labels = Map.ofEntries(
            Map.entry("start", "--- SISTEMA DE COFRINHO ---"),
            Map.entry("div", "---------------------------"),
            Map.entry("request", "SELECIONE UMA OPÇÃO: "),
            Map.entry("coin", "SELECIONE UMA MOEDA: "),
            Map.entry("value", "DIGITE O VALOR: "),
            Map.entry("id", "SELECIONE O ID DA MOEDA: "),
            Map.entry("invalid", "*** OPÇÃO INVÁLIDA ***"),
            Map.entry("remove", "MOEDA REMOVIDA COM SUCESSO!"),
            Map.entry("add", "MOEDA ADICIONADA COM SUCESSO!"),
            Map.entry("add-fail", "NÃO FOI POSSÍVEL ADICIONÁ-LA!"),
            Map.entry("empty", "NÃO HÁ MOEDAS!"),
            Map.entry("end", "*** PROGRAMA FINALIZADO ***")
    );

    // Lista imutável com as opções disponíveis no menu principal
    private final List<String> options = List.of(
            "ADICIONAR MOEDA",
            "REMOVER MOEDA",
            "LISTAR MOEDAS",
            "CALCULAR TOTAL EM REAL (R$)",
            "ENCERRAR"
    );

    public String getLabel(String labelOption) {
        // Recupera um texto de label pela chave informada
        return labels.get(labelOption);
    }

    public List<String> getOptions() {
        // Retorna a lista imutável das opções do menu
        return options;
    }
}
