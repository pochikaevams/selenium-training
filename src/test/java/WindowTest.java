import org.junit.Test;
import org.openqa.selenium.By;
import selenium.training.TestBase;

public class WindowTest extends TestBase {

    @Test
    public void linksOpenNewWindowTest() {
        driver.navigate().to("http://localhost:8080/litecart/admin/?app=countries&doc=countries");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

    }
}
