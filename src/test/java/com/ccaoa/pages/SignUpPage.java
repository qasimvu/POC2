package com.ccaoa.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;

public class SignUpPage {

    WebDriver driver;
    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    // This element is use to enter text in First Name field
    @FindBy(how = How.ID, using = "firstName")
    WebElement txtFirstName;

    // This element is use to enter text in Last Name field
    @FindBy(how = How.ID, using = "lastName")
    WebElement txtLastName;

    // This element is use to enter text in Password field
    @FindBy(how = How.ID, using = "password")
    WebElement txtPassword;

    // This element is use to enter text in ConfirmPassword field
    @FindBy(how = How.ID, using = "confirmPassword")
    WebElement txtConfirmPassword;

    // This element is use to enter text in Email field
    @FindBy(how = How.ID, using = "email")
    WebElement txtEmail;

    // This element is use to enter text Phone Number field
    @FindBy(how = How.ID, using = "phoneNumber")
    WebElement txtPhoneNumber;

    // This element is use to check Agree Terms and Condition field
    @FindBy(how = How.XPATH, using = "//span[@class='ant-checkbox']/span")
    WebElement cbAgreeTerms;

    // This element is use to click on Login button
    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "Terms and Agreement")
    WebElement btnSignUp;



    // Method to input FirstName
    public void typeFirstName(String strFirstName) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(txtFirstName));
        txtFirstName.sendKeys(strFirstName);
    }

    // Method to input Last Name
    public void typeLastName(String strLastName) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(txtLastName));
        txtLastName.sendKeys(strLastName);
    }

    // Method to input Password
    public void typePassword(String strPassword) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(txtPassword));
        txtPassword.sendKeys(strPassword);
    }

    // Method to input Confirm Password
    public void typeConfirmPassword(String strConfirmPassword) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(txtConfirmPassword));
        txtConfirmPassword.sendKeys(strConfirmPassword);
    }

    // Method to input Email
    public void typeEmail(String strEmail) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(txtEmail));
        txtEmail.sendKeys(strEmail);
    }

    // Method to input Phone Number
    public void typePhoneNumber() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(txtPhoneNumber));
        txtPhoneNumber.sendKeys(Keys.HOME);
        txtPhoneNumber.sendKeys("1234567891");
    }

    // Method to select Terms and condition checkbox
    public void selectTermsAndCondition() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(cbAgreeTerms));
       ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,400)");
        for (int i=0; i<2; i++) {
            cbAgreeTerms.click();
            System.out.println("Terms & Conditions Checkbox Status is -  "+cbAgreeTerms.isSelected());
        }

    }

    // Method to click on Sign Up
    public void clickSignUp() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement body = driver.findElement(By.tagName("body"));

        Action scrollDown = new Actions(driver)
                .moveToElement(body, body.getSize().width - 10, 15) // position mouse over scrollbar
                .clickAndHold()
                .moveByOffset(0, 250) // scroll down
                .release()
                .build();

        scrollDown.perform();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(btnSignUp));
        //btnSignUp.click();
    }

    //Method to get Title of Sign Up page
    public  void verifyTitle(){
        String actualTitle=driver.getTitle();
        System.out.println(actualTitle);
        if(actualTitle.equals("Great Child Care")){
            System.out.println("Test Pass");
        }
        else{
            System.out.println("Test Failed");
        }
    }
}