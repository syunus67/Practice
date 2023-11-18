package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.BasePage;

public class LoginPage extends BasePage {
    private By name = By.id("form_submission_name");
    private By email = By.id("form_submission_email");
    private By lernMore = By.id("form-button");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String username) {
        driver.findElement(name).sendKeys(username);
    }

    public void enterEmail(String password) {
        driver.findElement(email).sendKeys(password);
    }

    public void clickLearnButton() {
        driver.findElement(lernMore).click();
    }
    
    
}
