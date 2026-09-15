package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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

    // Si el escenario falla, adjunta una captura de pantalla al reporte
    // y luego cierra el navegador
    @After
    public void afterScenario(Scenario scenario){
        try {
            if (scenario.isFailed()) {
                byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver().driver)
                        .getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", scenario.getName());
            }
        } finally {
            DriverManager.quitDriver();
        }
    }
}
