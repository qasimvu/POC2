package com.ccaoa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

// Created by Qasim Alam
public class BuildYourProfile {

    WebDriver driver;
    public BuildYourProfile(WebDriver driver){
        this.driver=driver;
    }

    // This element is use to enter First Name
    @FindBy(how= How.ID, using="firstName")
    WebElement txtFirstName;

    // This element is use to enter Last Name
    @FindBy(how= How.ID, using="lastName")
    WebElement txtLastName;

    // This element is use to enter Personal Phone Number
    @FindBy(how= How.ID, using="phone")
    WebElement txtPersonalPhoneNumber;

    // This element is use to enter Personal Email Address
    @FindBy(how= How.ID, using="email")
    WebElement txtPersonalEmailAddress;

    // This element is use to click on Next button
    @FindBy(how= How.XPATH, using="//span[contains(text(),'Next')]")
    WebElement btnNext;

    // This element is use to click on Clear Form button
    @FindBy(how= How.XPATH, using="//span[contains(text(),'Clear Form')]")
    WebElement btnClearForm;

    // This element is use to click on Cancel button
    @FindBy(how= How.XPATH, using="//span[contains(text(),'Cancel')]")
    WebElement btnCancel;


    //This method is used to verify User Name
    public void verifyFirstName(String inputUserName){
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(txtFirstName));
     String strFirstName= txtFirstName.getAttribute("value");
     Assert.assertEquals(strFirstName,inputUserName);
     System.out.println(strFirstName +" successfully displaying against First Name");
    }

    // This method is used to verify Placeholder of First Name
    public void verifyPlaceHolderFirstName(){
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(txtFirstName));
        String placeholderFN = txtFirstName.getAttribute("placeholder");
        System.out.println(placeholderFN);
    }

    // This method is used to verify Placeholder of Last Name
    public void verifyPlaceHolderLastName(){
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(txtLastName));
        String placeholderLN = txtLastName.getAttribute("placeholder");
        System.out.println(placeholderLN);
    }

    // This method is used to verify Placeholder of Personal Phone Number
    public void verifyPlaceHolderPhoneNumber(){
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(txtPersonalPhoneNumber));
        String placeholderPhoneNUmber = txtPersonalPhoneNumber.getAttribute("placeholder");
        System.out.println(placeholderPhoneNUmber);
    }

    // This method is used to input Last Name
    public void verifyLastName(String inputLastName){
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(txtLastName));
        String strLastName= txtLastName.getAttribute("value");
        Assert.assertEquals(strLastName,inputLastName);
        System.out.println(strLastName +" successfully displaying against Last Name");
    }

    // This method is used to Verify Email
    public void verifyEmail(String inputEmail){
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(txtPersonalEmailAddress));
        String strEmail= txtPersonalEmailAddress.getAttribute("value");
        Assert.assertEquals(strEmail,inputEmail);
        System.out.println(strEmail + "successfully displaying against Email");
    }

    // This method is used click on Clear Button
    public void clickClear(){
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(btnClearForm));
        btnClearForm.click();
    }
}
