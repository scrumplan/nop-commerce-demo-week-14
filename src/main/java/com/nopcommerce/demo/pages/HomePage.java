package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends Utility {

    public HomePage(){
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//h1[contains(text(),'Computers')]")
    WebElement computerTab;

    @FindBy(xpath = "//h1[contains(text(),'Electronics')]")
    WebElement electronicsTab;

    @FindBy(xpath = "//h1[contains(text(),'Apparel')]")
    WebElement apparelTab;

    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Digital downloads']")
    WebElement digitalDownloadsTab;

    @FindBy(xpath="//h1[contains(text(),'Books')]")
    WebElement BooksTab;

    @FindBy(xpath="//h1[contains(text(),'Jewelry')]")
    WebElement jewelryTab;

    @FindBy(xpath="//h1[contains(text(),'Gift Cards')]")
    WebElement giftCardsTab;

    @FindBy(linkText = "Log in")
    WebElement getLoginLink;

    @FindBy(linkText = "Register")
    WebElement getRegisterLink;

    @FindBy(xpath = "//img[@alt='nopCommerce demo store']")
    WebElement getNopCommerceLogo;

    @FindBy(xpath = "//a[contains(text(),'My account')]")
    WebElement getmyAccountLink;

    @FindBy(xpath = "//a[contains(text(),'Log out')]")
    WebElement getlogoutLink;



    public void clickOnLoginLink() {
        clickOnElement(getLoginLink);
    }

    public void clickOnRegisterLink() {
        clickOnElement(getRegisterLink);
    }

    public void verifyNopCommerceLogoVisible(){
        verifyLogoVisible(getNopCommerceLogo);

    }

    public void clickOnLogoutLink(){
        clickOnElement(getlogoutLink);

    }

    public void verifyLogoutLinkVisible(){
        verifyThatElementIsDisplayed(getlogoutLink);

    }

    public void verifyLoginLinkVisible() {
        verifyThatElementIsDisplayed(getLoginLink);
    }

    public void selectMenu(String menu) {
        List<WebElement> topMenuNames = driver.findElements(By.xpath("//div[@class='header-menu']//li"));
        for (WebElement names : topMenuNames) {
            if (names.getText().equalsIgnoreCase(menu)) {
                names.click();
                break;
            }
        }
    }


}
