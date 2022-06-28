package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PracticePageBeta {
    WebDriver driver;
    WebDriverWait wdwait;
    WebElement testLoginPageButton;

    public PracticePageBeta(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getTestLoginPageButton() {
        return driver.findElement(By.linkText("Test Login Page"));
    }

    //-----------------------------------------------

    public void clickOnTestLoginPageButton() {
        getTestLoginPageButton().click();
    }
}
