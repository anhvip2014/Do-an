package com.example.tests.LoginPage;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.example.core.datadriven.DataForLogin;
import com.example.core.datadriven.DataForSearch;
import com.example.core.utils.listener.ReportListener;
import com.example.pages.home;
import com.example.pages.Pages.DashBoardPage;
import com.example.pages.Pages.HomePage;
import com.example.pages.Pages.LoginPage;
import com.example.pages.Pages.SearchFlightsPage;
import com.example.pages.Pages.SearchHotelsPage;
import com.example.pages.Pages.SearchToursPage;
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

     @Test(testName = "Verify Search hotels Success ",dataProvider = "DataForSearchHotel",dataProviderClass = DataForSearch.class)
     public void verifySearchHotelsSuccess(String cityname,String checkindate,String checkoutdate,String room,String Adults,String childs) throws Exception   
     {
         HomePage homePage= new HomePage(driver);
         homePage.sendkeyToTxtSearch(cityname);
         homePage.selectToDatePickerCheckIn(checkindate);
         homePage.selectToDatePickerCheckOut(checkoutdate);
         homePage.clickOnBtnRoomAndTravellers();
         homePage.sendkeyTotxtRoom(room);
         homePage.sendkeyTotxtAdults(Adults); 
         homePage.sendkeyTotxtchidls(childs);
         homePage.clickOnBtnSearch();
         SearchHotelsPage searchHotelsPage = new SearchHotelsPage(driver);
         Assert.assertTrue(searchHotelsPage.SearchSuccess(cityname, Adults, childs, room));

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
