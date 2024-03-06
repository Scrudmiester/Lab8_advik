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


}
