import org.junit.Test;
import org.openqa.selenium.By;
import selenium.training.TestBase;

public class LoginTest extends TestBase {

    @Test
    public void openChromeTest() {
        driver.navigate().to("http://localhost:8080/litecart/admin/login.php");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }
}
