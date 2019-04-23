import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import selenium.training.TestBase;

import java.util.List;

public class AdminTest extends TestBase {

    @Test
    public void menuTest() {
        driver.navigate().to("http://localhost:8080/litecart/admin/login.php");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        List<WebElement> menus = driver.findElements(By.id("app-"));
        int sizeOfMenu = menus.size();
        for (int i = 0; i < sizeOfMenu; i++) {
            driver.findElements(By.id("app-")).get(i).click();
            driver.findElement(By.xpath("//td[@id='content']/h1")).isDisplayed();
            List<WebElement> subMenu = driver.findElements(By.xpath("//li[contains(@id,'doc-')]"));
            int sizeOfSubMenu = subMenu.size();
            for (int j = 0; j < sizeOfSubMenu; j++) {
                driver.findElements(By.xpath("//li[contains(@id,'doc-')]")).get(j).click();
                driver.findElement(By.xpath("//td[@id='content']/h1")).isDisplayed();
            }
        }
    }
}

