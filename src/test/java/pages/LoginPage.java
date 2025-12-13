package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import user.User;

public class LoginPage extends BasePage {
    By userField = By.cssSelector("[placeholder='Username']");
    By passwordField = By.cssSelector("[placeholder='Password']");
    By loginBtn = By.id("login-button");
    By error = By.xpath("//*[@data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы")
    public LoginPage open() {
        driver.get(BASE_URL);
        return this;
    }

    @Step("Авторизация под кредами пользователя:логин = {user.email}, пароль = ********")
    public LoginPage login(User user) {
        enterLoginName(user.getEmail());
        driver.findElement(passwordField).sendKeys(user.getPassword());
        driver.findElement(loginBtn).click();
        return this;
    }

    public LoginPage login(String user, String pass) {
        enterLoginName(user);
        driver.findElement(passwordField).sendKeys(pass);
        driver.findElement(loginBtn).click();
        return this;
    }

    @Step("Вводим логин")
    public LoginPage enterLoginName(String username) {
        driver.findElement(userField).sendKeys(username);
        return this;
    }

    @Step("Появление сообщения об ошибке")
    public boolean isErrorMsgAppear() {
        return driver.findElement(error).isDisplayed();
    }

    @Step("Получаем текст  из сообщения об ощибке")
    public String errorMsgText() {
        return driver.findElement(error).getText();
        //String errorMessageText = driver.findElement(By.cssSelector(".error_message")).getText();
    }
}