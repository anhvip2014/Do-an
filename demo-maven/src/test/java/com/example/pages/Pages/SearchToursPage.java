package com.example.pages.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.example.pages.BasePage;

public class SearchToursPage extends BasePage {
    
    public SearchToursPage() {
    }

    public SearchToursPage(WebDriver driver) {
        super(driver);
    }
    public WebElement TitleSearch = keyword.findElement(By.xpath("//h2[@class='sec__title_list']"));
    public WebElement txtAdultsNumber = keyword.findElement(By.xpath("//div[@class='left-side-info rtl-align-right']//p[2]//strong[1]"));
    public WebElement txtChildsNumber = keyword.findElement(By.xpath("//div[@class='left-side-info rtl-align-right']//p[2]//strong[2]"));
    

    public boolean SearchSuccess(String cityname,String Adults,String childs){
        String titleSearch = "Search Tours In "+cityname;
        if(isElementEnabled(TitleSearch)&&isElementTextEqualExpectedText(TitleSearch, titleSearch)
        &&isElementEnabled(txtAdultsNumber)&&isElementTextEqualExpectedText(txtAdultsNumber, Adults)
        &&isElementEnabled(txtChildsNumber)&&isElementTextEqualExpectedText(txtChildsNumber, childs)
        )
        return true;
        return false;
    }
}
