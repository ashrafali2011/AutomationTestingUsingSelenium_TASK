package DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    private static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

    public static void driverSetup(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("start-maximized");
                chromeOptions.addArguments("--guest");
//                chromeOptions.addArguments("--headless");
                threadLocal.set(new ChromeDriver(chromeOptions));
                break;
            case "firefox":
                threadLocal.set(new FirefoxDriver());
                break;
            default:
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("start-maximized");
                edgeOptions.addArguments("--guest");
                threadLocal.set(new EdgeDriver(edgeOptions));
        }
    }

    public static WebDriver getDriver() {
        return threadLocal.get();
    }

    public static void quitDriver() {
        getDriver().quit();
        threadLocal.remove();
    }
}
