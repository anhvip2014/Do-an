package com.example.pages.Pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;

import com.example.pages.BasePage;
import com.github.dockerjava.api.model.Driver;

import javafx.scene.control.SplitPane.Divider;

import org.openqa.selenium.Keys;
import java.util.concurrent.TimeUnit;

import org.bouncycastle.asn1.eac.PublicKeyDataObject;
import org.openqa.selenium.By;


public class HomePage extends BasePage {
    public HomePage() {
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public WebElement btnLogin= keyword.findElement(By.xpath("//a[@class='theme-btn theme-btn-small theme-btn-transparent ml-1 waves-effect']")); 
    
    //search hotels elements
    public WebElement spnSearchCity=keyword.findElement(By.xpath("//span[@id= 'select2-hotels_city-container']"));
    public WebElement datePickerCheckIn= keyword.findElement(By.xpath("//input[@class='checkin form-control form-control-lg border-top-r0']"));
    public WebElement datePickerCheckOut = keyword.findElement(By.xpath("//input[@name='checkout']"));
    public WebElement btnRoomAndTravellers= keyword.findElement(By.xpath("//a[@class='dropdown-toggle dropdown-btn travellers waves-effect']"));
    public WebElement btnSearch=keyword.findElement(By.xpath("//button[@class='more_details effect btn btn-primary btn-block btn-lg ladda-button waves-effect']"));

    //search Flights elements
    public WebElement btnFlights = keyword.findElement(By.xpath("//li[@data-position='2']//button[@class='nav-link waves-effect']"));

    //search Tours  elements
    public WebElement btnTours = keyword.findElement(By.xpath("//li[@data-position='3']//button[@class='nav-link waves-effect']"));

    public void clickOnFlightsSearch(){
        keyword.clickByJS(btnFlights);
    }

    public boolean loadingflightsIsEnabled(){
        WebElement loadingFlights= keyword.findElement(By.xpath("//div[@id='loading_flight']"));
        if(isElementEnabled(loadingFlights))return true;
        return false;
    }

    public void clickRoundTrip(){
        WebElement btnRoundTrip= keyword.findElement(By.xpath("//input[@id='round-trip']"));
        keyword.clickByJS(btnRoundTrip);
    }

    public void clickOnBtnSearchFlights(){
        WebElement btnSearchFlights = keyword.findElement(By.xpath("//button[@id='flights-search']"));
        keyword.clickWithOutScroll(btnSearchFlights);
    }

    

    public void clickOnBtnSearchToursForSearch(){
        WebElement btnSearchTours = keyword.findElement(By.xpath("//button[@id='flights-search']"));
        keyword.clickWithOutScroll(btnSearchTours);
    }

    /*
     * send city name on txt flights From  and chose first result
     * @param value
     * @throws Exception
    */
    public void sendkeyToTxtFlightsFrom(String value) throws Exception{
        
        WebElement spanSearch = keyword.findElement(By.xpath("//div[@class='autocomplete-wrapper _1 row_2']//input[@placeholder='To Destination']"));
        keyword.clickWithOutScroll(spanSearch);
        WebElement txtSearch= keyword.findElement(By.xpath("//div[@class='autocomplete-wrapper _1 row_1']//input[@class='form-control autocomplete-airport yes']"));
        keyword.setText(txtSearch, value);
        clickOnFirstSearchFlyingFromResult();
    }

    /*
     * send city name on txt To Destination  and chose first result
     * @param value
     * @throws Exception
    */
    public void sendkeyToTxtToDestinationFlight(String value) throws Exception{
        
        WebElement spanSearch = keyword.findElement(By.xpath("//input[@class='form-control autocomplete-airport focus px-5']"));
        keyword.clickWithOutScroll(spanSearch);
        WebElement txtSearch= keyword.findElement(By.xpath("//input[@class='form-control autocomplete-airport focus px-5 yes']"));
        keyword.setText(txtSearch, value);
        clickOnFirstSearchToDestinationResult();
    }

    /**
     * send city name on txt  Destination  and chose first result 
     * @param value
     * @throws Exception
    */
    public void sendKeyToTxtDestinationForTour(String value) throws Exception{
        WebElement spanSearch = keyword.findElement(By.xpath("//span[@id='select2-tours_city-container']"));
        keyword.clickWithOutScroll(spanSearch);
        WebElement txtSearch= keyword.findElement(By.xpath("//input[@class='select2-search__field']"));
        keyword.setText(txtSearch, value);
        clickOnFirstDestinationResult();
 
    }

    public void clickOnBtnLoginPageTo(){
        keyword.click(btnLogin);
    }

    /*
     * send city name on txt search
     * @param value
     * @throws Exception
    */
    public void sendkeyToTxtSearch(String value) throws Exception{
        keyword.clickWithOutScroll(spnSearchCity);
        WebElement txtSearch = keyword.findElement(By.xpath("//input[@class='select2-search__field']"));
        keyword.setText(txtSearch, value);
        clickOnFirstSearchHotelsResult();
    }

    public void clickOnBtnRoomAndTravellers(){
        keyword.clickWithOutScroll(btnRoomAndTravellers);
    }

    public void clickOnBtnTravellersOnTours(){
        keyword.clickWithOutScroll(btnRoomAndTravellers);
    }


    public void clickOnBtnRoomIncToPlusRoom(){

         WebElement btnRoomInc= keyword.findElement(By.xpath("//div[@class='roomInc']"));
         keyword.click(btnRoomInc);
     }

    public void clickOnBtnRoomDecToMinusRoom(){
         WebElement btnRoomDec= keyword.findElement(By.xpath("//div[@class='roomDec']"));

        keyword.click(btnRoomDec);
    }

    public void clickOnBtnAdultsIncToPlusRoom(){
         WebElement btnAdultsQTYInc= keyword.findElement(By.xpath("//*[@id='adults']//preceding::div[@class='qtyDec'][1]"));
        keyword.click(btnAdultsQTYInc);
    }

    public void clickOnBtnAudltsDecToMinusRoom(){
        WebElement btnAdultsQTYDec= keyword.findElement(By.xpath("//*[@id='adults']//following-sibling::div"));
        keyword.click(btnAdultsQTYDec);
    }

    public void clickOnBtnChildsIncToPlusRoom(){
         WebElement btnChildsQTYInc= keyword.findElement(By.xpath("//*[@id='childs']//preceding::div[@class='qtyDec'][1]"));
        keyword.click(btnChildsQTYInc);
    }

    public void clickOnBtnChildsDecToMinusRoom(){
         WebElement btnChildsQTYDec= keyword.findElement(By.xpath("//*[@id='childs']//following-sibling::div"));
        keyword.click(btnChildsQTYDec);
    }

    public void clickOnBtnSearch(){
               keyword.click(btnSearch);
   }

   public void clickOnPassengers(){
    WebElement btnPassengers= keyword.findElement(By.xpath("//a[@class='dropdown-toggle dropdown-btn waves-effect']"));
    keyword.clickWithOutScroll(btnPassengers);
   }

    public void sendkeyToTxtAdultsFlights(String value) throws Exception{
    WebElement txtAdults= keyword.findElementByLocator(By.xpath("//*[@class='col-lg-1 pr-0']//descendant::input[@name='adults'][1]"));
    keyword.setText(txtAdults, value);
    }

    public void sendkeyToTxtChildsFlights(String value) throws Exception{
        WebElement txtChilds= keyword.findElementByLocator(By.xpath("//*[@class='col-lg-1 pr-0']//descendant::input[@id='fchilds']"));
        keyword.setText(txtChilds, value);
    }

    public void sendkeyToTxtInfants(String value) throws Exception{
        WebElement txtInfants= keyword.findElementByLocator(By.xpath("//*[@class='col-lg-1 pr-0']//descendant::input[@id='finfant']"));
        keyword.setText(txtInfants, value);
    }
    
    
    public void clickOnBtnFlights(){
        keyword.clickWithOutScroll(btnFlights);
    }

    public void clickOnBtnTours(){
        keyword.clickWithOutScroll(btnTours);
    }


    /**
     * send key to the text Room
     * @param value
     * @throws Exception
    */
    public void sendkeyTotxtRoom(String value) throws Exception{
         WebElement txtRoom= keyword.findElement(By.xpath("//input[@id='rooms']"));
        keyword.setText(txtRoom, value);
    }

    /**
     * send key To Text Audlts
     * @param value
     * @throws Exception
    */
    public void sendkeyTotxtAdults(String value) throws Exception{
        WebElement txtAdults= keyword.findElement(By.xpath("//input[@id='adults']"));
        keyword.setText(txtAdults, value);
    }

    /**
     * send key to text chidls
     * @param value
     * @throws Exception
    */
    public void sendkeyTotxtchidls(String value) throws Exception{
         WebElement txtChilds= keyword.findElement(By.xpath("//input[@id='childs']"));
        keyword.setText(txtChilds, value);
    }

    /**
     * send key to the date picker checkin day
     * @param value
    */
    public void selectToDatePickerCheckIn(String value){
        keyword.selectDatePcikerByJS(datePickerCheckIn, value);
    }

    /**
     * set adults for tours
     * @param value
    */
    public void sendkeyToTxtAdultsTours(String value) throws Exception{
        WebElement txtAdultsTours= keyword.findElementByLocator(By.xpath("//input[@id='tours_adults']"));
        keyword.setText(txtAdultsTours, value);
        }

    /**
     * set childs for tours
     * @param value
    */
    public void sendkeyToTxtChildTours(String value) throws Exception{
        WebElement txtChildsTours= keyword.findElementByLocator(By.xpath("//input[@id='tours_child']"));
        keyword.setText(txtChildsTours, value);
        }

    /**
     * 
     * @param value
    */
    public void selectToDatePickerCheckOut(String value){
        keyword.selectDatePcikerByJS(datePickerCheckOut, value);
    }

     /**
     * 
     * @param value
    */
    public void selectToDatePickerDepartureDate(String value){
        WebElement datePickerDepartureDate= keyword.findElement(By.xpath("//input[@class='depart form-control']"));
        keyword.selectDatePcikerByJS(datePickerDepartureDate, value);
    }
    
    /**
     * 
     * @param value
    */
    public void selectToDatePickerTuorDate(String value){
        WebElement datePickerDepartureDate= keyword.findElement(By.xpath("//div[@class='col-md-3']//input[@id='date']"));
        keyword.selectDatePcikerByJS(datePickerDepartureDate, value);
    }

    
    public void clickOnFirstSearchHotelsResult(){
        WebElement liFirstResearchHotelsResult = keyword.findElement(By.xpath("//span//li[@class='select2-results__option select2-results__option--highlighted']"));
        keyword.clickWithOutScroll(liFirstResearchHotelsResult);
    }
   
    public void clickOnFirstSearchFlyingFromResult(){
        WebElement liFirstResearchFlyingFromResult = keyword.findElement(By.xpath("//div[@class='autocomplete-result'][1]"));
        keyword.clickWithOutScroll(liFirstResearchFlyingFromResult);
    }

    public void clickOnFirstSearchToDestinationResult(){
        WebElement liFirstResearchToDestinationResult = keyword.findElement(By.xpath("//div[@class='autocomplete-result'][1]"));
        keyword.clickWithOutScroll(liFirstResearchToDestinationResult);
    }

   
    public void clickOnFirstDestinationResult(){
        WebElement liFirstDestinationResult = keyword.findElement(By.xpath("//li[@class='select2-results__option select2-results__option--highlighted']"));
        keyword.clickWithOutScroll(liFirstDestinationResult);
    }



}
