

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import selenium.training.TestBase;
import selenium.training.pages.MainPage;

public class OpenBrowserTest extends TestBase {


    @Test
    public void openChromeTest() {
        driver.navigate().to("http://www.google.com");
    }
}
