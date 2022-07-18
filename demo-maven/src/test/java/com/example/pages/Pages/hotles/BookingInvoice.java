package com.example.pages.Pages.hotles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.example.pages.BasePage;

public class BookingInvoice extends BasePage {

        public BookingInvoice() {
    }

    public BookingInvoice(WebDriver driver) {
        super(driver);
    }

    public WebElement txtFirstNameInvoice= keyword.findElement(By.xpath("//span[text()='First Name:']//parent::li"));
    public WebElement txtLastNameInvoice= keyword.findElement(By.xpath("//span[text()='Last Name:']//parent::li"));


    public boolean isEmailCorrect(String Email){
      
         WebElement txtEmailInvoice= keyword.findElement(By.xpath("//li[text()='"+Email+"']"));

        if(isElementEnabled(txtEmailInvoice))
        return true;
        return false;
    }

    public boolean isPhoneCorrect(String Phone){
      
        WebElement txtPhoneInvoice= keyword.findElement(By.xpath("//li[text()=' "+Phone+"']"));

       if(isElementEnabled(txtPhoneInvoice))
       return true;
       return false;
   }

   public boolean isAddressCorrect(String Address){
      
    WebElement txtAddressInvoice= keyword.findElement(By.xpath("//li[text()=' "+Address+"']"));

    if(isElementEnabled(txtAddressInvoice))
    return true;
    return false;
    }   

    public boolean isBookingInvoiceSuccess(String Address,String Phone,String Email){
        if(isElementEnabled(txtFirstNameInvoice)&&isElementEnabled(txtLastNameInvoice)
           &&isAddressCorrect(Address)&&isPhoneCorrect(Phone)&&isEmailCorrect(Email)) return true;
        return false;
    }

}
