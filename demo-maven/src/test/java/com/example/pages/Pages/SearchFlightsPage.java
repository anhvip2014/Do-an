package com.example.pages.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.example.pages.BasePage;

public class SearchFlightsPage extends BasePage {
    public SearchFlightsPage() {
    }

    public SearchFlightsPage(WebDriver driver) {
        super(driver);
    }
   
    public boolean SearchSuccess(){
            WebElement TiTleMofidySearch = keyword.findElement(By.xpath("//div[@class='card-header']"));
          WebElement btnAllFlights = keyword.findElement(By.xpath("//input[@class='form-check-input filter' and @checked]"));
   
        if(isElementEnabled(TiTleMofidySearch)
        &&isElementEnabled(btnAllFlights))
        return true;
        return false;
    }

}
