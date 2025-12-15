package model;

import content.CoinEnum;

public class EuroModel extends CoinModel {
    public EuroModel(double value) {
        // Inicializa o valor da moeda em euros no construtor da classe base (CoinModel)
        super(value);
        // Define o tipo de moeda como EURO, determinando descrição, símbolo e cotação
        coinType = CoinEnum.EURO;
    }

    @Override
    public String info() {
        // Retorna uma representação textual padronizada: "Descrição | Símbolo valor"
        return String.format("%s | %s %.2f", coinType.getDescription(), coinType.getSymbol(), value);
    }

    @Override
    public double cast() {
        // Converte o valor em EURO para REAL (BRL) usando a cotação definida em CoinEnum
        return value * coinType.getQuoteReal();
    }
}
