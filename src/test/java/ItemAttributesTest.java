import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import selenium.training.TestBase;

public class ItemAttributesTest extends TestBase {

    @Test
    public void nameTest() {
        driver.navigate().to("http://localhost:8080/litecart/en/");
        String mainPageItemName = driver.findElement(By.xpath("//div[@class='content']/div[@id='box-campaigns']//li[@class='product column shadow hover-light']//div[@class='name']")).getAttribute("textContent");
        driver.findElement(By.xpath("//div[@class='content']/div[@id='box-campaigns']//li[@class='product column shadow hover-light']")).click();
        String itemPageName = driver.findElement(By.xpath("//div[@id='box-product']//h1")).getAttribute("textContent");
        Assert.assertEquals(mainPageItemName, itemPageName);
    }

    @Test
    public void priceTest() {
        driver.navigate().to("http://localhost:8080/litecart/en/");
        String mainRegularPrice = driver.findElement(By.xpath("//div[@class='content']/div[@id='box-campaigns']//li[@class='product column shadow hover-light']//div[@class='price-wrapper']/s")).getAttribute("textContent");
        String mainCompaignPrice = driver.findElement(By.xpath("//div[@class='content']/div[@id='box-campaigns']//li[@class='product column shadow hover-light']//div[@class='price-wrapper']/strong")).getAttribute("textContent");
        driver.findElement(By.xpath("//div[@class='content']/div[@id='box-campaigns']//li[@class='product column shadow hover-light']")).click();
        String itemPageRegularPrice = driver.findElement(By.xpath("//div[@class='price-wrapper']/s")).getAttribute("textContent");
        String itemPageCompaignPrice = driver.findElement(By.xpath("//div[@class='price-wrapper']/strong")).getAttribute("textContent");
        Assert.assertEquals(mainRegularPrice, itemPageRegularPrice);
        Assert.assertEquals(mainCompaignPrice, itemPageCompaignPrice);
    }

    @Test
    public void colorMainPagePriceTest() {
        driver.navigate().to("http://localhost:8080/litecart/en/");
        String mainRegularPrice = driver.findElement(By.xpath("//div[@id='box-campaigns']//div[@class='price-wrapper']/s")).getCssValue("color");
        System.out.println(mainRegularPrice);
        String[] mainRegPrice = mainRegularPrice.split(",");
        Assert.assertEquals(mainRegPrice[0], mainRegPrice[1], mainRegPrice[2]);
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='box-campaigns']//div[@class='price-wrapper']/s")).getTagName(), "s");
        String mainCompaignPrice = driver.findElement(By.xpath("//div[@id='box-campaigns']//div[@class='price-wrapper']/strong")).getCssValue("color");
        System.out.println(mainCompaignPrice);
        String[] mainComPrice = mainCompaignPrice.split(",");
        Assert.assertEquals(mainComPrice[1], mainComPrice[2], " 0");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='box-campaigns']//div[@class='price-wrapper']/strong")).getTagName(), "strong");
    }

    @Test
    public void colorItemPagePriceTest() {
        driver.navigate().to("http://localhost:8080/litecart/en/");
        driver.findElement(By.xpath("//div[@class='content']/div[@id='box-campaigns']//li[@class='product column shadow hover-light']")).click();
        String itemPageRegularPrice = driver.findElement(By.xpath("//div[@class='price-wrapper']/s")).getCssValue("color");
        System.out.println(itemPageRegularPrice);
        String[] itemRegPrice = itemPageRegularPrice.split(",");
        Assert.assertEquals(itemRegPrice[0], itemRegPrice[1], itemRegPrice[2]);
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='price-wrapper']/s")).getTagName(), "s");
        String itemPageCompaignPrice = driver.findElement(By.xpath("//div[@class='price-wrapper']/strong")).getCssValue("color");
        System.out.println(itemPageCompaignPrice);
        String[] itemComPrice = itemPageCompaignPrice.split(",");
        Assert.assertEquals(itemComPrice[1], itemComPrice[2], " 0");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='price-wrapper']/strong")).getTagName(), "strong");
    }

    @Test
    public void mainPageSizePriceTest() {
        driver.navigate().to("http://localhost:8080/litecart/en/");
        String mainPageRegularPrice = driver.findElement(By.xpath("//div[@id='box-campaigns']//div[@class='price-wrapper']/s")).getCssValue("font-size").replace("px", "");
        Double mainPageRegularPriceDouble = Double.parseDouble(mainPageRegularPrice);
        String mainPageCompaignPrice = driver.findElement(By.xpath("//div[@id='box-campaigns']//div[@class='price-wrapper']/strong")).getCssValue("font-size").replace("px", "");
        Double mainPageCompaignPriceDouble = Double.parseDouble(mainPageCompaignPrice);
        System.out.println(mainPageRegularPrice);
        System.out.println(mainPageCompaignPrice);
        assert (mainPageRegularPriceDouble < mainPageCompaignPriceDouble);
    }

    @Test
    public void itemPageSizePriceTest() {
        driver.navigate().to("http://localhost:8080/litecart/en/");
        driver.findElement(By.xpath("//div[@class='content']/div[@id='box-campaigns']//li[@class='product column shadow hover-light']")).click();
        String itemPageRegularPrice = driver.findElement(By.xpath("//div[@class='price-wrapper']/s")).getCssValue("font-size").replace("px", "");
        Double itemPageRegularPriceDouble = Double.parseDouble(itemPageRegularPrice);
        String itemPageCompaignPrice = driver.findElement(By.xpath("//div[@class='price-wrapper']/strong")).getCssValue("font-size").replace("px", "");
        Double itemPageCompaignPriceDouble = Double.parseDouble(itemPageCompaignPrice);
        System.out.println(itemPageRegularPrice);
        System.out.println(itemPageCompaignPrice);
        assert (itemPageRegularPriceDouble < itemPageCompaignPriceDouble);
    }
}
