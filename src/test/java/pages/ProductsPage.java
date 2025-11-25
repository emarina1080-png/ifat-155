package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    WebDriver driver;

    By pageTitle = By.xpath("//*[@data-test='title']");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isPageLoaded() {
        return driver.findElement(pageTitle).isDisplayed();

    }

}
