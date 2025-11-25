package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    By userField = By.cssSelector("[placeholder='Username']");
    By passwordField = By.cssSelector("[placeholder='Password']");
    By loginBtn = By.id("login-button");
    By error = By.xpath("//*[@data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://www.saucedemo.com/ ");
    }

    public void login(final String userName, final String passwordName) {
        driver.findElement(userField).sendKeys(userName);
        driver.findElement(passwordField).sendKeys(passwordName);
        driver.findElement(loginBtn).click();
    }

    public boolean isErrorMsgAppear() {
        return driver.findElement(error).isDisplayed();
    }

    public String errorMsgText() {
        return driver.findElement(error).getText();
        //String errorMessageText = driver.findElement(By.cssSelector(".error_message")).getText();
    }
}