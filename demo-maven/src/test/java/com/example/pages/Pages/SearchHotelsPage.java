package com.example.pages.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.example.pages.BasePage;

public class SearchHotelsPage extends BasePage {
    public SearchHotelsPage() {
    }

    public SearchHotelsPage(WebDriver driver) {
        super(driver);
    }
    public WebElement TitleSearch = keyword.findElement(By.xpath("//h2[@class='sec__title_list']"));
    public WebElement txtAdultsNumber = keyword.findElement(By.xpath("//div[@class='left-side-info rtl-align-right']//p[2]//strong[1]"));
    public WebElement txtChildsNumber = keyword.findElement(By.xpath("//div[@class='left-side-info rtl-align-right']//p[2]//strong[2]"));
    public WebElement txtRoomNumber   = keyword.findElement(By.xpath("//div[@class='left-side-info rtl-align-right']//p[2]//strong[3]"));

    public boolean SearchSuccess(String cityname,String Adults,String childs,String room){
        String titleSearch = "Search Hotels In "+cityname;
        if(isElementEnabled(TitleSearch)&&isElementTextEqualExpectedText(TitleSearch, titleSearch)
        &&isElementEnabled(txtAdultsNumber)&&isElementTextEqualExpectedText(txtAdultsNumber, Adults)
        &&isElementEnabled(txtChildsNumber)&&isElementTextEqualExpectedText(txtChildsNumber, childs)
        &&isElementEnabled(txtRoomNumber)&&isElementTextEqualExpectedText(txtRoomNumber, room))
        return true;
        return false;
    }

    
}
