//package Pages;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//
//public class flightSearchPage {
//}

package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.FindBy;
        import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class flightSearchPage extends BasePage {
    // Page elements
    @FindBy(id = "departure")
    private WebElement departureInput;

    @FindBy(id = "arrival")
    private WebElement arrivalInput;

    @FindBy(xpath = "//label[text()='One way']")
    private WebElement oneWayRadio;

    @FindBy(id = "search_button")
    private WebElement searchButton;

    // Constructor
    public flightSearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Methods to interact with page elements
    public void enterDeparture(String departure) {
        departureInput.sendKeys(departure);
    }

    public void enterArrival(String arrival) {
        arrivalInput.sendKeys(arrival);
    }

    public void selectOneWay() {
        oneWayRadio.click();
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public boolean isPageOpened() {
        return driver.getTitle().contains("MakeMyTrip - #1 Travel Website");
    }

    public static List<Integer> getAllFlightPrices() {
        List<Integer> prices = new ArrayList<>();
        List<WebElement> priceElements = driver.findElements(By.xpath("//span[@class='actual-price']"));
        for (WebElement priceElement : priceElements) {
            String priceString = priceElement.getText().replaceAll("[^\\d.]", "");
            int price = Integer.parseInt(priceString);
            prices.add(price);
        }
        return prices;
    }

    public static int getNonstopFlightCount() {
        WebElement nonstopElement = driver.findElement(By.xpath("//label[@for='filter_stop_nonstop']//span[@class='custom-count']"));
        String nonstopCountString = nonstopElement.getText().replaceAll("[^\\d.]", "");
        int nonstopCount = Integer.parseInt(nonstopCountString);
        return nonstopCount;
    }

    public static int getTotalFlightCount() {
        WebElement totalCountElement = driver.findElement(By.xpath("//span[@class='fli-filter-results-count']"));
        String totalCountString = totalCountElement.getText().replaceAll("[^\\d.]", "");
        int totalCount = Integer.parseInt(totalCountString);
        return totalCount;
    }


}

