package com.pluralsight;

import java.time.LocalDate;

public class Vehicle extends Asset {

    // properties of a vehicle
    private String makeModel;
    private int year;
    private int odometer;

    // constructor to create a new vehicle
    public Vehicle(String description, String dateAcquired, double originalCost,
                   String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    @Override
    // gets value of the vehicle by finding its depreciation rate
    public double getValue() {

        // gets the age of the vehicle by subtracting current year by year of the vehicle
        int vehicleAge = LocalDate.now().getYear() - this.year;

        double depreciationCost = getOriginalCost();

        // if vehicle is 0-3 years old, it's depreciated by 3%
        if (vehicleAge >= 0 && vehicleAge <= 3) {
            depreciationCost -= depreciationCost * 0.03 * vehicleAge;
        } // if vehicle is 4-6 years old, it's depreciated by 6%
        else if (vehicleAge >= 4 && vehicleAge <= 6) {
            depreciationCost -= depreciationCost * 0.06 * vehicleAge;
        } // if vehicle is 7-10 years old, it's depreciated by 8%
        else if (vehicleAge >= 7 && vehicleAge <= 10) {
            depreciationCost -= depreciationCost * 0.08 * vehicleAge;
        } // if vehicle is over 10 years old, it's garbage and only get $1000
        else if (vehicleAge > 10) {
            depreciationCost = 1000;
        }

        // if the odometer is over a hundred thousand miles but is not a Honda or Toyota then it gets a 25% reduction
        // on top of the depreciation value
        if (this.odometer > 100000) {
            if (!this.makeModel.toLowerCase().contains("honda") && !this.makeModel.toLowerCase().contains("toyota")) {
                depreciationCost *= 0.75;
            }
        }

        return depreciationCost;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }
}
