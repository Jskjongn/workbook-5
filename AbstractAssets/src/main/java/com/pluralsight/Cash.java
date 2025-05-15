package com.pluralsight;

public class Cash extends Asset{

    private String from;

    public Cash(String description, String dateAcquired, double originalCost, String from) {
        super(description, dateAcquired, originalCost);
        this.from = from;
    }

    @Override
    public double getValue() {

        return this.getOriginalCost();
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
}
