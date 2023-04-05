//package Pages;
//
//public class HomePage {
//}

package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    private By fromCityLocator = By.id("fromCity");
    private By toCityLocator = By.id("toCity");
    private By departureLocator = By.xpath("//input[@placeholder='From']");
    private By adultsLocator = By.id("adults");
    private By childrenLocator = By.id("children");
    private By infantsLocator = By.id("infants");
    private By searchButtonLocator = By.xpath("//a[contains(@class,'primaryBtn')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void enterFromCity(String fromCity) {
        WebElement fromCityElement = driver.findElement(fromCityLocator);
        fromCityElement.sendKeys(fromCity);
    }

    public void enterToCity(String toCity) {
        WebElement toCityElement = driver.findElement(toCityLocator);
        toCityElement.sendKeys(toCity);
    }

    public void enterDepartureDate(String departureDate) {
        WebElement departureElement = driver.findElement(departureLocator);
        departureElement.sendKeys(departureDate);
    }

    public void enterPassengerDetails(int adults, int children, int infants) {
        WebElement adultsElement = driver.findElement(adultsLocator);
        adultsElement.sendKeys(String.valueOf(adults));

        WebElement childrenElement = driver.findElement(childrenLocator);
        childrenElement.sendKeys(String.valueOf(children));

        WebElement infantsElement = driver.findElement(infantsLocator);
        infantsElement.sendKeys(String.valueOf(infants));
    }

    public void clickOnSearchButton() {
        WebElement searchButtonElement = driver.findElement(searchButtonLocator);
        searchButtonElement.click();
    }
}

