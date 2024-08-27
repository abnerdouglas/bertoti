package br.com.abner.chat;

import org.telegram.telegrambots.longpolling.TelegramBotsLongPollingApplication;

public class ChatMain {
    public static void main(String[] args) {
        // token do botfather
        String botToken = "6883850744:AAEtS2d2q5Hosh0BH9sLFqGnygegYp2cBrQ";

        try (TelegramBotsLongPollingApplication botsApplication = new TelegramBotsLongPollingApplication()) {

            botsApplication.registerBot(botToken, new SimpleChatBot(botToken));

            System.out.println("MyAmazingBot successfully started!");
            // Ensure this prcess wait forever
            Thread.currentThread().join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

