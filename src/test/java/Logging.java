import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.ui.ExpectedConditions;
import selenium.training.TestBase;

import java.util.List;

public class Logging extends TestBase {

    @Test
    public void browserLoggingTest() {
        driver.navigate().to("http://localhost:8080/litecart/admin/?app=catalog&doc=catalog&category_id=1");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text() = 'Rubber Ducks']")));
        driver.findElement(By.xpath(("//a[text() = 'Rubber Ducks']"))).click();
        List<WebElement> items = driver.findElements(By.cssSelector("img+a[href*=\"category_id=1&product_id\"]"));
        int itemsSize = items.size();
        for(int i = 0; i < itemsSize; i++){
            items.get(i).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[href=\"#tab-general\"]")));
            System.out.println(driver.manage().logs().getAvailableLogTypes());
            driver.manage().logs().get("browser").forEach(l -> System.out.println(l));
            List<LogEntry> logs = driver.manage().logs().get("browser").getAll();
            assert logs.isEmpty();
            driver.navigate().to("http://localhost:8080/litecart/admin/?app=catalog&doc=catalog&category_id=1");
            items = driver.findElements(By.cssSelector("img+a[href*=\"category_id=1&product_id\"]"));
        }
    }
}
