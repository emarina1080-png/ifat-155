package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertyReader;

import java.time.Duration;

public class BasePage {
    public static final String BASE_URL = PropertyReader.getProperty("saucedemo.url");
    public static final String TEXT_LOCATOR_PATTERN = "//*[text()='%s']";

    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    }

    public boolean isPageLoaded(final String pageTitle) {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle));
        return driver.findElement(By.xpath(TEXT_LOCATOR_PATTERN.formatted(pageTitle))).isDisplayed();
    }
}