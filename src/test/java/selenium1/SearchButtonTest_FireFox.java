package selenium1;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchButtonTest_FireFox {

    private WebDriver driver;

    @BeforeClass
    public void beforeClass() {
    	System.setProperty("webdriver.gecko.driver", "C:/Natalya/Downloads/geckodriver-v0.26.0-win64/geckodriver.exe");
        driver = new FirefoxDriver();
     
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    @Test
    public void verifySearchButtonLeft() {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://www.google.com");

        String search_text = "Google Search";
        WebElement search_button = driver.findElement(By.name("btnK"));

        String text = search_button.getAttribute("value");

        Assert.assertEquals(text, search_text, "Text not found!");
    }
    
    @Test
    public void verifySearchButtonRight() {
    	
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://www.google.com");

        String search_text = "I'm Feeling Lucky";
        WebElement search_button = driver.findElement(By.name("btnI"));

        String text = search_button.getAttribute("value");

        Assert.assertEquals(text, search_text, "Text not found!");
    }
}