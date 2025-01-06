/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chargehive.controller;

import java.util.ArrayList;
import java.util.List;
import com.chargehive.model.Station;

/**
 *
 * @author Umanga Amatya
 */
public class MergeSort {
    public List<Station> sortByPriceAscending(List<Station> stationList) {
        return mergeSort(stationList, true);
    }

    // Sorts the list by price in descending order
    public List<Station> sortByPriceDescending(List<Station> stationList) {
        return mergeSort(stationList, false);
    }

    // Core merge sort logic 
    private List<Station> mergeSort(List<Station> stationList, boolean ascending) {
        if (stationList.size() <= 1) {
            return stationList; // Base case
        }

        // Divide the list into two halves
        int mid = stationList.size() / 2;
        List<Station> left = new ArrayList<>(stationList.subList(0, mid));
        List<Station> right = new ArrayList<>(stationList.subList(mid, stationList.size()));

        // Recursively sort both halves
        left = mergeSort(left, ascending);
        right = mergeSort(right, ascending);

        // Merge the sorted halves
        return merge(left, right, ascending);
    }

    // Merge two sorted lists into one
    private List<Station> merge(List<Station> left, List<Station> right, boolean ascending) {
        List<Station> merged = new ArrayList<>();
        int i = 0, j = 0;

        // Merge while both lists have elements
        while (i < left.size() && j < right.size()) {
            if (shouldSwap(left.get(i), right.get(j), ascending)) {
                merged.add(left.get(i));
                i++;
            } else {
                merged.add(right.get(j));
                j++;
            }
        }

        // Add remaining elements from the left list
        while (i < left.size()) {
            merged.add(left.get(i));
            i++;
        }

        // Add remaining elements from the right list
        while (j < right.size()) {
            merged.add(right.get(j));
            j++;
        }

        return merged;
    }

    // Determines if the elements should be swapped based on price
    private boolean shouldSwap(Station a, Station b, boolean ascending) {
        return ascending ? a.getPrice() <= b.getPrice() : a.getPrice() > b.getPrice();
    }
}
