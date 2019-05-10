import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.training.TestBase;

import java.util.List;
import java.util.Set;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class WindowTest extends TestBase {

    @Test
    public void linksOpenNewWindowTest() {
        driver.navigate().to("http://localhost:8080/litecart/admin/?app=countries&doc=countries");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        driver.findElements(By.xpath("//i[@class = 'fa fa-pencil']")).get(0).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//i[@class = 'fa fa-external-link']")));

        List<WebElement> links = driver.findElements(By.xpath("//i[@class = 'fa fa-external-link']"));
        String mainWindow = driver.getWindowHandle();
        Set<String> oldWindows = driver.getWindowHandles();
        for (WebElement link : links) {
            driver.findElement(By.xpath("//i[@class = 'fa fa-external-link']")).click();
            wait.until(numberOfWindowsToBe(2));
            Set<String> allWindows = driver.getWindowHandles();
            allWindows.removeAll(oldWindows);
            String newWindow = allWindows.iterator().next();
            driver.switchTo().window(newWindow);
            driver.close();
            driver.switchTo().window(mainWindow);
        }
    }
}
