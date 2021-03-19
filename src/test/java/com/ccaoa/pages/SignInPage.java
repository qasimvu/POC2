package com.ccaoa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SignInPage {

    WebDriver driver;

    public SignInPage(WebDriver driver) {

        this.driver = driver;
    }

    // This element is use to enter text in UserName field
    @FindBy(how = How.ID, using = "username")
    WebElement txtUserName;

    // This element is use to enter text in Password field
    @FindBy(how = How.ID, using = "password")
    WebElement txtPassword;

    // This element is use to click on Login button
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Login')]")
    WebElement btnLogin;

    //This element is use to click on Forgot Password link
    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "Forgot Password")
    WebElement lnkForgotPassword;

    //This element is use to click on Forgot Password link
    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "Sign Up")
    WebElement lnkSignUp;

    // This element is use for success message
    @FindBy(how= How.XPATH, using="//div[@class='ant-message']/div")
    WebElement lblSuccessMessage;

    // Method to input UserName
    public void typeUserName(String strUserName) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(txtUserName));
        txtUserName.sendKeys(strUserName);
    }

    // Method to input Password
    public void typePassword(String strPassword) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(txtPassword));
        txtPassword.sendKeys(strPassword);
    }

    // Method to click on Login Button
    public void clickLogin() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(btnLogin));
        btnLogin.click();
        wait.until(ExpectedConditions.visibilityOf(lblSuccessMessage));
        String strMessage = lblSuccessMessage.getText();
        System.out.println(strMessage);
    }

    // Method to click on Forgot Password
    public void clickForgotPassword()
    {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(lnkForgotPassword));
        lnkForgotPassword.click();
    }

    // Method to click on Sign Up
    public void clickSignUp()
    {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(lnkSignUp));
        lnkSignUp.click();
    }

    //Method to get Title of Sign In page
    public  void verifyTitle(){
        String actualTitle=driver.getTitle();
        System.out.println(actualTitle);
        if(actualTitle.equals("Great Child Care")){
            System.out.println("Title verified successfully");
        }
        else{
            System.out.println("Title is incorrect");
        }

    }

}