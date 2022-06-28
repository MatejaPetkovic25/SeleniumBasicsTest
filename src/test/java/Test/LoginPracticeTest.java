package Test;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPracticeTest extends BaseTest {

    String validUsername = "student";
    String validPassword = "Password123";
    String invalidUsername = "pogresan username";
    String invalidPassword = "pogresan password";

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.navigate().to("https://practicetestautomation.com/");
    }

    @Test
    public void successfulLogin()  {
        homepagePage.clickOnPracticeButton();
        practicePage.clickOnTestLoginPageButton();
        loginPage.insertUsername(validUsername);
        loginPage.insertPassword(validPassword);
        scrollIntoView(loginPage.getSubmitButton());
        loginPage.clickOnSubmitButton();
        visibilityWait(logoutPage.getLogoutButton());
        Assert.assertTrue(logoutPage.getLogoutButton().isDisplayed());
    }

}