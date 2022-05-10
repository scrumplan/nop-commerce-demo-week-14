package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends Utility {

    public RegisterPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//h1[contains(text(),'Register')]")
    WebElement registerText;

    @FindBy(xpath = "//input[@name='Gender']")
    WebElement gender;

    @FindBy(id = "FirstName")
    WebElement firstName;

    @FindBy(id = "LastName")
    WebElement lastName;

    @FindBy(xpath = "//select[@name='DateOfBirthDay']")
    WebElement dateOfBirthDay;

    @FindBy(xpath = "//select[@name='DateOfBirthMonth']")
    WebElement dateOfBirthMonth;

    @FindBy(xpath = "//select[@name='DateOfBirthYear']")
    WebElement dateOfBirthYear;

    @FindBy(id = "Email")
    WebElement email;

    @FindBy(id = "Password")
    WebElement password;

    @FindBy(id = "ConfirmPassword")
    WebElement confirmPassword;

    @FindBy(id = "register-button")
    WebElement registerButton;

    @FindBy(id = "FirstName-error")
    WebElement firstNameErrorText;

    @FindBy(id = "LastName-error")
    WebElement lastNameErrorText;

    @FindBy(id = "Email-error")
    WebElement emailErrorText;

    @FindBy(id = "Password-error")
    WebElement passwordErrorText;

    @FindBy(id = "ConfirmPassword-error")
    WebElement confirmPasswordErrorText;

    @FindBy(xpath = "//div[contains(text(),'Your registration completed')]")
    WebElement registrationCompleted;

    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement continueBtn;


    public void verifyRegisterText(String text) throws InterruptedException {
        verifyThatTextIsDisplayed(registerText, text);

    }

    public void selectGender(String text) {
        clickOnElement(gender, text);

    }

    public void inputFirstName(String name) {
        sendTextToElement(firstName, name);

    }

    public void inputLastName(String lname) {
        sendTextToElement(lastName, lname);

    }

    public void inputEmail(String text) {
        sendTextToElement(email, text);

    }

    public void selectDateOfBirth(String day, String month, String year) {
        selectByVisibleTextFromDropDown(dateOfBirthDay, day);
        selectByVisibleTextFromDropDown(dateOfBirthMonth, month);
        selectByVisibleTextFromDropDown(dateOfBirthYear, year);
    }

    public void inputPassword(String pswd) {
        sendTextToElement(password, pswd);

    }

    public void inputConfirmPassword(String cpassword) {
        sendTextToElement(confirmPassword, cpassword);

    }

    public void clickOnRegisterButton() {
        clickOnElement(registerButton);

    }

    public void verifyFirstNameRequiredErrorText(String text) {
        verifyThatTextIsDisplayed(firstNameErrorText, text);

    }

    public void verifyLastNameReqiredErrorText(String text) {
        verifyThatTextIsDisplayed(lastNameErrorText, text);

    }

    public void verifyEmailRequiredErrorText(String text) {
        verifyThatTextIsDisplayed(emailErrorText, text);

    }

    public void verifyPasswordRequiredErrorText(String text) {
        verifyThatTextIsDisplayed(passwordErrorText, text);

    }

    public void verifyConfirmPasswordRequiredErrorText(String text) {
        verifyThatTextIsDisplayed(confirmPasswordErrorText, text);

    }

    public void verifyRegistrationCompletedText(String text) {
        verifyThatTextIsDisplayed(registrationCompleted, text);

    }

    public void clickOnContinueButton() {
        clickOnElement(continueBtn);

    }
}
