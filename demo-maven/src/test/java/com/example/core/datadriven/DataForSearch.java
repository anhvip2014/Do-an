package com.example.core.datadriven;

import org.testng.annotations.DataProvider;

import com.example.core.helper.JsonHelper;

public class DataForSearch {
    @DataProvider(name = "DataForSearchHotel")
    public static Object[][] DataForsearchHotel() {
        return JsonHelper.ReadJsonFromFile("src/test/java/com/example/core/resources/DataForSearch.json");
    }
    @DataProvider(name = "DataForSearcFlights")
    public static Object[][] DataForSearcFlights() {
        return JsonHelper.ReadJsonFromFile("src/test/java/com/example/core/resources/DataForSearchFlights.json");
    }
    @DataProvider(name = "DataForSearcTours")
    public static Object[][] DataForSearcTours() {
        return JsonHelper.ReadJsonFromFile("src/test/java/com/example/core/resources/DataForSearchTours.json");
    }
}
