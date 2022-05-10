package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.pages.RegisterPage;
import com.nopcommerce.demo.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class RegisterPageTest extends TestBase {

    HomePage homePage;
    LoginPage loginPage;
    RegisterPage registerPage;

    @BeforeMethod(alwaysRun = true)

    public void initialize() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        registerPage = new RegisterPage();
    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() throws InterruptedException {
        homePage.clickOnRegisterLink();
        registerPage.verifyRegisterText("Register");

    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatFirstNameLastNameEmailPasswordAndConfirmPasswordFieldsAreMandatory() {
        homePage.clickOnRegisterLink();
        registerPage.clickOnRegisterButton();
        registerPage.verifyFirstNameRequiredErrorText("First name is required.");
        registerPage.verifyLastNameReqiredErrorText("Last name is required.");
        registerPage.verifyEmailRequiredErrorText("Email is required.");
        registerPage.verifyPasswordRequiredErrorText("Password is required.");
        registerPage.verifyConfirmPasswordRequiredErrorText("Password is required.");
    }

    @Test(groups = {"regression"})
    public void verifyThatUserShouldCreateAccountSuccessfully() {
        homePage.clickOnRegisterLink();
        registerPage.selectGender("Female");
        registerPage.inputFirstName("Lalita");
        registerPage.inputLastName("Patel");
        registerPage.selectDateOfBirth("1", "January", "1985");
        registerPage.inputEmail("LalitaPatel125@gmail.com");
        registerPage.inputPassword("Lalita1234");
        registerPage.inputConfirmPassword("Lalita1234");
        registerPage.clickOnRegisterButton();
        registerPage.verifyRegistrationCompletedText("Your registration completed");
    }

}
