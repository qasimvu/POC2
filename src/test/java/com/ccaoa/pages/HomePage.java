package com.ccaoa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


// Created by Qasim Alam

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver){

        this.driver=driver;
    }

    // This element is use to enter text in Location field
    @FindBy(how=How.ID, using="search-form_location")
    WebElement txtLocation;

    // This element is use to enter text in From And To field
    @FindBy(how=How.ID, using="search-form_dateRange")
    WebElement txtFromAndTo;

    // This element is use to enter text in Child Care Type field
    @FindBy(how=How.XPATH, using="//div[contains(text(),'Add type')]")
    WebElement ddChildCareType;

    // This element is use to enter text in Child Age field
    @FindBy(how=How.XPATH, using="//div[contains(text(),'Add age')]")
    WebElement ddChildAge;

    // This element is use to click on search field
    @FindBy(how=How.ID, using="search-submit-btn")
    WebElement icnSearch;

    //This element is use to click on DropDown menu
    @FindBy(how= How.XPATH, using="//*[@id=\"dropdown-menu-trigger\"]")
    WebElement ddMenu;

    //This element is use to click on Sign In link
    @FindBy(how= How.PARTIAL_LINK_TEXT, using="Sign in")
    WebElement lnkSignIn;

    //This element is use to click on Free Trial link
    @FindBy(how= How.PARTIAL_LINK_TEXT, using="Free Trial")
    WebElement lnkFreeTrial;

    //This element is use to click on About link
    @FindBy(how= How.PARTIAL_LINK_TEXT, using="About")
    WebElement lnkAbout;

    //This element is use to click on Help link
    @FindBy(how= How.PARTIAL_LINK_TEXT, using="Help")
    WebElement lnkHelp;

    //This element is use to click on Log Out link
    @FindBy(how= How.PARTIAL_LINK_TEXT, using="Log out")
    WebElement lnkSignOut;

    // This element is use for success message
    @FindBy(how= How.XPATH, using="//div[@class='ant-message']/div")
    WebElement lblSuccessMessage;

    // Method to click on Dropdown menu
    public void clickDropdownMenu(){
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(ddMenu));
        ddMenu.click();
    }

    // Method to click on Dropdown menu
    public void clickSignIn() {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(lnkSignIn));
        lnkSignIn.click();
    }

    // Method to click on Sign Out
    public void clickSignOut() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(lnkSignOut));
        lnkSignOut.click();
        wait.until(ExpectedConditions.visibilityOf(lblSuccessMessage));
        String strLogoutMessage = lblSuccessMessage.getText();
        System.out.println(strLogoutMessage);
    }
}
