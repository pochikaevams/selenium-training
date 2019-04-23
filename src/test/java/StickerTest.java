import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import selenium.training.TestBase;

import java.util.List;

public class StickerTest extends TestBase {

    @Test
    public void ducksTest() throws Exception {
        driver.navigate().to("http://localhost:8080/litecart/en/");
        List<WebElement> items = driver.findElements(By.xpath("//li[contains(@class,'product')]"));
        int itemsSize = items.size();
        for (int i = 0; i < itemsSize; i++) {
            int countOfStickers = items.get(i).findElements(By.xpath(".//div[contains(@class,'sticker')]")).size();
            Assert.assertEquals("Количество стикеров не равно 1", 1, countOfStickers);
        }
    }
}
