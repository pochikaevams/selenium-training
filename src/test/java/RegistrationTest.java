import org.junit.Test;
import org.openqa.selenium.By;
import selenium.training.TestBase;
import java.util.Random;

public class RegistrationTest extends TestBase {

    @Test
    public void newUserRegistarationTest() {
        driver.navigate().to("http://localhost:8080/litecart/en/");
        driver.findElement(By.xpath("//a[contains(text(),'New customers click here')]")).click();
        driver.findElement(By.name("firstname")).sendKeys("Ivan");
        driver.findElement(By.name("lastname")).sendKeys("Petrov");
        driver.findElement(By.name("address1")).sendKeys("1th avenue");
        driver.findElement(By.name("postcode")).sendKeys("75328");
        driver.findElement(By.name("city")).sendKeys("New York");

        driver.findElement(By.className("select2-selection__arrow")).click();
        driver.findElement(By.className("select2-search__field")).sendKeys("United States");
        driver.findElement(By.xpath("//li[text()='United States']")).click();

        Random random = new Random();
        String randomEmail = "tester1".concat(String.valueOf(random.nextInt(1000)).concat("@gmail.com"));
        driver.findElement(By.name("email")).sendKeys(randomEmail);

        driver.findElement(By.name("phone")).sendKeys("+135676543459");
        driver.findElement(By.name("password")).sendKeys("qwerty");
        driver.findElement(By.name("confirmed_password")).sendKeys("qwerty");
        driver.findElement(By.name("create_account")).click();
        driver.findElement(By.name("password")).sendKeys("qwerty");
        driver.findElement(By.name("confirmed_password")).sendKeys("qwerty");
        driver.findElement(By.name("create_account")).click();
        driver.findElement(By.xpath("//div[@class='content']//a[contains(text(),'Logout')]")).click();
        driver.findElement(By.name("email")).sendKeys(randomEmail);
        driver.findElement(By.name("password")).sendKeys("qwerty");
        driver.findElement(By.name("login")).click();
        driver.findElement(By.xpath("//div[@class='content']//a[contains(text(),'Logout')]")).click();
    }
}
