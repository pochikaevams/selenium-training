import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import selenium.training.TestBase;

import java.util.List;

public class AddItemToCart extends TestBase {

    @Test
    public void addNewItemToCartTest() {
        for (int i = 1; i < 4; i++) {
            driver.navigate().to("http://localhost:8080/litecart/en/");
            List<WebElement> items = driver.findElements(By.xpath("//li[@class = 'product column shadow hover-light']"));
            items.get(0).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.name("add_cart_product")));
            if (!driver.findElements(By.className("options")).isEmpty()) {
                Select sel = new Select(driver.findElement(By.name("options[Size]")));
                sel.selectByVisibleText("Medium +$2.50");
            }
            driver.findElement(By.name("add_cart_product")).click();
            wait.until(ExpectedConditions.alertIsPresent());
            //У меня приходит алерт с ошибкой, так что эти методы нужны
            Alert alert = driver.switchTo().alert();
            alert.accept();
            driver.findElement(By.id("cart")).click();
            driver.navigate().back();
            WebElement quantity = driver.findElement(By.className("quantity"));
            String text = Integer.toString(i);
            wait.until(ExpectedConditions.textToBePresentInElement(quantity, text));
        }
        driver.findElement(By.xpath("//a[text() = 'Checkout »']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("remove_cart_item")));

        List<WebElement> itemProducts = driver.findElements(By.cssSelector("[style=\"text-align: center;\"]"));
        for(int i = itemProducts.size(); i > 0; i--){
            driver.findElement(By.name("remove_cart_item")).click();
            wait.until(ExpectedConditions.stalenessOf(itemProducts.get(0)));
        }
    }
}
