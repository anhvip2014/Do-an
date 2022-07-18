package com.example.pages.Pages.hotles;

import java.security.PublicKey;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.example.core.keyword.WebKeyword.chooseTypeOfSelect;
import com.example.pages.BasePage;

public class BookingHoltels extends BasePage {
    public BookingHoltels() {
    }

    public BookingHoltels(WebDriver driver) {
        super(driver);
    }

    WebElement txtFirstName = keyword.findElement(By.xpath("//input[@name='firstname']"));
    WebElement txtLastName = keyword.findElement(By.xpath("//input[@name='lastname']"));
    WebElement txtEmail = keyword.findElement(By.xpath("//input[@name='email']"));
    WebElement txtPhone = keyword.findElement(By.xpath("//input[@name='phone']"));
    WebElement txtAddress = keyword.findElement(By.xpath("//input[@name= 'address']"));
    WebElement spnCountry = keyword.findElement(By.xpath("//span[@data-select2-id='2']//span[@class='select2-selection__rendered']"));
    WebElement spnNationality = keyword.findElement(By.xpath("//span[@data-select2-id='5']//span[@class='select2-selection__rendered']"));
    WebElement selcetTitleTraveller1 = keyword.findElement(By.xpath("//select[@name='title_1']"));
    WebElement selcetTitleTraveller2 = keyword.findElement(By.xpath("//select[@name='title_2']"));
    WebElement txtFirstNameTraveller1 = keyword.findElement(By.xpath("//input[@name='firstname_1']"));
    WebElement txtFirstNameTraveller2 = keyword.findElement(By.xpath("//input[@name='firstname_2']"));
    WebElement txtLastNameTraveller1 = keyword.findElement(By.xpath("//input[@name='lastname_1']"));
    WebElement txtLastNameTraveller2 = keyword.findElement(By.xpath("//input[@name='lastname_2']"));
    WebElement selcetChildAge1 = keyword.findElement(By.xpath("//select[@name='child_age_1']"));
    WebElement selcetChildAge2 = keyword.findElement(By.xpath("//select[@name='child_age_2']"));
    WebElement txtFirstNameChild1 = keyword.findElement(By.xpath("//input[@name='firstname_1']"));
    WebElement txtFirstNameChild2 = keyword.findElement(By.xpath("//input[@name='firstname_2']"));
    WebElement txtLastNameChild1 = keyword.findElement(By.xpath("//input[@name='child_lastname_1']"));
    WebElement txtLastNameChild2 = keyword.findElement(By.xpath("//input[@name='child_lastname_2']"));
    WebElement btnPaylater = keyword.findElement(By.xpath("//div[@class='col-md-12 mb-1 gateway_pay-later']//input"));
    WebElement chbAgree = keyword.findElement(By.xpath("//label[@for = 'agreechb']"));
    WebElement btnConfirmBooking = keyword.findElement(By.xpath("// button[@id= 'booking']"));


    /**
     * 
     * @param FirstName
     * @param LastName
     * @param Email
     * @param Phone
     * @param valueCountry
     * 
     * @param valueNationality
     * @throws Exception
    */
    public void sendKeyToPersonalInformation(String FirstName,String LastName,String Email, String Phone,String Address,String valueCountry,String valueNationality) throws Exception{


        keyword.setText(txtFirstName, FirstName);
        keyword.setText(txtLastName, LastName);
        keyword.setText(txtEmail, Email);
        keyword.setText(txtPhone, Phone);
        keyword.setText(txtAddress, Address);
       // sendkeyToTxtCountryFrom(valueCountry);
       // sendkeyToTxtNationalityFrom(valueNationality);
         
    }

    public void sendkeyToTxtCountryFrom(String value) throws Exception{
        
             keyword.clickWithOutScroll(spnCountry);
        WebElement txtSearch= keyword.findElement(By.xpath("//input[@class= 'select2-search__field']"));
        keyword.setText(txtSearch, value);
        clickOnFirstResearchResult();
    }


    public void sendkeyToTxtNationalityFrom(String value) throws Exception{
        
        keyword.clickWithOutScroll(spnNationality);
        WebElement txtSearch= keyword.findElement(By.xpath("//input[@class= 'select2-search__field']"));
        keyword.setText(txtSearch, value);
        clickOnFirstResearchResult();
}

public void clickOnFirstResearchResult(){
   WebElement liFirstResearchResult = keyword.findElement(By.xpath("// li[@class= 'select2-results__option select2-results__option--highlighted']"));
   keyword.clickWithOutScroll(liFirstResearchResult);
}
    /**
     * @param FirstName
     * @param LastName
     * @param TitleValue
     * @throws Exception
     */
    public void sendKeyToFirstTraveller(String FirstName,String LastName,String TitleValue) throws Exception{

       // keyword.setValueForSelectElement(selcetTitleTraveller1, chooseTypeOfSelect.selectByValue, TitleValue);
        keyword.setText(txtFirstNameTraveller1, FirstName);
        keyword.setText(txtLastNameTraveller1, LastName);

    }

    /**
     * 
     * @param FirstName
     * @param LastName
     * @param TitleValue
     * @throws Exception
    */
    public void sendKeyToSecondTraveller(String FirstName,String LastName,String TitleValue) throws Exception{  

       // keyword.setValueForSelectElement(selcetTitleTraveller2, chooseTypeOfSelect.selectByValue, TitleValue);
        keyword.setText(txtFirstNameTraveller2, FirstName);
        keyword.setText(txtLastNameTraveller2, LastName);
    }


    /**
     * 
     * @param FirstName
     * @param LastName
     * @param valueAge
     * @throws Exception
    */
    public void sendkeyToFirstChild(String FirstName,String LastName,String valueAge) throws Exception{
        keyword.setValueForSelectElement(selcetChildAge1, chooseTypeOfSelect.selectByValue, valueAge);
        keyword.setText(txtFirstNameChild1, FirstName);
        keyword.setText(txtLastNameChild1, LastName);
    }

     /**
     * 
     * @param FirstName
     * @param LastName
     * @param valueAge
     * @throws Exception
    */
    public void sendkeyToSecondChild(String FirstName,String LastName,String valueAge) throws Exception{
        keyword.setValueForSelectElement(selcetChildAge2, chooseTypeOfSelect.selectByValue, valueAge);
        keyword.setText(txtFirstNameChild2, FirstName);
        keyword.setText(txtLastNameChild2, LastName);
    }


    public void clickOnPayLaterBtn (){
        keyword.clickByJS(btnPaylater);
    }

    public void clickOnAgreeChb(){
        keyword.clickByJS(chbAgree);
    }

    public void clickOnConfirmBookingBtn(){
        keyword.clickByJS(btnConfirmBooking);
    }
}
