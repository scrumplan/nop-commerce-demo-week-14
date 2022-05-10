package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComputerPage extends Utility {

    public ComputerPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//h1[contains(text(),'Computers')]")
    WebElement computersText;

    @FindBy(xpath = "//img[@title='Show products in category Desktops']")
    WebElement desktopLink;

    @FindBy(xpath = "//img[@title='Show products in category Notebooks']")
    WebElement notebooksLink;

    @FindBy(xpath = "//img[@title='Show products in category Software']")
    WebElement softwareLink;

    public void verifyComputerText(String text)
    {
        verifyThatTextIsDisplayed(computersText, "Computers");
    }

    public void clickOnDesktopLink()
    {
        clickOnElement(desktopLink);
    }

    public void clickOnNotebooksLink()
    {
        clickOnElement(notebooksLink);
    }

    public void clickOnSoftwareLink()
    {
        clickOnElement(softwareLink);
    }

}
