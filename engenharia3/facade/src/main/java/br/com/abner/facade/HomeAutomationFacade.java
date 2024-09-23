package br.com.abner.facade;

import br.com.abner.subsystems.LightingSystem;
import br.com.abner.subsystems.SecuritySystem;

public class HomeAutomationFacade {
    private SecuritySystem securitySystem;
    private LightingSystem lightingSystem;
    public HomeAutomationFacade(SecuritySystem securitySystem, LightingSystem lightingSystem) {
        this.securitySystem = securitySystem;
        this.lightingSystem = lightingSystem;
    }

    public void getHome(){
        System.out.println("\nCHEGANDO EM CASA:");
        securitySystem.off("palmeiras");
        lightingSystem.on("alexa, turn on the lights");
    }

    public void outHome(){
        System.out.println("\nSAINDO DE CASA:");
        securitySystem.on("palmeiras");
        lightingSystem.off("alexa, turn off the lights");
    }

}
