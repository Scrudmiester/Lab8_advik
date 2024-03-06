package com.example.lab8;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }
    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one
     */
    @Test
    public void addCityTest() {
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(), listSize + 1);
    }

    @Test
    public void testHasCity() {
        CustomList list = MockCityList(); // Use the consistent method for initializing the list
        // Assuming there's a method addCity and hasCity in CustomList

        // Test with a city that is not in the list
        City cityNotInList = new City("Calgary", "Alberta");
        assertFalse("City should not be in the list initially", list.hasCity(cityNotInList));

        // Adding city to the list and testing again
        list.addCity(cityNotInList);
        assertTrue("City should be in the list after being added", list.hasCity(cityNotInList));
    }

    @Test
    public void testDeleteCityExists() {
        CustomList list = MockCityList(); // Assuming MockCityList creates and returns a CustomList object
        City city = new City("Calgary", "Alberta");
        list.addCity(city);
        assertTrue("City should be in the list before deletion", list.hasCity(city));
        list.delete(city);
        assertFalse("City should not be in the list after deletion", list.hasCity(city));
    }

    @Test
    public void testCountCitiesEmpty() {
        list = MockCityList(); // Use the same MockCityList method to initialize
        assertEquals(0, list.getCount(), "Count should be 0 for an empty list");

        // Add a city and test the count
        City city = new City("Calgary", "Alberta");
        list.addCity(city);
        assertEquals(1, list.getCount(), "Count should be 1 when there is one city in the list");

        // Add another city and test the count
        list.addCity(new City("Toronto", "Alberta"));
        assertEquals(2, list.getCount(), "Count should be 2 when there are two cities in the list");

        // Remove a city and test the count again
        list.delete(city);
        assertEquals(1, list.getCount(), "Count should be 1 after deleting a city from the list");
    }

}
