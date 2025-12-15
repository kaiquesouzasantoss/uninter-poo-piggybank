package model;

import content.CoinEnum;

public abstract class CoinModel {
    // Valor monetário associado a esta instância
    protected double value;

    // Tipo de moeda
    protected CoinEnum coinType;

    CoinModel(double value) {
        this.value = value;
    }

    // Retorna uma representação textual da moeda.
    public abstract String info();

    // Converte o valor da moeda para REAL.
    public abstract double cast();
}
