package model;

import content.CoinEnum;

public class DollarModel extends CoinModel {
    public DollarModel(double value) {
        // Inicializa o valor da moeda em dólares no construtor da classe base (CoinModel)
        super(value);
        // Define o tipo de moeda como DOLAR, determinando descrição, símbolo e cotação
        coinType = CoinEnum.DOLLAR;
    }

    @Override
    public String info() {
        // Retorna uma representação textual padronizada: "Descrição | Símbolo valor"
        return String.format("%s | %s %.2f", coinType.getDescription(), coinType.getSymbol(), value);
    }

    @Override
    public double cast() {
        // Converte o valor em DOLAR para REAL (BRL) usando a cotação definida em CoinEnum
        return value * coinType.getQuoteReal();
    }
}
