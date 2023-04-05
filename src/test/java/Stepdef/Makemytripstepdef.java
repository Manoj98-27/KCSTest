package Stepdef;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.*;
import Pages.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;


public class Makemytripstepdef {

    private WebDriver driver;
    private final String url = "https://www.makemytrip.com/";
    @Given("I am on the MakeMyTrip homepage")
    public void i_am_on_the_makemytrip_homepage() {
        // Set up Chrome driver
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Navigate to MakeMyTrip homepage
        driver.get(url);
        handlePopUpAlert();

        // Verify that the homepage is displayed
        WebElement fromCity = driver.findElement(By.id("fromCity"));
        if(fromCity.isDisplayed()){
            System.out.println("Home page is displayed !");
        }
    }

    private void handlePopUpAlert() {

        WebElement alert = driver.findElement(By.xpath("//*[text()='Sign up/Login now to']"));


        if(alert.isDisplayed()){git

            WebElement logo = driver.findElement(By.xpath("//*[@alt='Make My Trip']"));
            logo.click();
        }
    }

    @When("I enter the details of my one-way flight search")
    public void i_enter_the_details_of_my_one_way_flight_search() throws InterruptedException {
        // Enter details for one-way flight search
        WebElement fromCity = driver.findElement(By.id("fromCity"));
        fromCity.click();
        WebElement fromCityInput = driver.findElement(By.xpath("//input[@placeholder='From']"));
        fromCityInput.sendKeys("Ahmedabad");
        WebElement fromCityOption = driver.findElement(By.xpath("//div[@id='react-autowhatever-1']//li[@id='react-autowhatever-1-section-0-item-0']"));
        fromCityOption.click();

        WebElement toCity = driver.findElement(By.id("toCity"));
        toCity.click();
        WebElement toCityInput = driver.findElement(By.xpath("//input[@placeholder='To']"));
        toCityInput.sendKeys("Pune");
        WebElement toCityOption = driver.findElement(By.xpath("//div[@id='react-autowhatever-1']//li[@id='react-autowhatever-1-section-0-item-0']"));
        toCityOption.click();

        WebElement departure = driver.findElement(By.xpath("//span[text()='Departure']"));
        departure.click();
        WebElement date = driver.findElement(By.xpath("//div[@aria-label='Tue, 1 Jun']"));
        date.click();

        WebElement travellers = driver.findElement(By.id("travellers"));
        travellers.click();
        WebElement adults = driver.findElement(By.id("adults"));
        adults.click();
        WebElement adultsCount = driver.findElement(By.xpath("//li[@data-cy='adults-2']"));
        adultsCount.click();

        WebElement children = driver.findElement(By.id("children"));
        children.click();
        WebElement childrenCount = driver.findElement(By.xpath("//li[@data-cy='children-1']"));
        childrenCount.click();

        WebElement infants = driver.findElement(By.id("infants"));
        infants.click();
        WebElement infantsCount = driver.findElement(By.xpath("//li[@data-cy='infants-1']"));
        infantsCount.click();

        WebElement applyBtn = driver.findElement(By.xpath("//button[text()='APPLY']"));
        applyBtn.click();

        WebElement searchBtn = driver.findElement(By.xpath("//a[text()='Search']"));
        searchBtn.click();

        // Wait for the search results to load
        Thread.sleep(5000);
    }

    @Then("I should see the search results with the correct filters")
    public void i_should_see_the_search_results_with_the_correct_filters() {
            // Verify that the search results are displayed with the correct filters
            WebElement tripType = driver.findElement(By.xpath("//span[text()='One Way']"));
            if(tripType.isDisplayed()){
                System.out.println("search results are displayed !");
            }
    }

    @Then("^all flight prices should be between (\\d+) to (\\d+)$")
    public void verifyFlightPrices(int minPrice, int maxPrice) {
            List<Integer> prices = flightSearchPage.getAllFlightPrices();
            for (int price : prices) {
                if(price >= minPrice && price <= maxPrice){
                    System.out.println("Price " + price + " is not between " + minPrice + " and " + maxPrice);
                }
            }
    }

    @Then("^the count of Nonstop flights should match the right-side total flights count$")
    public void verifyNonstopFlightCount() {
                int nonstopCount = flightSearchPage.getNonstopFlightCount();
                int totalCount = flightSearchPage.getTotalFlightCount();
                if(nonstopCount==totalCount){
                    System.out.println("Nonstop flight count and total flight count do not match");
                }
            }




}


