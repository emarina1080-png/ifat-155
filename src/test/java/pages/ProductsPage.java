package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPage extends BasePage {
    By pageTitle = By.xpath("//*[@data-test='title']");

    private static final String ADD_TO_CART_BUTTON_PATTERN =
            "//div[text()='%s']//ancestor::div[@class='inventory_item']//button";
    private static final String TEXT_LOCATOR_PATTERN = "//*[text()='%s']";
    By cartBadge = By.xpath("//*[@data-test='shopping-cart-badge']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public ProductsPage addToCart(final String goodsName) {
        By addGoodsToCart = By.xpath(ADD_TO_CART_BUTTON_PATTERN.formatted(goodsName));
        driver.findElement(addGoodsToCart).click();
        return this;
    }

    public ProductsPage addToCart(final int goodsOrder) {
        driver.findElements(By.xpath(TEXT_LOCATOR_PATTERN.formatted("Add to cart"))).get(goodsOrder).click();
        return this;
    }

    public String checkGoodsQuantity() {
        return driver.findElement(cartBadge).getText();
    }

    public CartPage switchToCart() {
        driver.findElement(cartBadge).click();
        return new CartPage(driver);
    }
}