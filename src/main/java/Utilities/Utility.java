package Utilities;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class Utility {
    public static int getTimeout() throws IOException {
        return Integer.parseInt(DataUtil.getPropertyValue("environment", "TIMEOUT"));
    }

    public static WebDriverWait getExplicitWait(WebDriver driver) throws IOException {
        return new WebDriverWait(driver, Duration.ofSeconds(getTimeout()));
    }

    public static void clickOnElement(WebDriver driver, By locator) throws IOException {
        new WebDriverWait(driver, Duration.ofSeconds(getTimeout()))
                .until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    public static void clickOnElementUsingJavaScript(WebDriver driver, By locator) throws IOException {
        new WebDriverWait(driver, Duration.ofSeconds(getTimeout()))
                .until(ExpectedConditions.elementToBeClickable(locator));

        //driver.findElement(locator).click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(locator));
    }

    public static void sendDataUsingJavaScript(WebDriver driver, By locator, String datetime) throws IOException, InterruptedException {
        // Set the value and keep monitoring it
        ((JavascriptExecutor) driver).executeScript(
                "let element = arguments[0];" +
                        "let targetValue = arguments[1];" +
                        // Set initial value
                        "element.value = targetValue;" +
                        "element.setAttribute('value', targetValue);" +
                        // Create observer to monitor value changes
                        "let observer = new MutationObserver(function(mutations) {" +
                        "  if (element.value !== targetValue) {" +
                        "    element.value = targetValue;" +
                        "    element.setAttribute('value', targetValue);" +
                        "  }" +
                        "});" +
                        // Start observing
                        "observer.observe(element, {" +
                        "  attributes: true," +
                        "  characterData: true," +
                        "  subtree: true," +
                        "  attributeFilter: ['value']" +
                        "});" +
                        // Store observer reference to prevent garbage collection
                        "element._valueObserver = observer;",
                driver.findElement(locator),
                datetime
        );
    }

    public static void sendData(WebDriver driver, By locator, String data) throws IOException {
        new WebDriverWait(driver, Duration.ofSeconds(getTimeout()))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).sendKeys(data);
    }

    public static void clearText(WebDriver driver, By locator) throws IOException {
        new WebDriverWait(driver, Duration.ofSeconds(getTimeout()))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).clear();
    }

    public static void clickTAB(WebDriver driver, By locator) throws IOException {
        new WebDriverWait(driver, Duration.ofSeconds(getTimeout()))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).sendKeys(Keys.TAB);
    }

    public static void clickEnter(WebDriver driver, By locator) throws IOException {
        new WebDriverWait(driver, Duration.ofSeconds(getTimeout()))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).sendKeys(Keys.ENTER);
    }

    public static String getText(WebDriver driver, By locator) throws IOException {
        new WebDriverWait(driver, Duration.ofSeconds(getTimeout()))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator).getText();
    }

    public static WebDriverWait generalWait(WebDriver driver) throws IOException {
        return new WebDriverWait(driver, Duration.ofSeconds(getTimeout()));
    }

    public static void scrolling(WebDriver driver, By locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", findElement(driver, locator));
    }

    public static WebElement findElement(WebDriver driver, By locator) {
        return driver.findElement(locator);
    }

}
