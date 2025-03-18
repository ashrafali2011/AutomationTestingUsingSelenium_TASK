package Tests;

import Pages.CarFuelConsumptionTrackerPage;
import Utilities.DataUtil;
import Utilities.Utility;
import com.github.javafaker.Faker;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import static DriverFactory.DriverFactory.*;

public class TC01_VerifyAddingCarFuelConsumption {
    static Random random = new Random();
    static int fuelInLitersInt = 111 + random.nextInt(900);
    static String fuelInLiters = Integer.toString(fuelInLitersInt);
    private final String fuelType = DataUtil.getJsonData("CarFuelConsumption", "fuelType");
    private final String fuelCost = DataUtil.getJsonData("CarFuelConsumption", "fuelCost");
    private final String dateTime = DataUtil.getJsonData("CarFuelConsumption", "dateTime");
    Faker faker = new Faker();
    private final String carNumber = faker.idNumber().valid();
    private final String companyId = faker.idNumber().valid();

    @BeforeMethod
    public void setup() throws IOException {
        driverSetup(DataUtil.getPropertyValue("environment", "BROWSER"));
        getDriver().get(DataUtil.getPropertyValue("environment", "BASE_URL"));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Utility.getTimeout()));
    }

    @Test
    public void VerifyAddingCarFuelConsumption() throws IOException, InterruptedException {
        new CarFuelConsumptionTrackerPage(getDriver())
                .entercarNumber(carNumber)
                .enterfuelInLiters(fuelInLiters)
                .enterfuelCost(fuelCost)
                .enterfuelType(fuelType)
                .enterdateAndTime(dateTime)
                .entercompanyId(companyId)
                .clickOneditButton()
                .verifyCarNumber(carNumber);
    }

    @AfterMethod
    public void quit() {
        quitDriver();
    }


}
