

import org.junit.Test;
import selenium.training.TestBase;

public class OpenBrowserTest extends TestBase {

    @Test
    public void openChromeTest() {
        driver.navigate().to("http://www.google.com");
    }
}
