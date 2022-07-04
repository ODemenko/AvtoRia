import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AvtoRia {
    By searchButton = By.xpath("//button[@type='submit']");
    By brand = By.xpath("//input[@id='brandTooltipBrandAutocompleteInput-brand']");
    By model = By.xpath("//input[@id='brandTooltipBrandAutocompleteInput-model']");
    By region = By.xpath("//label[@data-text='Регіон']");
    By yearFrom = By.xpath("//select[@aria-label='Рік від']");
    By yearTo = By.xpath("//select[@aria-label='Рік до']");
    By priceFrom = By.xpath("//input[@id='priceFrom']");
    By priceTo = By.xpath("//input[@id='priceTo']");

    @Test
    public void openSite() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://auto.ria.com/uk/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.findElement(brand).sendKeys("BMW");
        driver.findElement(By.xpath("//li[@data-value='9']")).click();
        driver.findElement(model).sendKeys("X6");
        driver.findElement(By.xpath("//li[@data-value='2153']")).click();
        driver.findElement(region).click();
        driver.findElement(By.xpath("//a[text()='Одеса']")).click();
        driver.findElement(yearFrom).click();
        driver.findElement(By.xpath("//select[@data-placeholder='від']/option[@value='2014']")).click();
        driver.findElement(yearTo).click();
        driver.findElement(By.xpath("//select[@data-placeholder='до']/option[@value='2020']")).click();
        driver.findElement(priceFrom).sendKeys("1000");
        driver.findElement(priceTo).sendKeys("5000");
        driver.findElement(searchButton).click();

    }
}
