package br.com.abner.listeners;

import br.com.abner.events.EventType;

public class Notification implements Observer{

    private String team;
    private String player;
    private int time;

    public Notification(String team, String player, int time) {
        this.team = team;
        this.player = player;
        this.time = time;
    }

    @Override
    public void update(EventType event) {
        switch (event){
            case GOAL:
                String formattedMessage = String.format("GOL marcado pelo jogador %s, da equipe %s, aos %d minutos de jogo.\n", player, team, time);
                System.out.println(formattedMessage);
                break;
            case YELLOW_CARD:
                formattedMessage = String.format("Cartão AMARELO para o jogador %s, da equipe %s, aos %d minutos de jogo.\n", player, team, time);
                System.out.println(formattedMessage);
                break;
            case RED_CARD:
                formattedMessage = String.format("Cartão VERMELHO para o jogador %s, da equipe %s, aos %d minutos de jogo.\n", player, team, time);
                System.out.println(formattedMessage);
                break;
            default:
                System.out.println("Evento desconhecido");
        }
    }
}
