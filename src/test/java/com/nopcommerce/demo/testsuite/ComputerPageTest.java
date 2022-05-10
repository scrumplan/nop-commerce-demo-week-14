package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.*;
import com.nopcommerce.demo.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;


@Listeners(CustomListeners.class)
public class ComputerPageTest extends TestBase {

    HomePage homePage;
    LoginPage loginPage;
    ComputerPage computerPage;
    DesktopsPage desktopsPage;
    BuildYourOwnComputerPage buildYourOwnComputerPage;

    @BeforeMethod(alwaysRun = true)
    public void initialize() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        computerPage = new ComputerPage();
        desktopsPage = new DesktopsPage();
        buildYourOwnComputerPage = new BuildYourOwnComputerPage();
    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyUserShouldNavigateToComputerPageSuccessfully() {
        homePage.selectMenu("Computers");
        computerPage.verifyComputerText("Computers");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        homePage.selectMenu("Computers");
        computerPage.clickOnDesktopLink();
        desktopsPage.verifyDesktopText();
    }

    @Test(groups = {"regression"}, dataProvider = "configuration", dataProviderClass = TestData.class)
    public void verifyThatUserShouldBuildYouOwnComputerAndAddThemToCartSuccessfully(String processor, String ram, String hdd, String os, String software) {
        homePage.selectMenu("Computers");
        computerPage.clickOnDesktopLink();
        desktopsPage.selectProductFromDesktopPage("Build your own computer");
        buildYourOwnComputerPage.buildConfigurationFromList(processor, ram, hdd, os, software);
        buildYourOwnComputerPage.clickOnAddToCartButton();
        buildYourOwnComputerPage.verifyProductAddedToCartMessage("The product has been added to your shopping cart");
    }


}
