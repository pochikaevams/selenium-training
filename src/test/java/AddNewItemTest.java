import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import selenium.training.TestBase;

import java.io.File;

public class AddNewItemTest extends TestBase {

    @Test
    public void addNewItemTest() {
        driver.navigate().to("http://localhost:8080/litecart/admin/login.php");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        driver.findElement(By.xpath("//span[text() = 'Catalog']")).click();
        driver.findElement(By.xpath("//a[text() = ' Add New Product']")).click();
        driver.findElement(By.xpath("//a[text() = 'General']")).click();
        driver.findElement(By.xpath("//input[@name='status' and contains(@value, '1')]")).click();

        driver.findElement(By.name("name[en]")).sendKeys("New Bug Product");
        driver.findElement(By.name("code")).sendKeys("12345");
        driver.findElement(By.name("quantity")).click();
        driver.findElement(By.name("quantity")).clear();
        driver.findElement(By.name("quantity")).sendKeys("10");

        String path = new File("src/test/resources/download.jpeg").getAbsolutePath();
        driver.findElement(By.name("new_images[]")).sendKeys(path);

        driver.findElement(By.name("date_valid_from")).sendKeys("01102019");
        driver.findElement(By.name("date_valid_to")).sendKeys("01122019");

        driver.findElement(By.xpath("//a[text() = 'Information']")).click();
        driver.findElement(By.name("short_description[en]")).sendKeys("Short description");
        driver.findElement(By.className("trumbowyg-editor")).sendKeys("Переключение между вкладками происходит не мгновенно, поэтому после переключения можно сделать небольшую паузу (о том, как делать более правильные ожидания, будет рассказано в следующих занятиях).");
        driver.findElement(By.name("head_title[en]")).sendKeys("Buggy");
        driver.findElement(By.name("meta_description[en]")).sendKeys("Bug");

        driver.findElement(By.xpath("//a[text() = 'Prices']")).click();
        driver.findElement(By.name("purchase_price")).sendKeys("10");

        Select sel = new Select(driver.findElement(By.name("purchase_price_currency_code")));
        sel.selectByVisibleText("US Dollars");

        driver.findElement(By.name("save")).click();
        driver.findElement(By.xpath("//a[text() = 'New Bug Product']")).isDisplayed();
    }
}
