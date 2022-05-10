package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class LoginPageTest extends TestBase {

    HomePage homePage;
    LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)

    public void initialize() {
        homePage = new HomePage();
        loginPage = new LoginPage();
    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void userShouldNavigateToLoginPageSuccessFully() {
        homePage.clickOnLoginLink();
        loginPage.verifyWelcomeText();
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyTheErrorMessageWithInValidCredentials() {
        homePage.clickOnLoginLink();
        loginPage.enterEmailId("xyw@gmail.com");
        loginPage.enterPassword("xyw1234");
        loginPage.clickOnLoginButton();
        loginPage.verifyInvalidCredentialErrorMessage("Login was unsuccessful. " +
                "Please correct the errors and try again.");
    }

    @Test(groups = {"regression"})
    public void verifyThatUserShouldLogInSuccessFullyWithValidCredentials() {

        homePage.clickOnLoginLink();
        loginPage.enterEmailId("LalitaPatel123@gmail.com");
        loginPage.enterPassword("Lalita1234");
        loginPage.clickOnLoginButton();
        homePage.verifyLogoutLinkVisible();
    }

    @Test(groups = {"regression"})
    public void VerifyThatUserShouldLogOutSuccessFully() {
        homePage.clickOnLoginLink();
        loginPage.enterEmailId("LalitaPatel125@gmail.com");
        loginPage.enterPassword("Lalita1234");
        loginPage.clickOnLoginButton();
        homePage.clickOnLogoutLink();
        homePage.verifyLoginLinkVisible();
    }

}
