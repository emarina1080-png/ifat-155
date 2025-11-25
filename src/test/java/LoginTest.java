import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void checkIncorrectLogin() throws InterruptedException {
        //открыть брайзре
        //зайти на сайт
        loginPage.open();
        loginPage.login("locked_out_user", "secret_sauce");
        Thread.sleep(9000);
        //boolean isVisible = loginPage.isErrorMsgAppear(); // если переменная повтряется несколько раз в кода, лучше выносить таким образом
        assertTrue(loginPage.isErrorMsgAppear(), "Error: message does not appear");
        assertEquals(loginPage.errorMsgText(), "Epic sadface: Sorry, this user has been locked out.");

    }

    @Test
    public void checkCorrectLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        assertTrue(productsPage.isPageLoaded(), "Error: Register button is not visible");
    }

}