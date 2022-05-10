package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DesktopsPage extends Utility {

    public DesktopsPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//h1[contains(text(),'Desktops')]")
    WebElement desktopText;

    @FindBy(id = "products-orderby")
    WebElement sortBy;

    @FindBy(id = "products-pagesize")
    WebElement displayBy;

    @FindBy(xpath = "//a[contains(text(),'List')]")
    WebElement selectProductList;

    @FindBy(xpath = "//div[@class='picture']")
    WebElement selectProduct;

    public void verifyDesktopText(){
        verifyThatTextIsDisplayed(desktopText, "Desktops");
    }

    public void clickOnSortBy(){
        clickOnElement(sortBy);
    }

    public void clickOnDisplayBy(){
        clickOnElement(displayBy);
    }

    public void clickOnProductList(){
        clickOnElement(displayBy);
    }
    public void selectProductFromDesktopPage(String product){

        clickOnElement(selectProduct,product);

    }

}
