package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageBeta {
    WebDriver driver;
    WebDriverWait wdwait;
    WebElement username;
    WebElement password;
    WebElement submitButton;
    WebElement errorNotification;

    public LoginPageBeta(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getUsername() {
        return driver.findElement(By.id("username"));
    }

    public WebElement getPassword() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getSubmitButton() {
        return driver.findElement(By.id("submit"));
    }

    public WebElement getErrorNotification() {
        return driver.findElement(By.id("error"));
    }

    //-----------------------------------------------

    public void insertUsername(String username) {
        getUsername().clear();
        getUsername().sendKeys(username);
    }

    public void insertPassword(String password) {
        getPassword().clear();
        getPassword().sendKeys(password);
    }

    public void clickOnSubmitButton() {
        getSubmitButton().click();
    }
}
