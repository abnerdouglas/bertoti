package br.com.abner;

import br.com.abner.facade.HomeAutomationFacade;
import br.com.abner.subsystems.LightingSystem;
import br.com.abner.subsystems.SecuritySystem;

public class Main {
    public static void main(String[] args) {
        LightingSystem lightingSystem = new LightingSystem();
        SecuritySystem securitySystem = new SecuritySystem();

        HomeAutomationFacade homeAutomationFacade = new HomeAutomationFacade(securitySystem, lightingSystem);
        homeAutomationFacade.getHome();
        homeAutomationFacade.outHome();
    }
}