import com.google.common.collect.Ordering;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import selenium.training.TestBase;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CountriesSortTest extends TestBase {

    @Test
    public void countryTest() {
        driver.navigate().to("http://localhost:8080/litecart/admin/?app=countries&doc=countries");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        List<WebElement> countries = driver.findElements(By.xpath("//tr[@class = 'row']/td[5]"));
        List<String> countryList = new ArrayList<String>();
        for (WebElement country : countries) {
            String countryText = country.getText();
            countryList.add(countryText);
        }
        List<String> sortedCountryList = countryList;
        sortedCountryList.sort(Comparator.naturalOrder());
        if (countryList.equals(sortedCountryList)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }

    }

}