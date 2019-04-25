import com.google.common.collect.Ordering;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import selenium.training.TestBase;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CountriesSortTest extends TestBase {

    @Test
    public void countrySortedTest() {
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
        Assert.assertEquals("Порядок не совпадает", countryList, sortedCountryList);
    }

    @Test
    public void zonesSortedTest() {
        driver.navigate().to("http://localhost:8080/litecart/admin/?app=countries&doc=countries");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        List<WebElement> rows = driver.findElements(By.xpath("//tr[@class = 'row']"));
        int rowsSize = rows.size();
        for (int i = 0; i < rowsSize; i++) {
            String zonesNumber = driver.findElements(By.xpath("//tr[@class = 'row']"))
                    .get(i).findElement(By.xpath("./td[6]")).getText();
            if (!zonesNumber.equals("0")) {
                driver.findElements(By.xpath("//tr[@class = 'row']"))
                        .get(i).findElement(By.xpath(".//i[@class='fa fa-pencil']")).click();
                List<WebElement> zonesNames = driver.findElements(By.xpath("//table[@class='dataTable']//td[3]"));
                List<String> zoneList = new ArrayList<String>();
                for (WebElement zone : zonesNames) {
                    String zoneText = zone.getText();
                    zoneList.add(zoneText);
                }
                List<String> sortedZoneList = zoneList;
                sortedZoneList.sort(Comparator.naturalOrder());
                Assert.assertEquals("Порядок не совпадает", zoneList, sortedZoneList);
                driver.navigate().to("http://localhost:8080/litecart/admin/?app=countries&doc=countries");
            }
        }
    }

    @Test
    public void geoZonesSortedTest() {
        driver.navigate().to("http://localhost:8080/litecart/admin/?app=geo_zones&doc=geo_zones");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        List<WebElement> rows = driver.findElements(By.xpath("//tr[@class = 'row']"));
        int rowsSize = rows.size();
        for (int i = 0; i < rowsSize; i++) {
            driver.findElements(By.xpath("//tr[@class = 'row']"))
                    .get(i).findElement(By.xpath(".//i[@class='fa fa-pencil']")).click();
            List<WebElement> zoneRows = driver.findElements(By.xpath("//select[contains(@name,'[zone')]"));
            int zoneRowsSize = zoneRows.size();
            List<String> zoneList = new ArrayList<String>();
            for (int j = 0; j < zoneRowsSize; j++) {
                List<WebElement> options = driver.findElements(By.xpath("//select[contains(@name,'[zone')]"))
                        .get(j).findElements(By.xpath("./option"));
                for (WebElement option : options) {
                    if ("true".equals(option.getAttribute("selected"))) {
                        String optionText = option.getText();
                        zoneList.add(optionText);
                    }
                }
                List<String> sortedZoneList = zoneList;
                sortedZoneList.sort(Comparator.naturalOrder());
                Assert.assertEquals("Порядок не совпадает", zoneList, sortedZoneList);
            }
            driver.navigate().to("http://localhost:8080/litecart/admin/?app=geo_zones&doc=geo_zones");
        }
    }
}
