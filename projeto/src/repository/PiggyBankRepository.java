package repository;

import model.CoinModel;
import java.util.ArrayList;
import java.util.List;

public class PiggyBankRepository {
    // Armazena as moedas do cofrinho em memória (lista mutável)
    private final ArrayList<CoinModel> piggyBankList = new ArrayList<>();

    public List<CoinModel> getCoins() {
        // Retorna a referência interna da lista de moedas
        return piggyBankList;
    }

    public void addCoin(CoinModel coin) {
        // Adiciona uma moeda ao cofrinho
        piggyBankList.add(coin);
    }

    public void removeCoin(int index) {
        // Remove uma moeda pelo índice informado
        piggyBankList.remove(index);
    }
}
