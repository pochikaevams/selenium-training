import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.Color;
import selenium.training.TestBase;

public class ItemAttributesTest extends TestBase {

    @Test
    public void nameTest() {
        driver.navigate().to("http://localhost:8080/litecart/en/");
        String mainPageItemName = driver.findElement(By.xpath("//div[@class='content']/div[@id='box-campaigns']//li[@class='product column shadow hover-light']//div[@class='name']")).getAttribute("textContent");
        driver.findElement(By.xpath("//div[@class='content']/div[@id='box-campaigns']//li[@class='product column shadow hover-light']")).click();
        String itemPageName = driver.findElement(By.xpath("//div[@id='box-product']//h1")).getAttribute("textContent");
        if (mainPageItemName.equals(itemPageName)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    @Test
    public void priceTest() {
        driver.navigate().to("http://localhost:8080/litecart/en/");
        String mainRegularPrice = driver.findElement(By.xpath("//div[@class='content']/div[@id='box-campaigns']//li[@class='product column shadow hover-light']//div[@class='price-wrapper']/s")).getAttribute("textContent");
        String mainCompaignPrice = driver.findElement(By.xpath("//div[@class='content']/div[@id='box-campaigns']//li[@class='product column shadow hover-light']//div[@class='price-wrapper']/strong")).getAttribute("textContent");
        driver.findElement(By.xpath("//div[@class='content']/div[@id='box-campaigns']//li[@class='product column shadow hover-light']")).click();
        String itemPageRegularPrice = driver.findElement(By.xpath("//div[@class='price-wrapper']/s")).getAttribute("textContent");
        String itemPageCompaignPrice = driver.findElement(By.xpath("//div[@class='price-wrapper']/strong")).getAttribute("textContent");
        if (mainRegularPrice.equals(itemPageRegularPrice)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
        if (mainCompaignPrice.equals(itemPageCompaignPrice)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    @Test
    public void colorMainPagePriceTest() {
        driver.navigate().to("http://localhost:8080/litecart/en/");
        String mainRegularPrice = driver.findElement(By.xpath("//div[@class='content']/div[@id='box-campaigns']//li[@class='product column shadow hover-light']//div[@class='price-wrapper']/s")).getCssValue("color");
        String hexRegular = Color.fromString(mainRegularPrice).asHex();
        System.out.println(hexRegular);
        if (hexRegular.equals("#777777")) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
        String mainCompaignPrice = driver.findElement(By.xpath("//div[@class='content']/div[@id='box-campaigns']//li[@class='product column shadow hover-light']//div[@class='price-wrapper']/strong")).getCssValue("color");
        String hexCompaign = Color.fromString(mainCompaignPrice).asHex();
        System.out.println(hexCompaign);
        if (hexCompaign.equals("#cc0000")) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    @Test
    public void colorItemPagePriceTest() {
        driver.navigate().to("http://localhost:8080/litecart/en/");
        driver.findElement(By.xpath("//div[@class='content']/div[@id='box-campaigns']//li[@class='product column shadow hover-light']")).click();
        String itemPageRegularPrice = driver.findElement(By.xpath("//div[@class='price-wrapper']/s")).getCssValue("color");
        String hexRegular = Color.fromString(itemPageRegularPrice).asHex();
        System.out.println(hexRegular);
        if (hexRegular.equals("#666666")) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
        String itemPageCompaignPrice = driver.findElement(By.xpath("//div[@class='price-wrapper']/strong")).getCssValue("color");
        String hexCompaign = Color.fromString(itemPageCompaignPrice).asHex();
        System.out.println(hexCompaign);
        if (hexCompaign.equals("#cc0000")) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
}

    @Test
    public void mainPageSizePriceTest() {
        driver.navigate().to("http://localhost:8080/litecart/en/");
        Dimension mainPageRegularPrice = driver.findElement(By.xpath("//div[@class='content']/div[@id='box-campaigns']//li[@class='product column shadow hover-light']//div[@class='price-wrapper']/s")).getSize();
        Dimension mainPageCompaignPrice = driver.findElement(By.xpath("//div[@class='content']/div[@id='box-campaigns']//li[@class='product column shadow hover-light']//div[@class='price-wrapper']/strong")).getSize();
        System.out.println(mainPageRegularPrice);
        System.out.println(mainPageCompaignPrice);
        double sizeRegularPrice = mainPageRegularPrice.getHeight() * mainPageRegularPrice.getWidth();
        double sizeCompaignPrice = mainPageCompaignPrice.getHeight() * mainPageCompaignPrice.getWidth();
        if (sizeCompaignPrice > sizeRegularPrice) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    @Test
    public void itemPageSizePriceTest() {
        driver.navigate().to("http://localhost:8080/litecart/en/");
        driver.findElement(By.xpath("//div[@class='content']/div[@id='box-campaigns']//li[@class='product column shadow hover-light']")).click();
        Dimension itemPageRegularPrice = driver.findElement(By.xpath("//div[@class='price-wrapper']/s")).getSize();
        Dimension itemPageCompaignPrice = driver.findElement(By.xpath("//div[@class='price-wrapper']/strong")).getSize();
        System.out.println(itemPageRegularPrice);
        System.out.println(itemPageCompaignPrice);
        double sizeRegularPrice = itemPageRegularPrice.getHeight() * itemPageRegularPrice.getWidth();
        double sizeCompaignPrice = itemPageCompaignPrice.getHeight() * itemPageCompaignPrice.getWidth();
        if (sizeCompaignPrice > sizeRegularPrice) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

}
