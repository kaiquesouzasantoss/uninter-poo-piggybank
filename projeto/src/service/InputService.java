package service;

import content.MenuContent;
import java.util.Scanner;

public class InputService {
    // Singleton que garante uma única instância da classe responsável por entrada de dados
    private static final InputService INSTANCE = new InputService();

    // Scanner conectado à entrada padrão (console)
    private final Scanner input = new Scanner(System.in);
    // Acesso centralizado às mensagens do menu (labels)
    private final MenuContent menu = MenuContent.getInstance();

    public static InputService getInstance() {
        // Retorna a instância única (Singleton)
        return INSTANCE;
    }

    public int requestInt(String text) {
        // Linha divisória superior para melhorar a legibilidade na UI
        IO.println(menu.getLabel("div"));

        // Exibe o texto de solicitação e inicia a validação da entrada
        IO.print(text);
        while (!input.hasNextInt()) {
            // Mensagem de opção inválida enquanto a entrada não for um inteiro
            IO.println(menu.getLabel("invalid"));
            IO.print(text);
            // Consome o token inválido para evitar loop infinito
            input.next();
        }

        // Lê o inteiro válido após passar na validação
        int value = input.nextInt();

        // Linha divisória inferior após a leitura
        IO.println(menu.getLabel("div"));

        // Retorna o valor inteiro coletado
        return value;
    }

    public int requestInt(String text, boolean divTop, boolean divBottom) {
        // Exibe a linha superior condicionalmente, conforme flags
        if (divTop)
            IO.println(menu.getLabel("div"));

        // Solicitação e validação de inteiro, igual ao método anterior
        IO.print(text);
        while (!input.hasNextInt()) {
            IO.println(menu.getLabel("invalid"));
            IO.print(text);
            input.next(); // descarta entrada inválida
        }

        int value = input.nextInt();

        // Exibe a linha inferior condicionalmente
        if (divBottom)
            IO.println(menu.getLabel("div"));

        return value;
    }

    public double requestDouble(String text) {
        // Linha divisória superior para separar blocos de interação
        IO.println(menu.getLabel("div"));

        // Solicita e valida a entrada até ser um double válido
        IO.print(text);
        while (!input.hasNextDouble()) {
            IO.println(menu.getLabel("invalid"));
            IO.print(text);
            input.next(); // consome token inválido
        }

        // Lê o double válido
        double value = input.nextDouble();

        // Linha divisória inferior após captura
        IO.println(menu.getLabel("div"));

        return value;
    }

    public double requestDouble(String text, boolean divTop, boolean divBottom) {
        // Controle opcional de exibição de divisória superior
        if (divTop)
            IO.println(menu.getLabel("div"));

        // Solicitação e validação de double
        IO.print(text);
        while (!input.hasNextDouble()) {
            IO.println(menu.getLabel("invalid"));
            IO.print(text);
            input.next(); // descarta entrada inválida
        }

        double value = input.nextDouble();

        // Controle opcional de exibição de divisória inferior
        if (divBottom)
            IO.println(menu.getLabel("div"));

        return value;
    }
}
