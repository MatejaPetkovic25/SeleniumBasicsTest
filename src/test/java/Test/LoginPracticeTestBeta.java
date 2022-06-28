package Test;

import Base.BaseTestBeta;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Locale;

import static org.openqa.selenium.Keys.ENTER;

public class LoginPracticeTestBeta extends BaseTestBeta {

    String validUsername = "student";
    String validPassword = "Password123";
    String invalidUsername = "invalid username";
    String invalidPassword = "invalid password";

    String invalidUsernameMessage = "Your username is invalid!";
    String invalidPasswordMessage = "Your password is invalid!";


    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.navigate().to("https://practicetestautomation.com/");

    }

    @Test (priority = 10)
    public void succesfullLogin() {
        homepagePageBeta.clickOnPracticeButton();
        practicePageBeta.clickOnTestLoginPageButton();
        loginPageBeta.insertUsername(validUsername);
        loginPageBeta.insertPassword(validPassword);
        scrollIntoView(loginPageBeta.getSubmitButton());
        loginPageBeta.clickOnSubmitButton();
        visibilityWait(logoutPageBeta.getMessage());
        Assert.assertTrue(logoutPageBeta.getMessage().isDisplayed());
        Assert.assertTrue(logoutPageBeta.getLogoutButton().isDisplayed());

    }

    @Test (priority = 20)
    public void clickOnSubmitWithoutEnteringUsernameAndPassword() {
        homepagePageBeta.clickOnPracticeButton();
        practicePageBeta.clickOnTestLoginPageButton();
        scrollIntoView(loginPageBeta.getSubmitButton());
        loginPageBeta.clickOnSubmitButton();
        visibilityWait(loginPageBeta.getErrorNotification());
        Assert.assertTrue(loginPageBeta.getSubmitButton().isDisplayed());
        Assert.assertTrue(loginPageBeta.getErrorNotification().isDisplayed());
    }

    @Test (priority = 30)
    public void loginWithInvalidUsername() {
        homepagePageBeta.clickOnPracticeButton();
        practicePageBeta.clickOnTestLoginPageButton();
        loginPageBeta.getUsername().sendKeys(invalidUsername);
        loginPageBeta.getPassword().sendKeys(validPassword);
        scrollIntoView(loginPageBeta.getSubmitButton());
        loginPageBeta.clickOnSubmitButton();
        visibilityWait(loginPageBeta.getErrorNotification());
        Assert.assertTrue(loginPageBeta.getSubmitButton().isDisplayed());
        Assert.assertTrue(loginPageBeta.getErrorNotification().isDisplayed());
        Assert.assertEquals(loginPageBeta.getErrorNotification().getText(), invalidUsernameMessage);
    }

    @Test (priority = 40)
    public void loginWithInvalidPassword() {
        homepagePageBeta.clickOnPracticeButton();
        practicePageBeta.clickOnTestLoginPageButton();
        loginPageBeta.getUsername().sendKeys(validUsername);
        loginPageBeta.getPassword().sendKeys(invalidPassword);
        scrollIntoView(loginPageBeta.getSubmitButton());
        loginPageBeta.clickOnSubmitButton();
        visibilityWait(loginPageBeta.getErrorNotification());
        Assert.assertTrue(loginPageBeta.getSubmitButton().isDisplayed());
        Assert.assertTrue(loginPageBeta.getErrorNotification().isDisplayed());
        Assert.assertEquals(loginPageBeta.getErrorNotification().getText(), invalidPasswordMessage);
    }

    @Test (priority = 50)
    public void loginWithInvalidUsernameAndInvalidPassword() {
        homepagePageBeta.clickOnPracticeButton();
        practicePageBeta.clickOnTestLoginPageButton();
        loginPageBeta.getUsername().sendKeys(invalidUsername);
        loginPageBeta.getPassword().sendKeys(invalidPassword);
        scrollIntoView(loginPageBeta.getSubmitButton());
        loginPageBeta.clickOnSubmitButton();
        visibilityWait(loginPageBeta.getErrorNotification());
        Assert.assertTrue(loginPageBeta.getSubmitButton().isDisplayed());
        Assert.assertTrue(loginPageBeta.getErrorNotification().isDisplayed());
        Assert.assertEquals(loginPageBeta.getErrorNotification().getText(), invalidUsernameMessage);
    }

    @Test (priority = 60)
    public void loginWithValidUsernameTurnedToAllCaps() {
        homepagePageBeta.clickOnPracticeButton();
        practicePageBeta.clickOnTestLoginPageButton();
        loginPageBeta.getUsername().sendKeys(validUsername.toUpperCase(Locale.ROOT));
        loginPageBeta.getPassword().sendKeys(validPassword);
        scrollIntoView(loginPageBeta.getSubmitButton());
        loginPageBeta.clickOnSubmitButton();
        visibilityWait(loginPageBeta.getErrorNotification());
        Assert.assertTrue(loginPageBeta.getSubmitButton().isDisplayed());
        Assert.assertTrue(loginPageBeta.getErrorNotification().isDisplayed());
        Assert.assertEquals(loginPageBeta.getErrorNotification().getText(), invalidUsernameMessage);
    }

    @Test (priority = 70)
    public void loginByPressingEnterKeyInsteadOfClickingOnTheSubmitButton() {
        homepagePageBeta.clickOnPracticeButton();
        practicePageBeta.clickOnTestLoginPageButton();
        loginPageBeta.getUsername().sendKeys(validUsername);
        loginPageBeta.getPassword().sendKeys(validPassword);
        loginPageBeta.getPassword().sendKeys(ENTER);
        Assert.assertTrue(loginPageBeta.getSubmitButton().isDisplayed());
        boolean check = false;
        try {
            check = loginPageBeta.getErrorNotification().isDisplayed();
        } catch (Exception e) {

        }
        Assert.assertFalse(check);
    }

    @Test (priority = 80)
    public void succesfullLogOutTest() {
        homepagePageBeta.clickOnPracticeButton();
        practicePageBeta.clickOnTestLoginPageButton();
        loginPageBeta.getUsername().sendKeys(validUsername);
        loginPageBeta.getPassword().sendKeys(validPassword);
        scrollIntoView(loginPageBeta.getSubmitButton());
        loginPageBeta.clickOnSubmitButton();
        visibilityWait(logoutPageBeta.getMessage());
        logoutPageBeta.clickOnLogoutButton();
        visibilityWait(loginPageBeta.getSubmitButton());
        Assert.assertTrue(loginPageBeta.getSubmitButton().isDisplayed());
        Assert.assertTrue(loginPageBeta.getUsername().isDisplayed());
    }
}
