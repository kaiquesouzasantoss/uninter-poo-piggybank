package service;

import content.CoinEnum;
import model.*;
import repository.PiggyBankRepository;
import java.util.List;

public class PiggyBankService {
    // Camada de serviço orquestra regras de negócio e delega persistência ao repositório
    private final PiggyBankRepository repository = new PiggyBankRepository();

    public boolean addCoin(int coinID, double value) {
        // Regra de negócio que não aceita valores nulos ou negativos
        if (value <= 0.0) return false;

        // Obtém o tipo de moeda pelo ID; pode retornar null se o ID for inválido
        CoinEnum coin = CoinEnum.getById(coinID);
        if (coin == null)
            return false;

        // Cria a instância de CoinModel conforme o tipo e adiciona ao repositório
        switch (coin) {
            case REAL   -> repository.addCoin(new RealModel(value));
            case DOLLAR -> repository.addCoin(new DollarModel(value));
            case EURO   -> repository.addCoin(new EuroModel(value));
            default     -> { return false; }
        }

        // Indica sucesso na operação
        return true;
    }

    public void removeCoin(int index) {
        // Remove moeda pelo índice informado
        repository.removeCoin(index);
    }

    public List<CoinModel> getCoins() {
        // Retorna a lista de moedas do repositório
        return repository.getCoins();
    }

    public double getCoinsCast() {
        // Calcula o total convertido em Real (BRL) somando a conversão via cast() de cada moeda
        return repository
                .getCoins()
                .stream()
                .map(CoinModel::cast)
                .reduce(Double::sum)
                .orElse(0.0);
    }
}
