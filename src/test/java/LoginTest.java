import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @DataProvider()
    public Object[][] loginData() {
        return new Object[][]{
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"},
                {"Locked_out_user", "secret_sauce", "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @Test(description = "Проверка корректного логина", priority = 1, dataProvider = "loginData")
    public void checkIncorrectLogin(String user, String password, String errorMsg) {
        //открыть брайзре
        //зайти на сайт
        loginPage.open();
        loginPage.login(user, password);
        //Thread.sleep(9000);
        //boolean isVisible = loginPage.isErrorMsgAppear(); // если переменная повтряется несколько раз в кода, лучше выносить таким образом
        assertTrue(loginPage.isErrorMsgAppear(), "Error: message does not appear");
        assertEquals(loginPage.errorMsgText(), errorMsg);

    }

    @Test(priority = 2, enabled = true, invocationCount = 2)
    public void checkCorrectLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        assertTrue(productsPage.isPageLoaded("Products"), "Error: Register button is not visible");
    }

}