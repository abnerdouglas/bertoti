package br.com.abner.subsystems;

public class SecuritySystem {

    private static final String secretHome = "palmeiras";
    public void on(String secret){
        if (secret.equals(secretHome)){
            System.out.println("Sistema de segurança ativado.");
            return;
        }
        System.out.println("Segredo incorreto.");
    }

    public void off(String secret){
        if (secret.equals(secretHome)){
            System.out.println("Sistema de segurança desativado.");
            return;
        }
        System.out.println("Segredo incorreto.");
    }
}
