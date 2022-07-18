package com.example.tests.LoginPage;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.example.core.datadriven.DataForLogin;
import com.example.core.datadriven.DataForSearch;
import com.example.core.utils.listener.ReportListener;

import com.example.pages.Pages.DashBoardPage;
import com.example.pages.Pages.HomePage;
import com.example.pages.Pages.LoginPage;
import com.example.pages.Pages.SearchFlightsPage;
import com.example.pages.Pages.SearchToursPage;
import com.example.pages.Pages.hotles.BookingHoltels;
import com.example.pages.Pages.hotles.BookingInvoice;
import com.example.pages.Pages.hotles.DetailsHotelPage;
import com.example.pages.Pages.hotles.SearchHotelsPage;
import com.example.tests.BaseTest;

@Listeners(ReportListener.class)
public class LoginPageTest extends BaseTest {
   
    @Test(testName = "Verify login success ",dataProvider = "DataLogin",dataProviderClass = DataForLogin.class)
    public void verifyLoginSuccess(String Email,String PassWord ) throws Exception   
    {
        HomePage homePage= new HomePage(driver);
        homePage.clickOnBtnLoginPageTo();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.sendKeyTotxtEmail(Email);;
        loginPage.sendKeyTotxtPassWord(PassWord);
        loginPage.clickOnBtnSubmit();
        DashBoardPage dashBoardPage = new DashBoardPage(driver);
        
        Assert.assertTrue(dashBoardPage.isLoginSuccess(),"");

    }

     @Test(testName = "Verify booking hotels E2E ",dataProvider = "DataForSearchHotel",dataProviderClass = DataForSearch.class)
     public void verifyBookingHotelsE2E(String cityname,String checkindate,String checkoutdate,
                                            String room,String Adults,String childs,String Age1,
                                            String Age2,String FirstName,String LastName,String Email,
                                            String Phone,String Address,String valueCountry,String valueNationality,
                                            String FirstNameTraveller1,String LastNameTraveller1,
                                            String TitleValueTraveller1,String FirstNameTraveller2,
                                            String LastNameTraveller2,String TitleValueTraveller2,
                                            String FirstNameChild1,String LastNameChild1,String valueAge1,
                                            String FirstNameChild2,String LastNameChild2,String valueAge2) throws Exception   
     {
         HomePage homePage= new HomePage(driver);
         homePage.sendkeyToTxtSearch(cityname);
         homePage.selectToDatePickerCheckIn(checkindate);
         homePage.selectToDatePickerCheckOut(checkoutdate);
         homePage.clickOnBtnRoomAndTravellers();
         homePage.sendkeyTotxtRoom(room);
         homePage.sendkeyTotxtAdults(Adults); 
         homePage.clickOnBtnChildsIncToPlusRoom();
         homePage.clickOnBtnChildsIncToPlusRoom();
         homePage.selectChildsAge(Age1, Age2);
         homePage.clickOnBtnSearch();
         SearchHotelsPage searchHotelsPage = new SearchHotelsPage(driver);
         searchHotelsPage.clickOnImgToNavigateDetailsHotelsPage();
         DetailsHotelPage detailsHotelPage = new DetailsHotelPage(driver);
         detailsHotelPage.clickOnBookHotels();
         BookingHoltels bookingHoltels = new BookingHoltels(driver);
         bookingHoltels.sendKeyToPersonalInformation(FirstName, LastName, Email, Phone,Address,valueCountry, valueNationality);
         bookingHoltels.sendKeyToFirstTraveller(FirstNameTraveller1, LastNameTraveller1, TitleValueTraveller1);
         bookingHoltels.sendKeyToSecondTraveller(FirstNameTraveller2, LastNameTraveller2, TitleValueTraveller2);
         bookingHoltels.sendkeyToFirstChild(FirstNameChild1, LastNameChild1, valueAge1);
         bookingHoltels.sendkeyToSecondChild(FirstNameChild2, LastNameChild2, valueAge2);
         bookingHoltels.clickOnPayLaterBtn();
         bookingHoltels.clickOnAgreeChb();
         bookingHoltels.clickOnConfirmBookingBtn();
         BookingInvoice bookingInvoice = new BookingInvoice(driver);
         Assert.assertTrue(bookingInvoice.isBookingInvoiceSuccess(Address, Phone, Email));

     }

     @Test(testName = "Verify Search Flights Success ",dataProvider = "DataForSearcFlights",dataProviderClass = DataForSearch.class)
     public void verifySearchFlightsSuccess(String flyingfrom,String todestination,String departuredate,String Adults,String childs,String Infants) throws Exception   
     {
         HomePage homePage= new HomePage(driver);
         homePage.clickOnBtnFlights();
         homePage.sendkeyToTxtFlightsFrom(flyingfrom);
         homePage.sendkeyToTxtToDestinationFlight(todestination);
         homePage.selectToDatePickerDepartureDate(departuredate);
         homePage.clickOnPassengers();
         homePage.sendkeyToTxtAdultsFlights(Adults);
         homePage.sendkeyToTxtChildsFlights(childs);
         homePage.sendkeyToTxtInfants(Infants);
         homePage.clickOnBtnSearchFlights();
         driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        SearchFlightsPage searchFlightsPage = new SearchFlightsPage(driver);
        Assert.assertTrue(searchFlightsPage.SearchSuccess());
     }

     @Test(testName = "Verify Search Tours Success ",dataProvider = "DataForSearcTours",dataProviderClass = DataForSearch.class)
     public void verifySearchToursSuccess(String Destination,String tourday,String Adults,String childs) throws Exception   
     {
         HomePage homePage= new HomePage(driver);
         homePage.clickOnBtnTours();
         homePage.sendKeyToTxtDestinationForTour(Destination);
         homePage.selectToDatePickerTuorDate(tourday);
         homePage.clickOnBtnTravellersOnTours();
         homePage.sendkeyToTxtAdultsTours(Adults);
         homePage.sendkeyToTxtChildTours(childs);
         homePage.clickOnBtnSearchToursForSearch();
         SearchToursPage searchToursPage = new SearchToursPage(driver);
         Assert.assertTrue(searchToursPage.SearchSuccess(Destination, Adults, childs));

     }

    }
