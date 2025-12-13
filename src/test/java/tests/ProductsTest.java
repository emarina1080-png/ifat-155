package tests;

import org.testng.annotations.Test;
import user.UserFactory;

import static org.testng.Assert.assertEquals;
import static user.UserFactory.withAdminPermission;

public class ProductsTest extends BaseTest {
    @Test
    public void checkGoodsAdded() {
        System.out.println("ProductsTest correct is runing in thread: " + Thread.currentThread().getId());

        loginPage.open();
        loginPage.login(withAdminPermission());
        productsPage.isPageLoaded("Products");
        productsPage.addToCart("Test.allTheThings() T-Shirt (Red)")
                .addToCart("Sauce Labs Bolt T-Shirt")
                .addToCart(2);
        assertEquals(productsPage.checkGoodsQuantity(), "3");

    }

}