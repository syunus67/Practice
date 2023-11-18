package script;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
    private WebDriver chromeDriver;

    @BeforeClass
    public void setUp() {
    
    	chromeDriver = new ChromeDriver();
       /*  driver = new FirefoxDriver();
    	driver = new EdgeDriver();
    	driver = new SafariDriver(); */
        
    	chromeDriver.manage().window().maximize();
    	chromeDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void testLogin() {

        	
        	// 1. Navigating to a URL:
    		chromeDriver.get("https://academy.ultimateqa.com/java-sdet");
            
            // 2. Navigation Commands
            chromeDriver.navigate().back();
            chromeDriver.navigate().forward();
            chromeDriver.navigate().refresh();
            
            // 3. Finding Elements
            WebElement element = chromeDriver.findElement(By.id("form_submission_name"));
            List<WebElement> elements = chromeDriver.findElements(By.xpath("//input[@required='required']"));
            System.out.println(elements);
            
            // 4. Interacting with Elements
            element.sendKeys("Syed");
            chromeDriver.findElement(By.id("form_submission_name")).clear();
            chromeDriver.findElement(By.id("form_submission_name")).sendKeys("Syed");
            chromeDriver.findElement(By.id("form_submission_email")).sendKeys("syunus@gmail.com");
            
            // Working with Drop-downs
            Select country = new Select(chromeDriver.findElement(By.id("form_submission_address_country")));
            country.selectByVisibleText("Canada");
            Select education = new Select(chromeDriver.findElement(By.id("form_submission_custom_3")));
            education.selectByVisibleText("High School");
            
            chromeDriver.findElement(By.id("form-button")).click();
            
            // 5. Element Attributes
            String elementText = chromeDriver.findElement(By.xpath("//h1[text()='Thank you!']")).getText();
            String attributeValue = chromeDriver.findElement(By.xpath("//p[text()='We have received your submission.']")).getAttribute("class");
            //Assertions
            assertEquals(elementText, "Thank you!", "Assertion Passed");
            assertEquals(attributeValue, "lead", "Assertion Passed");
            
            // 6. Waiting for Elements
            WebDriverWait wait = new WebDriverWait(chromeDriver,Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Thank you!']")));
            
            chromeDriver.navigate().to("https://www.w3schools.com/TAGs/tag_iframe.asp");
            
            // 7. Switching Between Frames
            chromeDriver.switchTo().frame(chromeDriver.findElement(By.xpath("//iframe[contains(@name, 'tcf')]")));
            chromeDriver.switchTo().defaultContent();
            
            
         // 8. Switching Between Windows
            chromeDriver.findElement(By.partialLinkText("Try it Yourself")).click();
            Set<String> handles = chromeDriver.getWindowHandles();
            List<String> list = new ArrayList<String>(handles);
            
            /*for(String h: list) {
				 * if(chromeDriver.switchTo().window(h).getTitle().
				 * equals("W3Schools Tryit Editor")){ // chromeDriver.switchTo().window(h); //}
				 */            
            chromeDriver.switchTo().window(list.get(1));
            
            chromeDriver.close();
            chromeDriver.switchTo().window(list.get(0));
            
            // 9. Alerts and Pop-ups
            chromeDriver.navigate().to("https://demo.automationtesting.in/Alerts.html");
            chromeDriver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
            
            Alert alert = chromeDriver.switchTo().alert();
            
           // alert.dismiss();
            String alertText = alert.getText();
            System.out.println(alertText);
            alert.accept();
            
            // 10. Browser Management
            chromeDriver.manage().window().maximize();
            chromeDriver.manage().window().setSize(new Dimension(800, 600));
            chromeDriver.quit();
    }
}
