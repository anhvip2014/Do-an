package com.example.pages.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.example.pages.BasePage;

public class LoginPage extends BasePage {
    public LoginPage() {
    }

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public WebElement txtEmail= keyword.findElement(By.xpath("//input[@placeholder='Email']"));
    public WebElement txtPassWord= keyword.findElement(By.xpath("//input[@placeholder='Password']"));
    public WebElement btnSubmit= keyword.findElement(By.xpath("//button[@class='btn btn-default btn-lg btn-block effect ladda-button waves-effect']"));


    /**
     * Send key to the text box
     * @param webElement
     * @param text
     * @throws Exception
    */
    public void sendKeyTotxtEmail(String UserName) throws Exception{
        keyword.setText(txtEmail, UserName);
    }

      /**
     * Send key to the text box
     * @param webElement
     * @param text
     * @throws Exception
    */
    public void sendKeyTotxtPassWord(String PassWord) throws Exception{
        keyword.setText(txtPassWord, PassWord);
    }


    public void clickOnBtnSubmit(){
        keyword.clickByJS(btnSubmit);
    }

   

}
