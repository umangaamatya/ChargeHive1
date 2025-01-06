/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chargehive.controller;
import com.chargehive.model.Station;
import java.util.List;

/**
 *
 * @author Umanga Amatya
 */
public class InsertionSort {
    public InsertionSort(){
    
    }
    // Method to sort names alphabetically using insertion sort
   public List<Station> sortAlphabetically(List<Station> stationList) {
        return sort(stationList, true);
    }

    // Public method to sort the list of Station objects in reverse alphabetical order
    public List<Station> sortReverseAlphabetically(List<Station> stationList) {
        return sort(stationList, false);
    }

    // Core sort method with a toggle for ascending/descending order
    private List<Station> sort(List<Station> stationList, boolean ascending) {
        for (int i = 1; i < stationList.size(); i++) {
            Station key = stationList.get(i);
            int insertPosition = findInsertPosition(stationList, key, i, ascending);
            shiftRight(stationList, insertPosition, i);
            stationList.set(insertPosition, key);
        }
        return stationList;
    }

    // Helper method to find the correct position for the current key
    private int findInsertPosition(List<Station> stationList, Station key, int endIndex, boolean ascending) {
        int j = endIndex - 1;
        while (j >= 0 && shouldSwap(stationList.get(j), key, ascending)) {
            j--;
        }
        return j + 1; // Return the insert position
    }

    // Helper method to determine if swapping is needed
    private boolean shouldSwap(Station a, Station b, boolean ascending) {
        int comparison = a.getName().compareTo(b.getName());
        return ascending ? comparison > 0 : comparison < 0;
    }

    // Helper method to shift elements to the right to make space for the key
    private void shiftRight(List<Station> stationList, int start, int end) {
        for (int k = end; k > start; k--) {
            stationList.set(k, stationList.get(k - 1));
        }
    }
}
