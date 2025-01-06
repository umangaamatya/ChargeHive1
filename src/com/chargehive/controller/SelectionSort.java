/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chargehive.controller;

import com.chargehive.model.Station;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Umanga Amatya
 */
public class SelectionSort {
    List<Station> stationSortList;

    
    public SelectionSort(){
        stationSortList = new ArrayList<>();
    }
  
    public List<Station> sortByStationID(List<Station> stationList, boolean isDesc) {
        this.stationSortList.clear();
        this.stationSortList.addAll(stationList);
        if (stationSortList == null || stationSortList.isEmpty()) {
            throw new IllegalArgumentException("Station list cannot be null or empty.");
        }

        for (int i = 0; i < stationSortList.size() - 1; i++) {
            int extremumIndex = findExtremumIndex(stationSortList, i, isDesc);
            if (i != extremumIndex) {
                swap(stationSortList, i, extremumIndex);
            }
        }

        return stationSortList;
    }

    /**
     * Finds the index of the extremum value (minimum or maximum) in the list
     * from the start index.
     *
     * @param stationSortList the list of Station Model objects
     * @param startIndex the index to start searching from
     * @param isDesc specifies whether to find the maximum (true) or minimum
     * (false)
     * @return the index of the extremum value
     */
    private int findExtremumIndex(List<Station> stationSortList, int startIndex, boolean isDesc) {
        int extremumIndex = startIndex;

        for (int j = startIndex + 1; j < stationSortList.size(); j++) {
            if (shouldSwap(stationSortList.get(j).getId(), stationSortList.get(extremumIndex).getId(), isDesc)) {
                extremumIndex = j;
            }
        }

        return extremumIndex;
    }

    private boolean shouldSwap(int current, int extremum, boolean isDesc) {
        return isDesc ? current > extremum : current < extremum;
    }


    private void swap(List<Station> stationSortList, int i, int j) {
        Station temp = stationSortList.get(i);
        stationSortList.set(i, stationSortList.get(j));
        stationSortList.set(j, temp);
    }
}
