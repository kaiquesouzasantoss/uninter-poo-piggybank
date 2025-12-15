package content;

public enum CoinEnum {
    /*
        Define cada moeda com:
        (id interno, descrição, símbolo monetário, cotação em relação ao Real)
     */
    REAL(1, "REAL", "R$", 1.0),
    DOLLAR(2, "DOLAR", "$", 5.0),
    EURO(3, "EURO", "€", 6.0);

    // Identificador único da moeda (útil para mapear seleções de UI ou persistência)
    private final int ID;
    // Descrição textual da moeda (apresentação para o usuário)
    private final String description;
    // Símbolo monetário (ex.: R$, $, €) para exibição formatada
    private final String symbol;
    // Cotação da moeda em relação ao Real (BRL); ex.: 1 USD = 5.0 BRL
    private final double quoteReal;

    CoinEnum(int id, String description, String symbol, double quoteReal) {
        // Inicializa os atributos imutáveis do enum
        ID = id;
        this.description = description;
        this.symbol = symbol;
        this.quoteReal = quoteReal;
    }

    public static CoinEnum getById(int ID) {
        // Busca uma moeda pelo seu ID percorrendo os valores do enum e retorna null se não encontrar
        for (CoinEnum coin : CoinEnum.values()) {
            if (coin.getID() == ID) {
                return coin;
            }
        }
        return null;
    }

    public int getID() { return ID; }                 // Retorna o identificador único
    public String getDescription() { return description; } // Retorna a descrição textual
    public String getSymbol() { return symbol; }      // Retorna o símbolo monetário
    public double getQuoteReal() { return quoteReal; } // Retorna a cotação para BRL
}
