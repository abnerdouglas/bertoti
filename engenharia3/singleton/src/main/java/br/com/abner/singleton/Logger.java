package br.com.abner.singleton;

public final class Logger {

    /*
    A palavra-chave VOLATILE em Java é utilizada para indicar que o valor de uma variável pode ser modificado por várias
    threads ao mesmo tempo, e que todas as threads devem sempre ler o valor mais recente dessa variável diretamente da
    memória principal (e não de um cache local de uma thread).
     */
    private static volatile Logger instance;
    private String lastLogMessage;
    private Logger() {
    }
    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    public void logMessage(String message){
        this.lastLogMessage = message;
    }
    public String getLastLogMessage() {
        return lastLogMessage;
    }
}
