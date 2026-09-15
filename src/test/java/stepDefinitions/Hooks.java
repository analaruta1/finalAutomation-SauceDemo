package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import utils.DriverManager;

public class Hooks {

    // Pausa después de cada paso para ver la ejecución en cámara lenta.
    // Cambia la velocidad con -Dslowmo=1000 (ms) o desactívala con -Dslowmo=0
    @AfterStep
    public void slowMotion() throws InterruptedException {
        long delay = Long.parseLong(System.getProperty("slowmo", "500"));
        if (delay > 0) {
            Thread.sleep(delay);
        }
    }

    @After
    public void afterScenario(){
        DriverManager.quitDriver();
    }
}