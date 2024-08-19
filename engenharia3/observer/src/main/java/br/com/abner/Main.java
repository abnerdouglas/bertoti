package br.com.abner;


import br.com.abner.events.EventType;
import br.com.abner.listeners.Notification;
import br.com.abner.publishers.EventManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static int choice;
    public static EventManager events = new EventManager(EventType.GOAL, EventType.YELLOW_CARD, EventType.RED_CARD);

    private static void menuOptions() {
        System.out.println(
                "\n<-------------------------------------------------------------->" + "\n" +
                        "Escolha um tipo de notificação durante uma partida de futebol:" + "\n\n" +
                        "1 - Gol" + "\n" +
                        "2 - Cartão Amarelo" + "\n" +
                        "3 - Cartão Vermelho" + "\n" +
                        "0 - Fechar o programa" + "\n\n" +
                        "<-------------------------------------------------------------->"
        );
    }

    private static void readInput() throws IOException {
        int choice = -1;

        while (choice != 0) {

            choice = Integer.parseInt(reader.readLine());

            switch (choice) {
                case 0:
                    System.out.println("Até mais :)");
                    return;
                case 1:
                    events.subscribe(EventType.GOAL, new Notification("Palmeiras", "Deyvin", 102));
                    events.notify(EventType.GOAL);
                    break;
                case 2:
                    events.subscribe(EventType.YELLOW_CARD, new Notification("Vasco", "Vegetti", 65));
                    events.notify(EventType.YELLOW_CARD);
                    break;
                case 3:
                    events.subscribe(EventType.RED_CARD, new Notification("São Paulo", "Luciano", 90));
                    events.notify(EventType.RED_CARD);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente outra opção.");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        menuOptions();
        readInput();
    }
}