package com.example.pages.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.example.pages.BasePage;

public class DashBoardPage extends BasePage{
    public DashBoardPage() {
    }

    public DashBoardPage(WebDriver driver) {
        super(driver);
    }

    public WebElement WelComeMessage= keyword.findElement(By.xpath("//span[@style='text-transform:capitalize']"));
    public WebElement btnHome = keyword.findElement(By.xpath("//div[@class='main-menu-content']//a[@href='https://www.phptravels.net/']"));
   

    public boolean isLoginSuccess(){

        if(isElementDisplayed(WelComeMessage)
            )
            return true;
        return false;
    }


}
