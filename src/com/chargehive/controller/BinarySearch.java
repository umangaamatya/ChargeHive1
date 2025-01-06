/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chargehive.controller;

import java.util.List;
import com.chargehive.model.Station;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

/**
 *
 * @author Umanga Amatya
 */
public class BinarySearch {

    public void searchAndUpdateTable(String searchValue, List<Station> stationList, int left, int right, JTable table) {
        Station foundStation = searchByName(searchValue, stationList, left, right);
        
        // Clear the table and update it with the search result
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear existing rows
        
        if (foundStation != null) {
            model.addRow(new Object[] {
                foundStation.getId(), 
                foundStation.getName(), 
                foundStation.getLocation(),
                foundStation.getAvailability(), 
                foundStation.getPrice(), 
                foundStation.getPorts(), 
                foundStation.getType()
            });
        }
    }

   
    private Station searchByName(String searchValue, List<Station> stationList, int left, int right) {
        // Base case
        if (right < left) {
            return null;
        }

        // Calculate the mid index
        int mid = (left + right) / 2;

        // Compare the search value with the station name at mid
        int comparison = searchValue.compareToIgnoreCase(stationList.get(mid).getName());

        if (comparison == 0) {
            // Match found
            return stationList.get(mid);
        } else if (comparison < 0) {
            // Search in the left half
            return searchByName(searchValue, stationList, left, mid - 1);
        } else {
            // Search in the right half
            return searchByName(searchValue, stationList, mid + 1, right);
        }
    }

}