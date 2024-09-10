package br.com.abner;

import br.com.abner.singleton.Logger;

public class Main {
    public static void main(String[] args) {
        System.out.println("Se vc visualiza o mesmo log, então o singleton foi reutilizado! :)" + "\n" +
                "Se vc visualiza logs diferentes, então 2 singletons foram criados! :(" + "\n\n" +
                "RESULTADO:" + "\n");

        Logger logger = Logger.getInstance();
        logger.logMessage("401 -> Erro de autorização JWT");

        Logger anotherLogger = Logger.getInstance();
        anotherLogger.logMessage("500 -> Erro interno do servidor");

        System.out.println("Última mensagem de log: " + logger.getLastLogMessage());
        System.out.println("Última mensagem de log: " + anotherLogger.getLastLogMessage());
    }
}