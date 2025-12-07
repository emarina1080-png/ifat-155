package tests;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import user.User;
import user.UserFactory;

import static enums.TitleNaming.PRODUCTS;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static user.UserFactory.withAdminPermission;

public class LoginTest extends BaseTest {
    @DataProvider()
    public Object[][] loginData() {
        return new Object[][]{
                /*      {PropertyReader.getProperty("saucedemo.locked_user"),
                              PropertyReader.getProperty("saucedemo.password"),
                              "Epic sadface: Sorry, this user has been locked out."},*/

                {UserFactory.withLockedUserPermission(),
                        "Epic sadface: Sorry, this user has been locked out."},

                {UserFactory.withUsernameOnly(""),
                        "Epic sadface: Username is required"},

                {UserFactory.withPasswordOnly(""),
                        "Epic sadface: Password is required"},

                {new User("Locked_out_user", "secret_sauce"),
                        "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @Epic("Создание лида")
    @Feature("Создание с карточки клиента")
    @Story("Лангинация")
    @TmsLink("ifat-155")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Eshkeeva Marina emarina1080@gmail.com")
    @Issue("ifat-155")
    @Test(description = "Проверка некорректного логина", priority = 1, dataProvider = "loginData")
    public void checkIncorrectLogin(User user, String errorMsg) {
        loginPage.open();
        loginPage.login(user);
        assertTrue(loginPage.isErrorMsgAppear(), "Error message does not appear");
        assertEquals(loginPage.errorMsgText(), errorMsg);
    }

    @Test(priority = 2, enabled = true, invocationCount = 1, alwaysRun = true)
    public void checkCorrectLogin() {
        System.out.println("LoginTest corr is running in thread: " + Thread.currentThread().getId());

        loginPage.open();
        loginPage.login(withAdminPermission());

        assertTrue(productsPage.isPageLoaded(PRODUCTS.getDisplayName()), "Register btn is not visible");
    }
}