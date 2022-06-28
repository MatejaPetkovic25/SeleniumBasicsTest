package Base;

import Pages.HomepagePageBeta;
import Pages.LoginPageBeta;
import Pages.LogoutPageBeta;
import Pages.PracticePageBeta;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

public class BaseTestBeta {
    public WebDriver driver;
    public WebDriverWait wdwait;
    public HomepagePageBeta homepagePageBeta;
    public PracticePageBeta practicePageBeta;
    public LoginPageBeta loginPageBeta;
    public LogoutPageBeta logoutPageBeta;
    public ExcelReader excelReader;

    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        homepagePageBeta = new HomepagePageBeta(driver, wdwait);
        practicePageBeta = new PracticePageBeta(driver, wdwait);
        loginPageBeta = new LoginPageBeta(driver, wdwait);
        logoutPageBeta = new LogoutPageBeta(driver, wdwait);
        excelReader = new ExcelReader("C:\\Users\\Korisnik\\Desktop\\LoginTest.xlsx");

    }

    public void visibilityWait(WebElement element) {
        wdwait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clickabilityWait(WebElement element) {
        wdwait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void scrollIntoView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }


    @AfterClass
    public void tearDown() {
        //driver.close();
        //driver.quit();
    }
}
