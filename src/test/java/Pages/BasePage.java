package Pages;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected static WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void navigateTo(String url) {
        driver.navigate().to(url);
    }
}

