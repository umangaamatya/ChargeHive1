/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chargehive.controller;

/**
 *
 * @author amatyaumanga
 */
import javax.swing.JOptionPane;

public class ValidationUtil {

    // Validate if Station ID is in range (6-digit number)
    public static boolean isIdInRange(String stationId) {
        try {
            int id = Integer.parseInt(stationId);

            if (id < 100000 || id > 999999) {
                return false;
            }

            return true;

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Station ID is not valid", "Invalid ID", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    // Validate if the Station Name is valid (letters and spaces only)
    public static boolean isNameValid(String name) {
        return name.matches("^[a-zA-Z ]+$");
    }

    // Validate if the Location is valid (non-empty and not null)
    public static boolean isLocationValid(String location) {
        return location != null && !location.trim().isEmpty();
    }

    // Validate if Availability is either "Available" or "Unavailable"
    public static boolean isAvailabilityValid(String availability) {
        return availability.equalsIgnoreCase("Available") || availability.equalsIgnoreCase("Unavailable");
    }

    // Validate if the Price is in a valid range
    public static boolean isPriceValid(String price) {
        try {
            float pri = Float.parseFloat(price);

            if (pri < 100.0 || pri > 10000.0) { // Example price range: 100.0 to 10000.0
                return false;
            }

            return true;

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Price is invalid", "Invalid Price", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    // Validate if Ports is a valid number
    public static boolean isNum(String num) {
        try {
            Integer.parseInt(num);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Validate if Type is valid (e.g., Fast, Slow)
    public static boolean isTypeValid(String type) {
        return type.equalsIgnoreCase("Fast") || type.equalsIgnoreCase("Slow"); 
    }

    // Check if a field is empty
    public static boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}
