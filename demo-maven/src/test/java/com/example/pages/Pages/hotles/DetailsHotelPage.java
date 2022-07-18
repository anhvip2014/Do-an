package com.example.pages.Pages.hotles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.example.pages.BasePage;

public class DetailsHotelPage extends BasePage {

    public DetailsHotelPage() {
    }

    public DetailsHotelPage(WebDriver driver) {
        super(driver);
    }

    public  void clickOnBookHotels(){ 
            WebElement btnBookNow = keyword.findElement(By.xpath("//div[@class='col-md-3 booked_27']//button"));
            keyword.clickByJS(btnBookNow);
    }
}
