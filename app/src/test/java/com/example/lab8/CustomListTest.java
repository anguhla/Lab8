package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import junit.framework.Assert;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    private City testCity;

    public CustomList MockCityList(){
        list = new CustomList(null, new ArrayList<City>());
        return list;
    }

    public City getTestCity() {
        testCity = new City("Edmonton", "AB");
        return testCity;
    }

    @Test
    public void addCityTest() {
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Edmonton", "AB" ));
        assertEquals(list.getCount(), listSize+1);
    }

    @Test
    public void hasCityTest() {
        list = MockCityList();
        testCity = getTestCity();
        list.addCity(testCity);
        assertEquals(true, list.hasCity(testCity));

        City compareCity2 = new City("Toronto", "Ontario");
        assertEquals(false, list.hasCity(compareCity2));

    }

    @Test
    public void testDelete()  {
        list = MockCityList();
        testCity = getTestCity();
        list.addCity(testCity);
        list.delete(testCity);
        assertEquals(0, list.getCount());
    }
    @Test
    public void testCountCities() {
        list = MockCityList();
        list.addCity(getTestCity());
        assertEquals(list.getCount(), list.countCities());
    }


}
