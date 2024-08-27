package br.com.abner.chat;

import br.com.abner.chat.observer.Observer;
import br.com.abner.chat.observer.Subject;
import br.com.abner.chat.strategy.TimeFrance;
import br.com.abner.chat.strategy.TimeJapan;
import br.com.abner.chat.strategy.TimeStrategy;
import br.com.abner.chat.strategy.TimeUSA;
import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

import java.util.ArrayList;
import java.util.List;

public class SimpleChatBot implements LongPollingSingleThreadUpdateConsumer, Subject {
    private TelegramClient telegramClient;
    private TimeStrategy timeStrategy;
    private List<Observer> observers = new ArrayList<>();

    public SimpleChatBot(String botToken) {
        telegramClient = new OkHttpTelegramClient(botToken);
    }

    @Override
    public void consume(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText().trim().toLowerCase();
            long chatId = update.getMessage().getChatId();

            String responseText = null;

            if (messageText.equals("/start")) {
                handleStartCommand(chatId);
            } else {
                responseText = handleCountryCommand(messageText);

                // Se não houver resposta para o comando de país, definir uma mensagem padrão
                if (responseText == null) {
                    responseText = "Comando não reconhecido. Use '/start' para ver opções.";
                }
            }

            if (responseText != null) {
                try {
                    sendMessage(chatId, responseText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private void handleStartCommand(long chatId) {
        String startMessage = "Selecione um país abaixo para descobrir a data e horários atuais:\n" +
                " -> França\n" +
                " -> Japão\n" +
                " -> Estados Unidos";
        notifyObservers(startMessage);
        try {
            sendMessage(chatId, startMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private String handleCountryCommand(String messageText) {
        if (messageText.contains("frança") || messageText.contains("franca")) {
            timeStrategy = new TimeFrance();
            return timeStrategy.verifyTime("França");
        } else if (messageText.contains("japão") || messageText.contains("japao")) {
            timeStrategy = new TimeJapan();
            return timeStrategy.verifyTime("Japão");
        } else if (messageText.contains("estados unidos") || messageText.contains("usa")) {
            timeStrategy = new TimeUSA();
            return timeStrategy.verifyTime("Estados Unidos");
        }
        return null;
    }

    private void sendMessage(long chatId, String responseText) throws TelegramApiException {
        SendMessage message = SendMessage.builder()
                .chatId(chatId)
                .text(responseText)
                .build();
        telegramClient.execute(message);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
