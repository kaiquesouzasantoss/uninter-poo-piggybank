package controller;

import content.*;
import model.CoinModel;
import service.*;
import java.util.List;

public class PiggyBankController {
    // Acessa os textos do menu (labels) centralizados
    private final MenuContent menu = MenuContent.getInstance();
    // Serviço de entrada (Scanner + mensagens) para ler do console
    private final InputService input = InputService.getInstance();
    // Camada de serviço que orquestra regras do cofrinho e delega ao repositório
    private final PiggyBankService service = new PiggyBankService();

    public PiggyBankController() {
        // Mensagem inicial do sistema ao instanciar o controller
        IO.println(menu.getLabel("start"));
    }

    public void runMenu() {
        // Loop principal do programa que mantém o menu ativo até encerrar explicitamente
        while (true) {
            IO.println(menu.getLabel("div")); 

            // Lista as opções do menu com numeração sequencial começando em 1
            for (int i = 0; i < menu.getOptions().size(); i++) {
                IO.println("[" + (i + 1) + "] - " + menu.getOptions().get(i));
            }

            // Lê a opção escolhida e encaminha para a ação correspondente
            switch (input.requestInt(menu.getLabel("request"))) {
                case 1 -> addCoin();     
                case 2 -> removeCoin();  
                case 3 -> listCoins();  
                case 4 -> castCoins();  
                case 5 -> endProgram();  
                default -> IO.println(menu.getLabel("invalid")); 
            }
        }
    }

    private void addCoin() {
        // Lista os tipos de moeda disponíveis informando ID e descrição
        for (CoinEnum coin : CoinEnum.values()) {
            IO.println("[" + coin.getID() + "] - " + coin.getDescription());
        }

        // Solicita o ID do tipo de moeda
        int coinTypeID = input.requestInt(menu.getLabel("coin"));

        // Valida o ID informado convertendo para o enum correspondente
        CoinEnum coinObject = CoinEnum.getById(coinTypeID);
        if (coinObject == null) {
            // Se o ID da moeda não existir, informa falha e aborta a operação
            IO.println(menu.getLabel("add-fail"));
            return;
        }

        // Solicita o valor da moeda, exibindo o símbolo como pista visual
        double coinValue = input.requestDouble(
                menu.getLabel("value") + coinObject.getSymbol() + " ", false, false
        );

        IO.println(menu.getLabel("div")); 

        // Tenta adicionar a moeda via serviço; retorna sucesso/falha
        if (service.addCoin(coinTypeID, coinValue)) {
            IO.println(menu.getLabel("add"));
        } else {
            IO.println(menu.getLabel("add-fail"));
        }
    }

    private void removeCoin() {
        // Solicita o índice da moeda a ser removida (ID exibido na listagem)
        int coinID = input.requestInt(
                menu.getLabel("id"), false, false
        );

        // Delegada a remoção ao serviço (que aciona o repositório)
        service.removeCoin(coinID);

        IO.println(menu.getLabel("div")); 
        IO.println(menu.getLabel("remove")); // feedback de sucesso
    }

    private void listCoins() {
        // Obtém a lista imutável de moedas do serviço
        List<CoinModel> coins = service.getCoins();

        // Caso não haja moedas, informa ao usuário e retorna
        if (coins.isEmpty()) {
            IO.println(menu.getLabel("empty"));
            return;
        }

        // Percorre e exibe cada moeda com seu índice (ID usado para remoção)
        for (int index = 0; index < coins.size(); index++) {
            IO.println("[ID: " + index + "] " + coins.get(index).info());
        }
    }

    private void castCoins() {
        // Exibe o total convertido em Real (BRL) somando todas as moedas via cast()
        System.out.printf(
                "TOTAL EM %s: %s %.2f \n",
                CoinEnum.REAL.getDescription(),
                CoinEnum.REAL.getSymbol(),
                service.getCoinsCast()
        );
    }

    public void endProgram() {
        // Mensagem de encerramento e término do processo
        IO.println(menu.getLabel("end"));
        System.exit(0);
    }
}
