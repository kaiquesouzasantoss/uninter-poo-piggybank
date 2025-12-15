package model;

import content.CoinEnum;

public class RealModel extends CoinModel {
    public RealModel(double value) {
        // Inicializa o valor da moeda em reais no construtor da classe base (CoinModel)
        super(value);
        // Define o tipo de moeda como REAL, determinando descrição, símbolo e cotação
        coinType = CoinEnum.REAL;
    }

    @Override
    public String info() {
        // Retorna uma representação textual padronizada: "Descrição | Símbolo valor"
        return String.format("%s | %s %.2f", coinType.getDescription(), coinType.getSymbol(), value);
    }

    @Override
    public double cast() {
        // Converte o valor em REAL para REAL (BRL) usando a cotação definida em CoinEnum (METODO REDUNDANTE)
        return value * coinType.getQuoteReal();
    }
}
