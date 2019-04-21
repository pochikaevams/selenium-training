import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import selenium.training.TestBase;

import java.util.List;

public class StickerTest extends TestBase {

    @Test
    public void ducksTest() throws Exception {
        driver.navigate().to("http://localhost:8080/litecart/en/");
        List<WebElement> stickers = driver.findElements(By.xpath("//div[@class='content']/ul[@class='listing-wrapper products']/li//div[contains(@class,'sticker')]"));
        for (WebElement sticker : stickers) {
            sticker.isDisplayed();
            if (stickers.size() != 1) {
                Exception ex;
            }
        }
    }
}
