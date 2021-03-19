package com.ccaoa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApplicationDashboard {

    WebDriver driver;
    public ApplicationDashboard(WebDriver driver){
        this.driver=driver;
    }

    // This element is use to click on resume application button
    @FindBy(how= How.XPATH, using="//span[contains(text(),'Resume Application')]")
    WebElement btnResumeApplication;

    // Method to click on Resume Application
    public void clickResumeApplication(){
    WebDriverWait wait = new WebDriverWait(driver,30);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Resume Application')]")));
    if(driver.findElements(By.xpath("//span[contains(text(),'Resume Application')]")).size() != 0){
        driver.findElement(By.xpath("//span[contains(text(),'Resume Application')]")).click();
        System.out.println("Resume Application Element clicked");
    }
    else{
        System.out.println("Resume Application Element is not represent");
    }
}

}
