package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class CarFuelConsumptionTrackerPage {
    private final WebDriver driver;
    private final By carNumberField = By.name("carNumber");
    private final By fuelInLitersField = By.name("fuelInLiters");
    private final By fuelTypeField = By.name("fuelType");
    private final By fuelcostField = By.name("fuelCost");
    private final By dateAndTimeField = By.name("dateAndTime");
    private final By companyIdField = By.name("companyId");
    private final By editButton = By.xpath("//button[@type='submit']");
    private final By deleteButton = By.xpath("//button[text()='Delete']");
    private final By carNumberCell = By.xpath("//tbody//tr//td[1]");


    public CarFuelConsumptionTrackerPage(WebDriver driver) {
        this.driver = driver;
    }

    public CarFuelConsumptionTrackerPage entercarNumber(String carNumber) throws IOException {
        Utility.clickOnElementUsingJavaScript(driver, carNumberField);
        Utility.sendData(driver, carNumberField, carNumber);
        return new CarFuelConsumptionTrackerPage(driver);
    }

    public CarFuelConsumptionTrackerPage enterfuelInLiters(String fuelInLiters) throws IOException {
        Utility.clickOnElementUsingJavaScript(driver, fuelInLitersField);
        Utility.sendData(driver, fuelInLitersField, fuelInLiters);
        return new CarFuelConsumptionTrackerPage(driver);
    }

    public CarFuelConsumptionTrackerPage enterfuelType(String fuelType) throws IOException {
        Utility.clickOnElementUsingJavaScript(driver, fuelTypeField);
        Utility.sendData(driver, fuelTypeField, fuelType);
        return new CarFuelConsumptionTrackerPage(driver);
    }

    public CarFuelConsumptionTrackerPage entercompanyId(String companyId) throws IOException {
        Utility.clickOnElementUsingJavaScript(driver, companyIdField);
        Utility.sendData(driver, companyIdField, companyId);
        return new CarFuelConsumptionTrackerPage(driver);
    }

    public CarFuelConsumptionTrackerPage enterfuelCost(String fuelCost) throws IOException {
        Utility.clickOnElementUsingJavaScript(driver, fuelcostField);
        Utility.sendData(driver, fuelcostField, fuelCost);
        return new CarFuelConsumptionTrackerPage(driver);
    }

    public CarFuelConsumptionTrackerPage enterdateAndTime(String datetime) throws IOException, InterruptedException {
        Utility.sendDataUsingJavaScript(driver, dateAndTimeField, datetime);
        return new CarFuelConsumptionTrackerPage(driver);

    }

    public CarFuelConsumptionTrackerPage clickOneditButton() throws IOException {
        Utility.clickOnElementUsingJavaScript(driver, editButton);
        return new CarFuelConsumptionTrackerPage(driver);
    }

    public CarFuelConsumptionTrackerPage clickOndeleteButton(String carNumber) throws IOException {
        Utility.clickOnElementUsingJavaScript(driver, deleteButton);
        return new CarFuelConsumptionTrackerPage(driver);
    }

    public CarFuelConsumptionTrackerPage scrollToDeleteButton() {
        Utility.scrolling(driver, deleteButton);
        return new CarFuelConsumptionTrackerPage(driver);
    }

    public void verifyCarNumber(String carNumber) {
        driver.findElement(carNumberCell).getText().equals(carNumber);
    }
}
