package selenium1;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchButtonTest_Chrome {

    private WebDriver driver;

   @BeforeClass
    public void beforeClass() {
	   
	   System.setProperty("webdriver.chrome.driver", "C:/Natalya/Downloads/chromedriver_win32/chromedriver.exe");;

       driver = new ChromeDriver();
 
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
    
    @Test
    public void verifySearchInputField() {
    	
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://www.google.com");

        WebElement search_input_field = driver.findElement(By.name("q"));
        search_input_field.sendKeys("google" + Keys.ENTER);
        
        //Find an element which contains number of search results
        WebElement result_stats = driver.findElement(By.id("result-stats"));
        
        Assert.assertNotNull(result_stats);
    }
}