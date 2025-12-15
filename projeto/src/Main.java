import controller.PiggyBankController;

// Instância única do controller para orquestrar o fluxo do menu
private static final PiggyBankController controller = new PiggyBankController();

void main() {
    try {
        // Inicia o loop do menu; permanece executando até que o usuário selecione "Encerrar"
        controller.runMenu();
    } catch (Exception ignored) {
        // Em caso de erro não tratado, finaliza de forma controlada exibindo mensagem de encerramento
        controller.endProgram();
    }
}
