package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class DriverManager {
    private static DriverManager instance;
    public static final String BASE_URL = "https://www.saucedemo.com";
    public static final Duration IMPLICIT_WAIT = Duration.ofSeconds(10);
    public WebDriver driver;

    private DriverManager(){
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        // Desactiva el gestor de contraseñas de Chrome
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection", false);
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--disable-features=PasswordLeakDetection");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT);
        driver.manage().window().maximize();
    }

    public static DriverManager getDriver(){
        if(instance == null){
            instance = new DriverManager();
        }
        return instance;
    }

    public static void quitDriver(){
        if(instance != null){
            instance.driver.quit();
            instance = null;
        }
    }
}