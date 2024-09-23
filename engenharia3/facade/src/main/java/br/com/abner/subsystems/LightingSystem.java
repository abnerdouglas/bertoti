package br.com.abner.subsystems;

public class LightingSystem {
    public void on(String voiceComand){
        if (voiceComand.equals("alexa, turn on the lights")){
            System.out.println("Sistema de iluminação da residência ligado.");
            return;
        }
        System.out.println("Comando de voz incorreto.");
    }

    public void off(String voiceComand){
        if (voiceComand.equals("alexa, turn off the lights")){
            System.out.println("Sistema de iluminação da residência desligado.");
            return;
        }
        System.out.println("Comando de voz incorreto.");
    }
}
